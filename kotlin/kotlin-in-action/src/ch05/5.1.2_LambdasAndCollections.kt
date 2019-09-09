package ch05.ex1_2_LambdasAndCollections

data class Person(val name: String, val age: Int)
//
//fun findTheOldest(people: List<Person>) {
//    var maxAge = 0
//    var theOldest: Person? = null
//    for (person in people) {
//        if (person.age > maxAge) {
//            maxAge = person.age
//            theOldest = person
//        }
//    }
//    println(theOldest)
//}
//
//fun main(args: Array<String>) {
//    val people = listOf(Person("Alice", 29), Person("Bob", 31))
//    findTheOldest(people)
//}


/**
 * 함수 안의 it의 경우 인자를 가르킴
 */
//fun main(args: Array<String>) {
//    val people = listOf(Person("Martin", 20), Person("Irene", 20));
//    println(people.maxBy { it.age }) // 나이 프로퍼티를 비교해서 값이 가장 큰 원소 찾기. (코틀린의 라이브러리)
//}

/**
 * 람다의 정식적인 문법
 * 위의 함수에서 코틀린이 코드를 줄여쓸 수 있도록 제공해주는 기능을 제거
 *
 * But... 번잡스럽다.
 * 예를 들어 maxBy 함수 안의 Person의 경우 컴파일러가 문맥으로부터 유추할 수 있는 인자 타입을 굳이 적을 필요가 없다.
 */
//fun main(args: Array<String>) {
//    val people = listOf(Person("Martin", 40), Person("Irene", 20));
//    println(people.maxBy({ p: Person -> p.age }))
//    println(people.maxBy(){ p: Person -> p.age }) // 1차 개선. 함수 호출 시, 맨 뒤에 있는 인자가 람다 식이라면 람다를 괄호 밖으로 빼낼 수 있다는 문법 관습이 있음.
//    println(people.maxBy{ p: Person -> p.age }) // 람다가 어떤 함수의 유일한 인자, 괄호 뒤에 람다를 썼다면 호출 시 빈 괄호 삭제 가능
//
//}
/**
 *
 */

//fun main(args: Array<String>) {
//    val people = listOf(Person("Martin", 20), Person("Irene", 40))
//    println(people.maxBy(Person::age)) // Person(name=Irene, age=40)
//    println(people.minBy(Person::age)) // Person(name=Martin, age=20)
//}

/**
 * joinToString 예제 작성
 */
fun main(args: Array<String>) {
    val people = listOf(Person("Martin", 39), Person("Irene", 39))
//    val nameList = people.joinToString(separator = " ",
//            transform = { p: Person -> p.name })
    val nameList = people.joinToString(" "){ p: Person -> p.name } // 위의 코드는 이러한 형식으로 정리된다.
    println(nameList)
}

