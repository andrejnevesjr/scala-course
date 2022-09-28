package com.train.app.entity

import com.train.app.config.Time

class JourneyPlanner(trains: Set[Train]) {

// Option using Map and Flatten
// val stations: Set[Station] = trains.map(train => train.stations).flatten
  val stations: Set[Station] = trains.flatMap(_.stations)

  def trainsAt(station: Station): Set[Train] = {
    trains
      .filter(_.stations.contains(station))
  }

  def stopsAt(station: Station): Set[(Time, Train)] = {
    // Option 1 - Using for loop

    // for {
    //   train          <- trains
    //   timeAndStation <- train.schedule if timeAndStation._2 == station
    // } yield timeAndStation._1 -> train

    // Option 2 - Using functional programming
    trains
      .filter(_.stations.contains(station))
      .map(train => train.schedule.filter(_._2.equals(station)).head._1 -> train)

  }

}
