package bio.db.fasta

import bio.sequence.DNA.DNASequence
import bio.sequence.RNA.RNASequence
import bio.sequence.Sequence
import org.biojava.bio.symbol.AlphabetManager
import org.biojavax.RichObjectFactory
import org.biojavax.bio.seq.RichSequence
import org.biojavax.bio.seq.io.{FastaFormat, RichSequenceBuilderFactory, RichStreamReader}

import java.io.{BufferedReader, FileReader}

/** FASTAReader iterates over a FASTA file, returning Sequence objects, without
  * storing the whole database in RAM (unlike many other implementations).
  *
  * Sequences are expected to be represented in the standard IUB/IUPAC amino
  * acid and nucleic acid codes, with these exceptions: lower-case letters
  * are accepted and are mapped into upper-case; a single hyphen or dash can
  * be used to represent a gap of indeterminate length; and in amino acid
  * sequences, U and * are acceptable letters (see below). Before submitting
  * a request, any numerical digits in the query sequence should either be
  * removed or replaced by appropriate letter codes (e.g., N for unknown
  * nucleic acid residue or X for unknown amino acid residue).
  */
class FASTAReader(filePath: String, tokensType: String)
  extends RichStreamReader(new BufferedReader(new FileReader(filePath)),
    new FastaFormat(),
    AlphabetManager.alphabetForName(tokensType).getTokenization("token"),
    RichSequenceBuilderFactory.FACTORY,
    RichObjectFactory.getDefaultNamespace) {

  private case class FASTARichSequence(tag: String, rs: RichSequence) {
    lazy val toBioScalaSequence: Sequence[_] = tokensType match {
      case "DNA" => DNASequence(rs.getInternalSymbolList.seqString())
      case "RNA" => RNASequence(rs.getInternalSymbolList.seqString())
      case "Protein" => bio.sequence.Protein.Sequence(rs.getInternalSymbolList.seqString())
    }
  }

  private lazy val sequenceList: LazyList[FASTARichSequence] = LazyList.unfold(this) { s =>
    if (s.hasNext) {
      val next = s.nextRichSequence()
      Some(FASTARichSequence(next.getName, next) -> s)
    } else None
  }

  def getTagsWithIndexes: LazyList[(String, Int)] = sequenceList.zipWithIndex.map {
    case (sequence, index) => sequence.tag -> index
  }

  def getAllSequences: LazyList[(String, Sequence[_])] =
    sequenceList.map(s => s.tag -> s.toBioScalaSequence)

  def getSequenceByIndex(index: Int): Sequence[_] =
    if (index < sequenceList.length && index >= 0)
      sequenceList.slice(index, index + 1).head.toBioScalaSequence
    else throw new ArrayIndexOutOfBoundsException()

  def getSequenceByTag(tag: String): FASTARichSequence =
    sequenceList.filter(_.tag == tag).head
}

object FASTAReader {
  def apply(filePath: String, tokenType: String = "DNA") =
    new FASTAReader(filePath, tokenType)
}
