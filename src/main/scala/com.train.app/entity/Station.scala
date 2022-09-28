package com.train.app.entity

case class Station(name: String) {
  // Requires at least one Station
  require(!name.isEmpty(), "Invalid station, please add a valid entry!")
}
