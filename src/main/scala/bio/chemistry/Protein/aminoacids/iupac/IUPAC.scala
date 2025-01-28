package bio.chemistry.Protein.aminoacids.iupac

import bio.chemistry.Protein.AminoAcidCode

abstract class IUPAC(abb: String, fullname: String) extends AminoAcidCode {
  override val abbreviation: String = abb

  override val name: String = fullname
}
