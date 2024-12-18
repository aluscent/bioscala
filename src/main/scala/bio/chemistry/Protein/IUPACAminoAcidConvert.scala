package bio.chemistry.Protein

import bio.chemistry.Protein.aminoacids.iupac.{B, Z, X}

object IUPACAminoAcidConvert extends StringConverter[AminoAcidCode] {
  /** Create a IUPAC object from its character representation. */
  def fromChar(c: Char): AminoAcidCode = {
    c.toUpper match {
      case 'B' => B
      case 'Z' => Z
      case 'X' => X
      case _ => AminoAcidConvert.fromChar(c)
    }
  }

  def fromItem(i: AminoAcidCode): AminoAcidCode = {
    i match {
      case B => B
      case Z => Z
      case X => X
      case _ =>
        throw new IllegalArgumentException("Unexpected type " + i + " type " + i.getClass.getName)
    }
  }
}