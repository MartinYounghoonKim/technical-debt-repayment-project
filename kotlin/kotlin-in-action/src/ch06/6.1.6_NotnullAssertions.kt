package ch06.ex1_6_NotnullAssertions

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun main(args: Array<String>) {
    // 실제 null 타입의 경우 NPE가 발생.
    // 컴파일러에게 Not null assertion 이라고 해줄 뿐
    ignoreNulls(null)
}
