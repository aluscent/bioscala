package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.AminoAcidCode
import bio.chemistry.Protein.aminoacids.classes.charge.Uncharged
import bio.chemistry.Protein.aminoacids.classes.chemical.Aliphatic
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenNoInteraction
import bio.chemistry.Protein.aminoacids.classes.hydropathy.Hydrophobic
import bio.chemistry.Protein.aminoacids.classes.polarity.NonPolar

class A
    extends Uncharged
    with Aliphatic
    with HydrogenNoInteraction
    with Hydrophobic
    with NonPolar {
  override val abbreviation: String = "Ala"

  override val name: String = "Alanine"

  override val volume: Double = 88.6

  override val hydropathyIndex: Double = 1.8
}
