package bio.sequence.Protein

import bio.nucleotide.DNA.NTSymbol
import bio.attribute.{Description, Id}
import bio.chemistry.Protein.{AASymbol, CodonSymbol}
import bio.Attribute
import bio.nucleotide.DNA.{NTSymbol => DNANTSymbol}
import bio.nucleotide.RNA.{NTSymbol => RNANTSymbol}

class GappedCodonSequence(codonList: List[CodonSymbol], attributeList: List[Attribute])
  extends bio.sequence.Sequence[CodonSymbol](codonList, attributeList) {

  type SequenceType = GappedCodonSequence

  def create(seqList: List[CodonSymbol], attributeList: List[Attribute]) =
    new GappedCodonSequence(seqList, attributeList)

  def getCodon(n: Int): List[NTSymbol] = seq(n).getCodon

  def toAminoAcid: List[AASymbol] = seq.map { codon => codon.getAminoAcid }

  def toDNA: List[DNANTSymbol] = seq.flatMap { codon => codon.getCodon }

  def toRNA: List[RNANTSymbol] = bio.sequence.DNA.IUPACGappedSequence(toDNA).transcribe.toList

  override def toString: String = toAminoAcid.mkString
}

object GappedCodonSequence {
  def apply(id: String, list: List[CodonSymbol]) = new GappedCodonSequence(list, List(Id(id)))

  def apply(str: String) = new GappedCodonSequence(GappedDNAtoCodon(str), Nil)

  def apply(id: String, str: String) = new GappedCodonSequence(GappedDNAtoCodon(str), List(Id(id)))

  def apply(id: String, descr: String, str: String) =
    new GappedCodonSequence(GappedDNAtoCodon(str), List(Id(id), Description(descr)))
}
