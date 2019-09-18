package Homework

data class Student (val name: String,
                    val koreanScore: Int,
                    val englishScore: Int,
                    val mathScore: Int)

fun main(args: Array<String>) {
    val students = listOf(Student("Martin", 80, 90, 75),
            Student("Irene", 40, 80, 90),
            Student("Hong", 30, 100, 100))
    println(students.filter { it.koreanScore > 50 && it.englishScore > 50 && it.mathScore > 50 })

}