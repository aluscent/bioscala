package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Uncharged
import bio.chemistry.Protein.aminoacids.classes.chemical.Aromatic
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenDonor
import bio.chemistry.Protein.aminoacids.classes.hydropathy.Hydrophobic
import bio.chemistry.Protein.aminoacids.classes.polarity.NonPolar

case object W
    extends Uncharged
    with Aromatic
    with HydrogenDonor
    with Hydrophobic
    with NonPolar {
  override val abbreviation: String = "Trp"

  override val name: String = "Tryptophan"

  override val volume: Double = 227.8

  override val hydropathyIndex: Double = -0.9
}
