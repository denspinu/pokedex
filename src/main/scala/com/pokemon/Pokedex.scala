package com.pokemon

import okhttp3.{OkHttpClient, Request}
import com.pokemon.services.AOEPokemonService
import com.pokemon.services.AOEPokemonServiceOnHttp
import com.pokemon.services.AOEPokemonAsyncServiceOnHttp
import monix.execution.Scheduler.Implicits.global

import scala.util.control.NonFatal

object Pokedex {

def main(args: Array[String]): Unit =
    val pokScv = new AOEPokemonAsyncServiceOnHttp(http = new AsyncHttp)

    pokScv.getPokemon()
      .runAsync {
        case Left(err) =>
          println(s"Got err: ${err.toString}")
        case Right(units) =>
          println(units.head)
      }
}
