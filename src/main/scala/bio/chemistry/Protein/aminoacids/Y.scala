package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Uncharged
import bio.chemistry.Protein.aminoacids.classes.chemical.Aromatic
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenDonorAcceptor
import bio.chemistry.Protein.aminoacids.classes.hydropathy.HydroNeutral
import bio.chemistry.Protein.aminoacids.classes.polarity.Polar

case object Y
    extends Uncharged
    with Aromatic
    with HydrogenDonorAcceptor
    with HydroNeutral
    with Polar {
  override val abbreviation: String = "Tyr"

  override val name: String = "Tyrosine"

  override val volume: Double = 193.6

  override val hydropathyIndex: Double = -1.3
}
