package bio.chemistry.Protein

abstract class AminoAcidCode private[Protein] extends AASymbol {
  val abbreviation: String

  val name: String

  override def toString: String = s"$name($abbreviation)"
}
