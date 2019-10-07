package ch06.ex1_5_SafeCastsAs

class Person(val firstName: String, val lastName: String) {
   override fun equals(o: Any?): Boolean {
      val otherPerson = o as? Person ?: return false // 코틀린 내에서는 return 이나 throw 연산도 식이다. 그렇기 때문에 이런 식으로 우항에 return이나 throw 연산을 넣을 수 있다.

      // 위에서의 타입 캐스트를 통해 o가 Person 타입이라는 것을 보장
      return otherPerson.firstName == firstName &&
             otherPerson.lastName == lastName
   }

   override fun hashCode(): Int =
      firstName.hashCode() * 37 + lastName.hashCode()
}

fun main(args: Array<String>) {
    val p1 = Person("Dmitry", "Jemerov")
    val p2 = Person("Dmitry", "Jemerov")
    val p3 = null

    println(p1 == p2)
    println(p1.equals(42))
    println(p1.equals(p3))

}
