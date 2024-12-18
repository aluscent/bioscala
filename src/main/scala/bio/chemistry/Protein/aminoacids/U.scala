package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Uncharged
import bio.chemistry.Protein.aminoacids.classes.chemical.Sulfur
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenDonor
import bio.chemistry.Protein.aminoacids.classes.hydropathy.Hydrophobic
import bio.chemistry.Protein.aminoacids.classes.polarity.Polar

case object U
    extends Uncharged
    with Sulfur
    with HydrogenDonor
    with Hydrophobic
    with Polar {
  override val abbreviation: String = "Sec"

  override val name: String = "Selenocysteine"

  override val volume: Double = 120.0

  override val hydropathyIndex: Double = 1.9
}
