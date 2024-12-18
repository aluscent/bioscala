package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Positive
import bio.chemistry.Protein.aminoacids.classes.chemical.Basic
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenDonor
import bio.chemistry.Protein.aminoacids.classes.hydropathy.Hydrophilic
import bio.chemistry.Protein.aminoacids.classes.polarity.Polar

case object K extends Positive with Basic with HydrogenDonor with Hydrophilic with Polar {
  override val abbreviation: String = "Lys"

  override val name: String = "Lysine"

  override val volume: Double = 168.6

  override val hydropathyIndex: Double = -3.9
}
