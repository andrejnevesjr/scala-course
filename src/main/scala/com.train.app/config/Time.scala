package com.train.app.config

object Time {

  def fromMinutes(minutes: Int): Time = {
    Time(minutes / 60, minutes % 60)
  }
}

case class Time(hours: Int = 0, minutes: Int = 0) extends Ordered[Time] {

  // Verify that hours is within 0 and 23
  require(hours >= 0 && hours < 24, "Invalid hours, must be >= 0  and < 24")
  // Verify that minutes is within 0 and 59
  require(minutes >= 0 && minutes < 60, "Invalid minutes, must be >= 0  and < 59")

  val asMinutes: Int = hours * 60 + minutes

  def minus(that: Time): Int = this.asMinutes - that.asMinutes

  def -(that: Time): Int = minus(that)

  // override def toString: String = f"$hours%02d:$minutes%02d"
  // or
  override lazy val toString: String = f"$hours%02d:$minutes%02d"

  override def compare(that: Time): Int = this.asMinutes - that.asMinutes
}
