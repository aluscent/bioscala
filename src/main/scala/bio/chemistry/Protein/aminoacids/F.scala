package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Uncharged
import bio.chemistry.Protein.aminoacids.classes.chemical.Aromatic
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenNoInteraction
import bio.chemistry.Protein.aminoacids.classes.hydropathy.Hydrophobic
import bio.chemistry.Protein.aminoacids.classes.polarity.NonPolar

case object F
    extends Uncharged
    with Aromatic
    with HydrogenNoInteraction
    with Hydrophobic
    with NonPolar {
  override val abbreviation: String = "Phe"

  override val name: String = "Phenylalanine"

  override val volume: Double = 189.9

  override val hydropathyIndex: Double = 2.8
}
