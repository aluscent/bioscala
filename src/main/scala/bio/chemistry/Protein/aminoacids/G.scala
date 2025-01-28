package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Uncharged
import bio.chemistry.Protein.aminoacids.classes.chemical.Aliphatic
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenNoInteraction
import bio.chemistry.Protein.aminoacids.classes.hydropathy.HydroNeutral
import bio.chemistry.Protein.aminoacids.classes.polarity.NonPolar

case object G
    extends Uncharged
    with Aliphatic
    with HydrogenNoInteraction
    with HydroNeutral
    with NonPolar {
  override val abbreviation: String = "Gly"

  override val name: String = "Glycine"

  override val volume: Double = 60.1

  override val hydropathyIndex: Double = -0.4
}
