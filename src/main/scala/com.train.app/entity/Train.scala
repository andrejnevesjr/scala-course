package com.train.app.entity

import com.train.app.config.Time

case class Train(info: TrainInfo, schedule: Seq[(Time, Station)]) {

  require(schedule.size > 0, "Schedule must contain at least 1 pair (Time, Station).")

  def getTrainInfo = println(s" Train Number: ${info.number}")

  val stations: Seq[Station] = schedule.map(_._2)

}

sealed abstract class TrainInfo {
  def number: Int
}

case class InterCityExpress(override val number: Int, hasWifi: Boolean = false) extends TrainInfo
case class RegionalExpress(override val number: Int) extends TrainInfo
case class BavarianRegional(override val number: Int) extends TrainInfo
