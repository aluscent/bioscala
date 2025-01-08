package bio.chemistry.RNA

import bio.chemistry.GappedConvert
import bio.nucleotide.RNA.NTSymbol

object IUPACGappedConvert extends GappedConvert[NTSymbol](Gap, IUPACNucleotideConvert)
