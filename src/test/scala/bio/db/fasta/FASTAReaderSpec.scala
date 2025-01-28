package bio.db.fasta

import bio.sequence.{DNA, Protein}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class FASTAReaderSpec extends AnyFlatSpec with Matchers {
  "FASTAReader" should "read from NT file" in {
    val f = FASTAReader("src/test/resources/fasta/nt.fa")
    val ids = f.getAllSequences.map { res =>
      val (tag, _) = res
      tag.split(Array(' ', '\t'))(0)
    }.toList
    ids.head should equal("PUT-157a-Arabidopsis_thaliana-1")
  }

  "FASTAReader" should "balk on nucleotide N with standard Sequence" in {
    val f = FASTAReader("src/test/resources/fasta/nt.fa")
    an[IllegalArgumentException] should be thrownBy {
      f.getAllSequences.map { res =>
        val (tag, dna) = res
        DNA.DNASequence(tag.split(Array(' ', '\t'))(0), tag, dna.seq.mkString)
      }.toList
    }
  }

  "FASTAReader" should "be able to convert NT to IUPACSequence" in {
    val f = FASTAReader("src/test/resources/fasta/nt.fa")
    val seqs = f.getAllSequences.map { res =>
      val (tag, dna) = res
      DNA.IUPACSequence(tag.split(Array(' ', '\t'))(0), tag, dna.seq.mkString)
    }.toList
    seqs.head.id should equal("PUT-157a-Arabidopsis_thaliana-1")
  }

  // ---- AminoAcid's
  "FASTAReader" should "read from AA file" in {
    val f = FASTAReader("src/test/resources/fasta/aa.fa")
    val ids = f.getAllSequences.map { res =>
      val (tag, _) = res
      tag.split(Array(' ', '\t'))(0)
    }.toList
    ids.head should equal("BAHG_VITSP")
  }

  "FASTAReader" should "balk on standard Sequence: Unexpected value for AminoAcid X" in {
    val f = FASTAReader("src/test/resources/fasta/aa.fa")
    an[IllegalArgumentException] should be thrownBy {
      f.getAllSequences.map { res =>
        val (tag, dna) = res
        Protein.Sequence(tag.split(Array(' ', '\t'))(0), tag, dna.seq.mkString)
      }.toList
    }
  }

  "FASTAReader" should "be able to convert AA to IUPACSequence" in {
    val f = FASTAReader("src/test/resources/fasta/aa.fa")
    val seqs = f.getAllSequences.map { res =>
      val (tag, dna) = res
      Protein.IUPACSequence(tag.split(Array(' ', '\t'))(0), tag, dna.seq.mkString)
    }.toList
    seqs.head.id should equal("BAHG_VITSP")
  }

  // ---- Codons
  "FASTAReader" should "be able to convert NT to CodonSequence" in {
    val f = FASTAReader("src/test/resources/fasta/nt.fa")
    val seqs = f.getAllSequences.map { res =>
      val (tag, dna) = res
      Protein.CodonSequence(tag.split(Array(' ', '\t'))(0), tag, dna.seq.mkString)
    }.toList
    seqs.head.toDNA.take(5).mkString should equal("aggtt")
  }
}

