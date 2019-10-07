package ch06.ex1_3_1_SafeCallOperator

fun printAllCaps(s: String?) { // s는 Nullable 하다.
    val allCaps = s?.toUpperCase()
//    val allCaps = if (s != null) s.toUpperCase() else null
    println(allCaps)
}

fun main(args: Array<String>) {
    printAllCaps("abc")
    printAllCaps(null)
}
