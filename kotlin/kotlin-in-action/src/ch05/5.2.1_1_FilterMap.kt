package ch05.ex2_1_1_FilterMap

/**
 * filter 함수는 Collection을 이터레이션 하면서 주어진 람다에 각 원소를 넘겨 람다가 true를 반환하는 원소만 모은다.
 */
fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })
}
