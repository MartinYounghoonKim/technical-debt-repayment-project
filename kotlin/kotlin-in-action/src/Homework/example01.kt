package Homework

class Solution {
  fun solution(answers: IntArray): IntArray {
    var answer = intArrayOf(0,0,0)

    val A_STUDENT_ANSWER_PATTERN = intArrayOf(1,2,3,4,5)
    val B_STUDENT_ANSWER_PATTERN = intArrayOf(2,1,2,3,2,4,2,5)
    val C_STUDENT_ANSWER_PATTERN = intArrayOf(3,3,1,1,2,2,4,4,5,5)
    val scoreList = intArrayOf(0,0,0)

    for ((index, value) in answers.withIndex()) {
      // dddddd
      if (value === A_STUDENT_ANSWER_PATTERN.get(index%A_STUDENT_ANSWER_PATTERN.size)) {
        scoreList[0]++
      }
      if (value === B_STUDENT_ANSWER_PATTERN.get(index%B_STUDENT_ANSWER_PATTERN.size)) {
        scoreList[1]++
      }
      if (value === C_STUDENT_ANSWER_PATTERN.get(index%C_STUDENT_ANSWER_PATTERN.size)) {
        scoreList[2]++
      }
    }
    val maxScore = scoreList.maxBy { it }
    for ((index, value) in scoreList.withIndex()) {
      if(maxScore === value) {
//        answer.plus(index)
//        answer.set(index, index + 1)
        answer[index] = index + 1
      }
    }
    println(answer)
    return answer
  }
}

fun main (args: Array<String>) {
  Solution().solution(intArrayOf(1,2,3,4,5))
//  Solution().solution(intArrayOf(1,3,2,4,2))
}
