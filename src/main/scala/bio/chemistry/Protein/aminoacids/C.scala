package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Uncharged
import bio.chemistry.Protein.aminoacids.classes.chemical.Sulfur
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenNoInteraction
import bio.chemistry.Protein.aminoacids.classes.hydropathy.Hydrophobic
import bio.chemistry.Protein.aminoacids.classes.polarity.NonPolar

case object C
    extends Uncharged
    with Sulfur
    with HydrogenNoInteraction
    with Hydrophobic
    with NonPolar {
  override val abbreviation: String = "Cys"

  override val name: String = "Cysteine"

  override val volume: Double = 108.5

  override val hydropathyIndex: Double = 2.5
}
