package bio.chemistry.DNA

import bio.chemistry.GappedConvert
import bio.nucleotide.DNA.{NTSymbol, SymbolConvert}

object GappedConvert extends GappedConvert[NTSymbol](Gap, SymbolConvert)
