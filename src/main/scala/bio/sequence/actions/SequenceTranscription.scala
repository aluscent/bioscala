package bio.sequence.actions

import bio.nucleotide.DNA.{A, C, G, T}
import bio.nucleotide.DNA.{Nucleotide => DNANucleotide}
import bio.nucleotide.RNA.{Nucleotide => RNANucleotide}
import bio.nucleotide.RNA

/** Sequence transcription and complement. Delegated by the Sequence object.
  * Note we take a functional approach (no reference to self).
  */
object SequenceTranscription {

  /** Convert DNA to RNA - replacing DNA.T with RNA.U. The 5'-3' order
    * is maintained
    */
  def toRNA(nucleotides: List[DNANucleotide]): List[RNANucleotide] = {
    nucleotides.map {
      case A => RNA.A
      case C => RNA.C
      case G => RNA.G
      case T => RNA.U
      case nt =>
        throw new IllegalArgumentException(
          "non DNA nucleotide " + nt + " type " + nt.getClass.getName
        )
    }
  }

  /** Transcribe DNA to RNA, the 5'-3' order is maintained (unlike BioJAVA)
    */
  def transcribe(nucleotides: List[DNANucleotide]): List[RNANucleotide] = toRNA(nucleotides)

  /** Complement nucleotides - note: no support for Ambiguous symbols.
    */
  def complement(nucleotides: List[DNANucleotide]): List[DNANucleotide] = {
    nucleotides.map {
      case A => T
      case T => A
      case C => G
      case G => C
      case nt =>
        throw new IllegalArgumentException(
          "non DNA nucleotide " + nt + " type " + nt.getClass.getName
        )
    }
  }
}
