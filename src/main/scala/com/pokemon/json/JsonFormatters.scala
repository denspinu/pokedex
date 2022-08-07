package com.pokemon.json

import spray.json._
import DefaultJsonProtocol._
import com.pokemon.models.AOEPokemonItem
import com.pokemon.models.AOEPokemon


object JsonFormatters extends DefaultJsonProtocol {

  implicit val intOrString: JsonFormat[Int | String] = new JsonFormat[Int | String] {
    override def read(json: JsValue): Int | String =
      json match {
        case JsNumber(nb) => nb.toInt
        case JsString(str) => str
        case _ =>
          throw new RuntimeException(s"Invalid js value for intOrString: ${json.prettyPrint}")
      }

    override def write(obj: Int | String): JsValue = {
      obj match {
        case x: Int => JsNumber(x)
        case str: String => JsString(str)
      }
    }
  }

  implicit val pokemonJsonFormat: JsonFormat[AOEPokemonItem] = jsonFormat13(AOEPokemonItem.apply)
  implicit val aoeUnitCostJsonFormat: JsonFormat[AOEPokemon] = jsonFormat2(AOEPokemon.apply)
  implicit val aoeUnitJsonFormat: JsonFormat[AOEUnit] = jsonFormat17(AOEUnit.apply)
  
}
