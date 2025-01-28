package bio.db.fasta

import bio.sequence.AbstractSequence

import java.io._
import scala.annotation.tailrec

/** FASTAWriter writes a list of sequences to a file in FASTA format.
  */
class FASTAWriter(val fOut: FileOutputStream) {
  class FASTAWriterException(string: String) extends Exception(string)

  var sequence_width = 70

  def this(f: File) = this(new FileOutputStream(f))

  def this(filen: String) = this(new FileOutputStream(filen))

  /** Write FASTA FASTA format.
    *
    * Example:
    *
    * import bio.io.Control._
    * val tmpfn = File.createTempFile("BioScala-FASTA-",".fa")
    * using(new FileOutputStream(tmpfn)) { stream =>
    * new FASTAWriter(stream).write(seqList)
    * }
    */
  def write[T <: AbstractSequence](list: List[T]): Unit = {
    val writer = new OutputStreamWriter(fOut)
    list.foreach { seq =>
      @tailrec
      def write_seq(list: List[Any]): Unit = {
        val (w, rest) = list.splitAt(sequence_width)
        writer.write(w.mkString + "\n")
        rest match {
          case Nil =>
          case _ =>
            write_seq(rest)
        }
      }

      if (sequence_width > 0) {
        writer.write(">" + seq.id)
        if (seq.hasDescription) writer.write(" " + seq.description)
        writer.write("\n")
        write_seq(seq.toList)
      } else {
        writer.write(seq.id + "  " + seq.toString + "\n")
      }
    }
    writer.flush() // expected before close(!)
  }
}
