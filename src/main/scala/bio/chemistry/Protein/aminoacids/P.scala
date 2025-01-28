package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Uncharged
import bio.chemistry.Protein.aminoacids.classes.chemical.Aliphatic
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenNoInteraction
import bio.chemistry.Protein.aminoacids.classes.hydropathy.HydroNeutral
import bio.chemistry.Protein.aminoacids.classes.polarity.NonPolar

case object P
    extends Uncharged
    with Aliphatic
    with HydrogenNoInteraction
    with HydroNeutral
    with NonPolar {
  override val abbreviation: String = "Pro"

  override val name: String = "Proline"

  override val volume: Double = 112.7

  override val hydropathyIndex: Double = -1.6
}
