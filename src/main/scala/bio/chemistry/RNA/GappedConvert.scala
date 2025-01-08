package bio.chemistry.RNA

import bio.chemistry.GappedConvert
import bio.nucleotide.RNA.{NTSymbol, SymbolConvert}

object GappedConvert extends GappedConvert[NTSymbol](Gap, SymbolConvert)
