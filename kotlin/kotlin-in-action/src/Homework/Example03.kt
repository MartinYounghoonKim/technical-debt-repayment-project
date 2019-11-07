package Homework

class Solution3 {
  fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
    var test = BooleanArray(n);
//    booleanArrayOf()
    var answer = n
    lost.forEach {
      if (!reserve.contains(it + 1)) {
        test[it] = false
      }
    }
//    reserve.forEach {
//      if (!lost.any{ i -> i == it + 1 }) {
//        answer--
//      }
//    }
//    println(answer)
    return answer
  }
}

fun main (args: Array<String>) {
  Solution3().solution(5, intArrayOf(2,4), intArrayOf(1,3,5))
  Solution3().solution(5, intArrayOf(2,4), intArrayOf(3))
  Solution3().solution(3, intArrayOf(3), intArrayOf(1))
}
