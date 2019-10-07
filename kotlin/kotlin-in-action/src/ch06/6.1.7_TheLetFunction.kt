package ch06.ex1_7_TheLetFunction

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun main(args: Array<String>) {
    var email: String? = "yole@example.com"
    email?.let { sendEmailTo(it) }
    email = null
    email?.let { sendEmailTo(it) } // null 인 경우 함수 실행이 되지 않는다.
}
