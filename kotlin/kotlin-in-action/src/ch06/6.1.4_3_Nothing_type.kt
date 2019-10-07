package ch06

class Company(val name: String, val address: Address?)
class Address(val city: String, val country: String)


fun fail(message: String?): Nothing {
  throw IllegalAccessException(message);
}

// Nothing 타입은 "함수가 정상적으로 끝나지 않는다" 라는 걸 명시적으로 표현
// Nothing 타입은 아무 값도 포함하지 않으며,
fun main (args: Array<String>) {
//    val person = null
//    val s = person ?: fail("실패")


    val x: Nothing? = null           // 'x' has type `Nothing?`
    val l: List<Nothing?> = listOf(null)   // 'l' has type `List<Nothing?>


    val company = Company("Martin", null)

    // 아래와 같이 null 일 경우, 정상적으로 종료하지 않는다는 사실을 쉽게 알 수 있음
    val address = company.address ?: fail("adress")
    println(address.city)
}

// 출처: https://kotlinlang.org/docs/reference/exceptions.html



