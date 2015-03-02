package occur.example

import spire.math.{Interval}
import spire.implicits._


/**
 * Created by sisir on 3/2/15.
 */

trait AllenAlgebra {
  def before(x: IntervalOccur): Boolean
  def meets(x: IntervalOccur): Boolean
  def overlaps(x: IntervalOccur): Boolean
  def starts(x: IntervalOccur): Boolean
  def during(x: IntervalOccur): Boolean
  def finishes(x: IntervalOccur): Boolean
  def equals(x: IntervalOccur): Boolean
  def finishedBy(x: IntervalOccur): Boolean
  def includes(x: IntervalOccur): Boolean
  def startedBy(x: IntervalOccur): Boolean
  def overlappedBy(x: IntervalOccur): Boolean
  def metBy(x: IntervalOccur): Boolean
  def after(x: IntervalOccur): Boolean
}

class IntervalOccur(s: Double, e: Double) extends AllenAlgebra {
  //var i: Interval[Double] =  Interval[Double](s, e) {override def upperBound: Bound[Double] = e

  //  override def lowerBound: Bound[Double] = s
  //}

  val i = Interval(s: Double, e: Double)
  val i_lb = i.lowerBound.asInstanceOf[Double]
  val i_ub = i.upperBound.asInstanceOf[Double]

  override def before(obj: IntervalOccur): Boolean =
    //i.lowerBound.toDouble() < obj.i.lowerBound.toDouble()
    i.upperBound.asInstanceOf[Double] < obj.i.lowerBound.asInstanceOf[Double]

  override def meets(obj: IntervalOccur): Boolean =
    (i.lowerBound.asInstanceOf[Double] < obj.i.lowerBound.asInstanceOf[Double]) && (i.upperBound.asInstanceOf[Double] == obj.i.upperBound.asInstanceOf[Double])

  override def overlaps(obj: IntervalOccur): Boolean =
    (i.lowerBound.asInstanceOf[Double] < obj.i.lowerBound.asInstanceOf[Double]) && (i.upperBound.asInstanceOf[Double] > obj.i.lowerBound.asInstanceOf[Double]) && (i.upperBound.asInstanceOf[Double] < obj.i.upperBound.asInstanceOf[Double])

  override def starts(obj: IntervalOccur): Boolean =
    (i.lowerBound.asInstanceOf[Double] == obj.i.lowerBound.asInstanceOf[Double]) && (i.upperBound.asInstanceOf[Double] < obj.i.upperBound.asInstanceOf[Double])

  override def during(obj: IntervalOccur): Boolean =
    (i.lowerBound.asInstanceOf[Double] > obj.i.lowerBound.asInstanceOf[Double]) && (i.upperBound.asInstanceOf[Double] < obj.i.upperBound.asInstanceOf[Double])

  override def finishes(obj: IntervalOccur): Boolean =
    (i.lowerBound.asInstanceOf[Double] > obj.i.lowerBound.asInstanceOf[Double]) && (i.upperBound.asInstanceOf[Double] == obj.i.upperBound.asInstanceOf[Double])

  override def equals(obj: IntervalOccur): Boolean =
    (i.lowerBound.asInstanceOf[Double] == obj.i.lowerBound.asInstanceOf[Double]) && (i.upperBound.asInstanceOf[Double] == obj.i.upperBound.asInstanceOf[Double])

  override def finishedBy(obj: IntervalOccur): Boolean =
    (i.lowerBound.asInstanceOf[Double] < obj.i.lowerBound.asInstanceOf[Double]) && (i.upperBound.asInstanceOf[Double] == obj.i.upperBound.asInstanceOf[Double])

  override def includes(obj: IntervalOccur): Boolean =
    (i.lowerBound.asInstanceOf[Double] < obj.i.lowerBound.asInstanceOf[Double]) && (i.upperBound.asInstanceOf[Double] > obj.i.upperBound.asInstanceOf[Double])

  override def startedBy(obj: IntervalOccur): Boolean =
    (i.lowerBound.asInstanceOf[Double] == obj.i.lowerBound.asInstanceOf[Double]) && (i.upperBound.asInstanceOf[Double] > obj.i.upperBound.asInstanceOf[Double])

  override def overlappedBy(obj: IntervalOccur): Boolean =
    (i.lowerBound.asInstanceOf[Double] > obj.i.lowerBound.asInstanceOf[Double]) && (i.lowerBound.asInstanceOf[Double] < obj.i.upperBound.asInstanceOf[Double]) && (i.upperBound.asInstanceOf[Double] > obj.i.upperBound.asInstanceOf[Double])

  override def metBy(obj: IntervalOccur): Boolean =
    (i.lowerBound.asInstanceOf[Double] > obj.i.lowerBound.asInstanceOf[Double]) && (i.lowerBound.asInstanceOf[Double] == obj.i.upperBound.asInstanceOf[Double])

  override def after(obj: IntervalOccur): Boolean =
    (i.lowerBound.asInstanceOf[Double] > obj.i.upperBound.asInstanceOf[Double])
}

object IntervalCompare extends App {
  override def main(args: Array[String]) {

    val i = new IntervalOccur(3, 5)
    val j = new IntervalOccur(4, 5)

    println(i.before(j))
  }
}
