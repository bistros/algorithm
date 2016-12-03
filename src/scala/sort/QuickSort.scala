package scala.sort

import scala.util.Random

/**
  * Created by bistros on 2016. 12. 3..
  *
  * quicksort
  */
object QuickSort extends App {


  def qs1(list: List[Int]) : List[Int] = list match {
    case Nil => Nil
    case a :: tail =>
      val (less,grater) = tail.partition( _ <= a)
      qs1(less) ::: List(a) ::: qs1(grater)

  }

  println("qs1 : " + qs1(List.fill(10)(Random.nextInt(100))))


}
