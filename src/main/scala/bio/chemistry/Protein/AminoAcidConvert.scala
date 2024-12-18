package bio.chemistry.Protein

import bio.chemistry.Protein.aminoacids.{A, C, D, E, F, G, H, I, K, L, M, N, P, Q, R, S, T, U, V, W, Y}

object AminoAcidConvert extends StringConverter[AminoAcidCode] {

  /** AminoAcid factory: create a AminoAcid object from its
   * character representation. For example:
   *
   * <pre>
   * import bio._
   * val aa = AminoAcidConvert.fromChar('a')
   * </pre>
   */
  def fromChar(c: Char): AminoAcidCode = {
    c.toUpper match {
      case 'R' => R
      case 'H' => H
      case 'K' => K
      case 'D' => D
      case 'E' => E
      case 'S' => S
      case 'T' => T
      case 'N' => N
      case 'Q' => Q
      case 'C' => C
      case 'U' => U
      case 'G' => G
      case 'P' => P
      case 'A' => A
      case 'I' => I
      case 'L' => L
      case 'M' => M
      case 'F' => F
      case 'W' => W
      case 'Y' => Y
      case 'V' => V
      case '*' => *
      case _   => throw new IllegalArgumentException("Unexpected value for AminoAcidCode " + c)
    }
  }

  def fromItem(i: AminoAcidCode): AminoAcidCode = {
    i match {
      case R => R
      case H => H
      case K => K
      case D => D
      case E => E
      case S => S
      case T => T
      case N => N
      case Q => Q
      case C => C
      case U => U
      case G => G
      case P => P
      case A => A
      case I => I
      case L => L
      case M => M
      case F => F
      case W => W
      case Y => Y
      case V => V
      case * => *
      case _ =>
        throw new IllegalArgumentException(
          "Can not construct AminoAcidCode from unknown " + i + " type (should be AminoAcidCode) " + i.getClass.getName
        )
    }
  }
}
