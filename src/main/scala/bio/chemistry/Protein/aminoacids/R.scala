package bio.chemistry.Protein.aminoacids

import bio.chemistry.Protein.aminoacids.classes.charge.Positive
import bio.chemistry.Protein.aminoacids.classes.chemical.Basic
import bio.chemistry.Protein.aminoacids.classes.hydrogenInteraction.HydrogenDonor
import bio.chemistry.Protein.aminoacids.classes.hydropathy.Hydrophilic
import bio.chemistry.Protein.aminoacids.classes.polarity.Polar

case object R extends Positive with Basic with HydrogenDonor with Hydrophilic with Polar {
  override val abbreviation: String = "Arg"

  override val name: String = "Arginine"

  override val volume: Double = 173.4

  override val hydropathyIndex: Double = -4.5
}
