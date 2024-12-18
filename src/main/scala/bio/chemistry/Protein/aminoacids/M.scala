package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Uncharged
import bio.chemistry.Protein.aminoacids.classes.chemical.Sulfur
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenNoInteraction
import bio.chemistry.Protein.aminoacids.classes.hydropathy.Hydrophobic
import bio.chemistry.Protein.aminoacids.classes.polarity.NonPolar

case object M
    extends Uncharged
    with Sulfur
    with HydrogenNoInteraction
    with Hydrophobic
    with NonPolar {
  override val abbreviation: String = "Met"

  override val name: String = "Methionine"

  override val volume: Double = 162.9

  override val hydropathyIndex: Double = 1.9
}
