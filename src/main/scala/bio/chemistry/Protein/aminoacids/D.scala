package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Negative
import bio.chemistry.Protein.aminoacids.classes.chemical.Acidic
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenAcceptor
import bio.chemistry.Protein.aminoacids.classes.hydropathy.Hydrophilic
import bio.chemistry.Protein.aminoacids.classes.polarity.Polar

case object D
    extends Negative
    with Acidic
    with HydrogenAcceptor
    with Hydrophilic
    with Polar {
  override val abbreviation: String = "Asp"

  override val name: String = "Aspartic Acid"

  override val volume: Double = 111.1

  override val hydropathyIndex: Double = -3.5
}
