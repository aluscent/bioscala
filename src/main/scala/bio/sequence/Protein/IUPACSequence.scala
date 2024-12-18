package bio.sequence.Protein

import bio.attribute.Attribute
import bio.attribute.{Description, Id}
import bio.chemistry.Protein.{AminoAcidCode, IUPACAminoAcidConvert}
import bio.sequence

/** AminoAcid Sequence supporting ambiguous IUPAC symbols
  */
class IUPACSequence(seqList: List[AminoAcidCode], attributeList: List[Attribute])
    extends sequence.Sequence[AminoAcidCode](seqList, attributeList) {

  type SequenceType = IUPACSequence

  def create(seqList: List[AminoAcidCode], attributeList: List[Attribute]) =
    new IUPACSequence(seqList, attributeList)
}

object IUPACSequence {
  def apply(list: List[AminoAcidCode]) = new IUPACSequence(IUPACAminoAcidConvert.fromList(list), Nil)

  def apply(str: String) = new IUPACSequence(IUPACAminoAcidConvert.fromString(str), Nil)

  def apply(id: String, str: String) =
    new IUPACSequence(IUPACAminoAcidConvert.fromString(str), List(Id(id)))

  def apply(id: String, descr: String, str: String) =
    new IUPACSequence(IUPACAminoAcidConvert.fromString(str), List(Id(id), Description(descr)))

  def apply(sequence: Sequence) = new IUPACSequence(sequence.seq, Nil)
}
