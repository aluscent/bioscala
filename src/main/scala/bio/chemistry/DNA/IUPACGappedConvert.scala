package bio.chemistry.DNA

import bio.chemistry.GappedConvert
import bio.nucleotide.DNA.NTSymbol

object IUPACGappedConvert extends GappedConvert[NTSymbol](Gap, IUPACNucleotideConvert)
