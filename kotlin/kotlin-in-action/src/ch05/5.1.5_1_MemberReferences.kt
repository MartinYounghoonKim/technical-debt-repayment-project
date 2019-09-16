package ch05.ex1_5_1_MemberReferences

//fun salute() = println("Salute!")
//
//fun main(args: Array<String>) {
//    run(::salute)
//}

/**
 * 맴버 참조
 * 1. ::와 같이 사용하는 것을 "맴버 참조" 라고 부른다.
 * 2. 맴버 참조는 프로퍼티나 메소드를 단 하나만 호출하는 함수 값을 만들어 준다.
 */
data class Person(val name: String, val age: Int)

fun main (args: Array<String>) {
    val getAge = { person: Person -> person.age }
//    val getAge = Person::age
}