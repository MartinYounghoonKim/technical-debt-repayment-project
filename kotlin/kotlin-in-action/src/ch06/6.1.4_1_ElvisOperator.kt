package ch06.ex1_4_1_ElvisOperator

// 앨비스 연산자는 좌항이 null 이면 우항을 결과로, 좌항이 널이 아니면 좌항을 결과값으로 한다.
fun strLenSafe(s: String?): Int = s?.length ?: 0

fun main(args: Array<String>) {
    println(strLenSafe("abc"))
    println(strLenSafe(null)) // null
}
