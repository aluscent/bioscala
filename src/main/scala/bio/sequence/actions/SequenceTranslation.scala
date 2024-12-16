package bio.sequence.actions

import org.biojava.bio.seq.RNATools
import bio.chemistry.Protein.IUPACGappedConvert
import bio.chemistry.Protein.AASymbol

/** Sequence translation is a trait.
 */
class SequenceTranslation[T] {

  /** Translate RNA to amino acids using the BioJAVA library.
    *
    * When ambiguous symbols are used (IUPAC) the codon
    * translates to X. Which it apparently does with BioJava3.
    *
    * Also for BioJava3 the sequence needs to consist of true
    * codons. In this function the tail is chopped to resize,
    * unlike the EMBOSS version, which will even translate
    * a partial codon, when possible.
    *
    * With translation triple gaps are translated to a single AA
    * gap. In fact, anything with a gap gets to be a gap. When
    * an unknown character is introduced the AA becomes X. So:
    *
    * "agc---a-n" translates to "S--"
    * "agc---agn" translates to "S-X"
    */
  def translate(nucleotides: List[T]): List[AASymbol] = {
    val remove = nucleotides.size % 3
    val rna = RNATools.createRNA(nucleotides.dropRight(remove).mkString)
    val aa = RNATools.translate(rna)
    IUPACGappedConvert.fromString(aa.seqString)
  }
}
