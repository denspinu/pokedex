package com.pokemon.models


case class AOEPokemon(
    name: String,
    url: String,
)

case class AOEPokemonItem(
  id: Int,
  name: String,
  type1: String,
  type2: String,
  attack: Int,
  defense: Int,
  spAttack: Int,
  spDefense: Int,
  speed: Int,
  generation: Int,
  moveset: String,
  legendary: Boolean,
  evolution_path: String,
)