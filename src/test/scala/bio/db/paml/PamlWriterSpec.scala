package bio.db.paml

import bio.db.fasta.FASTAReader
import bio.sequence.DNA.GappedSequence
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import java.io._

class PamlWriterSpec extends AnyFlatSpec with Matchers {
  "PamlWriter" should "write PAML file" in {
    val f = FASTAReader("src/test/resources/fasta/nt_aln.fa")
    val seqList = f.getAllSequences.map { res =>
      val (tag, dna) = res
      val seq = GappedSequence(tag.split(Array(' ', '\t'))(0), tag, dna.seq.mkString)
      seq
    }.toList
    val tmpfn = File.createTempFile("BioScala-PAML-", ".phy")
    import bio.io.Control._
    using(new FileOutputStream(tmpfn)) { stream =>
      // 2x write
      new PamlWriter(stream).write(seqList)
      new PamlWriter(stream).write(seqList)
    }
    seqList.head.id should equal("PITG_04081T0")
  }
}
