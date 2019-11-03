package Homework

class Solution1 {
  fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
    var answer = intArrayOf()
    commands.forEachIndexed {index, element ->
      val begin = element.get(0) - 1
      val end = element.get(1)
      val target = element.get(2) - 1
      val t = array
        .slice(begin until end)
        .sorted()

      val a = t.get(target)
      answer = answer.plus(a)
    }
    return answer
  }
}

fun main (args: Array<String>) {
  Solution1().solution(
    intArrayOf(1, 5, 2, 6, 3, 7, 4),
    arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3)))
}
