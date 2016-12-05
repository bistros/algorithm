package sort

import scala.util.Random

/**
  * created by bistros on 2016. 12. 3..
  *
  * quicksort ( https://en.wikipedia.org/wiki/quicksort#formal_analysis )
  *
  * best : o(n log n)
  * worst : o(n^2) 으로 pivot에 의해 파티션이 (n-1, 1) 일 경우이다.
  *
  * 참고
  * - 결국엔 pivot을 잘 뽑으면(가운대 숫자로) 더 성능이 좋아 진다 이것을 위한 방법으로 pivot을 head, tail, center로 뽑는게 아니라
  *   임의대로 3개 뽑아 그 중 가운대 값을 쓰는 방법도 있다 (물론 n이 클 경우...)
  * - Java1.7에는 DualPivotQuicksort 를 사용한다
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
