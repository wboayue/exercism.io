# -*- coding: utf-8 -*-

dna_to_rna = {'G': 'C', 'C': 'G', 'T': 'A', 'A': 'U'}

def to_rna(dna_strand):
  return ''.join([dna_to_rna[nucleotide] for nucleotide in dna_strand])
