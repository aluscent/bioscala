package bio.chemistry.Protein.aminoacids.classes.charge

import bio.chemistry.Protein.ProteinogenicAminoAcid

trait Uncharged extends ProteinogenicAminoAcid {
  val charge: String = "neutral"
}
