package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Uncharged
import bio.chemistry.Protein.aminoacids.classes.chemical.Hydroxyl
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenDonorAcceptor
import bio.chemistry.Protein.aminoacids.classes.hydropathy.HydroNeutral
import bio.chemistry.Protein.aminoacids.classes.polarity.Polar

case object S
    extends Uncharged
    with Hydroxyl
    with HydrogenDonorAcceptor
    with HydroNeutral
    with Polar {
  override val abbreviation: String = "Ser"

  override val name: String = "Serine"

  override val volume: Double = 89.0

  override val hydropathyIndex: Double = -0.8
}
