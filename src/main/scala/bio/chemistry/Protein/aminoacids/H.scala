package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Positive
import bio.chemistry.Protein.aminoacids.classes.chemical.Basic
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenDonorAcceptor
import bio.chemistry.Protein.aminoacids.classes.hydropathy.HydroNeutral
import bio.chemistry.Protein.aminoacids.classes.polarity.Polar

case object H
    extends Positive
    with Basic
    with HydrogenDonorAcceptor
    with HydroNeutral
    with Polar {
  override val abbreviation: String = "His"

  override val name: String = "Histidine"

  override val volume: Double = 153.2

  override val hydropathyIndex: Double = -3.2
}
