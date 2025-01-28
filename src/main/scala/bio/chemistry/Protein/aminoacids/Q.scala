package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Uncharged
import bio.chemistry.Protein.aminoacids.classes.chemical.Amide
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenDonorAcceptor
import bio.chemistry.Protein.aminoacids.classes.hydropathy.Hydrophilic
import bio.chemistry.Protein.aminoacids.classes.polarity.Polar

case object Q
    extends Uncharged
    with Amide
    with HydrogenDonorAcceptor
    with Hydrophilic
    with Polar {
  override val abbreviation: String = "Gln"

  override val name: String = "Glutamine"

  override val volume: Double = 143.8

  override val hydropathyIndex: Double = -3.5
}
