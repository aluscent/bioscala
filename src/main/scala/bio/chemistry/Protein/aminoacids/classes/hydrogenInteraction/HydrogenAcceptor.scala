package bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction

import bio.chemistry.Protein.ProteinogenicAminoAcid

trait HydrogenAcceptor extends ProteinogenicAminoAcid {
   val hydrogenInteraction: String = "acceptor"
}
