package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Uncharged
import bio.chemistry.Protein.aminoacids.classes.chemical.Aliphatic
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenNoInteraction
import bio.chemistry.Protein.aminoacids.classes.hydropathy.Hydrophobic
import bio.chemistry.Protein.aminoacids.classes.polarity.NonPolar

case object V
    extends Uncharged
    with Aliphatic
    with HydrogenNoInteraction
    with Hydrophobic
    with NonPolar {
  override val abbreviation: String = "Val"

  override val name: String = "Valine"

  override val volume: Double = 140.0

  override val hydropathyIndex: Double = 4.2
}
