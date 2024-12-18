package bio.chemistry.Protein.aminoacids.classes.hydropathy

import bio.chemistry.Protein.ProteinogenicAminoAcid

trait Hydrophobic extends ProteinogenicAminoAcid {
   val hydropathy: String = "hydrophobic"
}
