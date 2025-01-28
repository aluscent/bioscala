package bio.chemistry.Protein.aminoacids.classes.charge

import bio.chemistry.Protein.ProteinogenicAminoAcid

trait Positive extends ProteinogenicAminoAcid {
  val charge: String = "positive"
}
