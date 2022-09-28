package com.train.app

import com.train.app.config.Time
import com.train.app.entity.{InterCityExpress, JourneyPlanner, RegionalExpress, Station, Train}

object Main {
  def main(args: Array[String]): Unit = {

    // Instance of Train
    val trainLisbonPorto =
      Train(
        RegionalExpress(504),
        Seq(
          (Time(1, 10), Station("Santo Apolonia")),
          (Time(1, 25), Station("Oriente")),
          (Time(4, 45), Station("Aveiro")),
          (Time(5, 30), Station("Porto"))))

    val trainLisbonAveiro =
      Train(
        InterCityExpress(702),
        Seq(
          (Time(1, 20), Station("Santo Apolonia")),
          (Time(1, 35), Station("Oriente")),
          (Time(4, 55), Station("Aveiro"))))

    // Instance of JourneyPlanner
    val journeyTrains = new JourneyPlanner(Set(trainLisbonAveiro, trainLisbonPorto))
    // Filtering trains going or passing by some station
    val stationToFind = Station("Aveiro")
    journeyTrains
      .trainsAt(stationToFind)
      .map(x => s"Train: ${x.info.number} | Stops: ${x.schedule.map(_._2.name).mkString(", ")}")
      .foreach(println)

    // Filtering trains stoping in some station
    journeyTrains.stopsAt(stationToFind).foreach(println)

  }
}
