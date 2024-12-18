package bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction

import bio.chemistry.Protein.ProteinogenicAminoAcid

trait HydrogenDonorAcceptor extends ProteinogenicAminoAcid {
   val hydrogenInteraction: String = "donor and acceptor"
}
