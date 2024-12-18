package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Uncharged
import bio.chemistry.Protein.aminoacids.classes.chemical.Aliphatic
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenNoInteraction
import bio.chemistry.Protein.aminoacids.classes.hydropathy.Hydrophobic
import bio.chemistry.Protein.aminoacids.classes.polarity.NonPolar

case object I
    extends Uncharged
    with Aliphatic
    with HydrogenNoInteraction
    with Hydrophobic
    with NonPolar {
  override val abbreviation: String = "Ile"

  override val name: String = "Isoleucine"

  override val volume: Double = 166.7

  override val hydropathyIndex: Double = 4.5
}
