package com.pokemon.services

import com.pokemon.models.{AOEPokemonItem, AOEPokemon}
import monix.eval.Task
import com.pokemon.Http
import spray.json._
import DefaultJsonProtocol._
import com.pokemon.json.JsonFormatters._
import com.pokemon.AsyncHttp

trait AOEPokemonService {

  def getPokemon(): Seq[AOEPokemonItem]

}

trait AOEPokemonAsyncService {

  def getPokemon(): Task[Seq[AOEPokemonItem]]

}

class AOEPokemonServiceOnHttp(http: Http) extends AOEPokemonService {

  def getPokemon(): Seq[AOEPokemonItem] = {
    http.get("https://pokeapi.co/api/v2/pokemon/name")
      .parseJson
      .asJsObject
      .fields("name")
      .convertTo[Seq[AOEPokemonItem]]
  }

}

class AOEPokemonAsyncServiceOnHttp(http: AsyncHttp) extends AOEPokemonAsyncService {

  def getPokemon(): Task[Seq[AOEPokemonItem]] =
    http.get("https://pokeapi.co/api/v2/pokemon/name")
      .map(content => content
        .parseJson.asJsObject
        .fields("name")
        .convertTo[Seq[AOEPokemonItem]]
      )
   
}