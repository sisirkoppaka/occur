package occur.example


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

  val lb = s
  val ub = s

  override def before(obj: IntervalOccur): Boolean =
    ub < obj.lb

  override def meets(obj: IntervalOccur): Boolean =
    (lb < obj.lb) && (ub == obj.ub)

  override def overlaps(obj: IntervalOccur): Boolean =
    (lb < obj.lb) && (ub > obj.lb) && (ub < obj.ub)

  override def starts(obj: IntervalOccur): Boolean =
    (lb == obj.lb) && (ub < obj.ub)

  override def during(obj: IntervalOccur): Boolean =
    (lb > obj.lb) && (ub < obj.ub)

  override def finishes(obj: IntervalOccur): Boolean =
    (lb > obj.lb) && (ub == obj.ub)

  override def equals(obj: IntervalOccur): Boolean =
    (lb == obj.lb) && (ub == obj.ub)

  override def finishedBy(obj: IntervalOccur): Boolean =
    (lb < obj.lb) && (ub == obj.ub)

  override def includes(obj: IntervalOccur): Boolean =
    (lb < obj.lb) && (ub > obj.ub)

  override def startedBy(obj: IntervalOccur): Boolean =
    (lb == obj.lb) && (ub > obj.ub)

  override def overlappedBy(obj: IntervalOccur): Boolean =
    (lb > obj.lb) && (lb < obj.ub) && (ub > obj.ub)

  override def metBy(obj: IntervalOccur): Boolean =
    (lb > obj.lb) && (lb == obj.ub)

  override def after(obj: IntervalOccur): Boolean =
    (lb > obj.ub)
}

object IntervalCompare extends App {
  override def main(args: Array[String]) {

    val i = new IntervalOccur(3, 5)
    val j = new IntervalOccur(4, 5)

    println(i.before(j))
    println(i.meets(j))
    println(i.overlaps(j))
    println(i.starts(j))
    println(i.during(j))
    println(i.finishes(j))
    println(i.equals(j))
    println(i.finishedBy(j))
    println(i.includes(j))
    println(i.startedBy(j))
    println(i.overlappedBy(j))
    println(i.metBy(j))
    println(i.after(j))

    println("Only one of the above 13 Allen Interval Logical states should be true.")

  }
}
