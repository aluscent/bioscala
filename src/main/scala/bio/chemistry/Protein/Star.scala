package bio.chemistry.Protein

case object * extends AminoAcidCode {
  override val abbreviation: String = "*"
  override val name: String = "Stop"
  override def toString = "*"
}
