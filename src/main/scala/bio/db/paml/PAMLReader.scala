package bio.db.paml

import java.io.{BufferedReader, FileReader}
import java.io.IOException
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util
import scala.jdk.CollectionConverters._

/** PAMLReader opens a file and parses the PAML PHYLIP CODON contents using an
  * iterator. Rather than using BioJava's PHYLIPReader, which only allows 9
  * char tags, we roll our own as PAML is more relaxed on the tag. PAML wants
  * more than 2 spaces after the ID. Essentially it is a simple format, where
  * you know the size of the sequences - just remove the spaces.
  *
  * Note: no support for interleaved files
  */
class PAMLReader(val filename: String) extends Iterator[(String, String)] {
  private val reader = new BufferedReader(new FileReader(filename))

  class PamlReadException(string: String) extends Exception(string)

  def header(): (Int, Int) = {
    val firstline = reader.readLine

    val Match = """^\s*(\d+)\s+(\d+)""".r
    val (num, size) = firstline match {
      case Match(num1, size1) => (num1.toInt, size1.toInt)
    }
    (num, size)
  }

  val (seq_num, seq_size) = header()

  def hasNext(): Boolean = reader.ready

  def next(): (String, String) = {
    // parse ID
    val line = reader.readLine.toList
    val (id, rest) = line.span { c => c != ' ' }
    // keep reading lines until we have the right sequence size
    var seq: List[Char] = rest
    do {
      seq = seq.filterNot(c => c == ' ' || c == '\t')
      if (seq.length == seq_size) {
        return (id.mkString, seq.mkString)
      }
      if (seq.length > seq_size)
        throw new PamlReadException(
          "Input file problem in " + filename + " with " + id.mkString + " <" + seq.mkString + ">"
        )
      if (!reader.ready)
        throw new PamlReadException("EOF problem in " + filename)
      seq = seq ::: reader.readLine.toList
    } while (true)
    null // never reached code
  }
}

class ModernPAMLReader(filePath: String) {
  private val fileChannel = FileChannel.open(Paths.get(filePath), StandardOpenOption.READ)
  private val buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size())

  private def sequenceList: util.HashSet[StringBuilder] = {
//    val sampler = Array.fill[Byte](256)(0)
    var sb = new StringBuilder()
    val sl = new util.HashSet[StringBuilder]()
    while (buffer.hasRemaining) {
      val ba = buffer.get().toChar
      if (ba == '\n') {
        sb.append(ba)
        sl.add(sb)
        sb = new StringBuilder()
      } else sb.append(ba)
    }

    sl
  }

  def parseFile(): util.HashMap[String, StringBuilder] = {
    val hm = new util.HashMap[String, StringBuilder]()
    println("Sequences: " + sequenceList)

    sequenceList.stream().toList.asScala
      .map { ch =>
        val (tag, seq) = ch.splitAt(ch.indexWhere(_ == ' '))
        println(s"Tag: ${tag.mkString}\n$seq")
        hm.put(tag.mkString, seq)
      }

    hm
  }

  def close(): Unit = fileChannel.close()
}
