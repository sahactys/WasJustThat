const val DAY = 86400
const val HOUR = 3600
const val MINUTE = 60

fun main() {
    while (true) {
        var time: Int
        println("Введите количество прошедших секунд")
        while (true) {
            try {
                time = readLine()?.toInt() ?: return
                if (time < 0) error(0)
                break
            } catch (e: Exception) {
                println("Ошибка ввода, попробуйте еще раз")
            }
        }
        agoToText(time)
    }
}

fun agoToText(time: Int) {
    when (time) {
        in 0..MINUTE -> println("Был(а) только что")
        in MINUTE + 1..HOUR -> selectWordEnding(time)
        in HOUR + 1..DAY -> selectWordEnding(time)
        in DAY + 1..DAY * 2 -> println("Был(а) сегодня")
        in DAY * 2 + 1..DAY * 3 -> println("Был(а) вчера")
        in DAY * 3 + 1..Int.MAX_VALUE -> println("Был(а) давно")
        else -> error("Что-то пошло не так")
    }
}

fun selectWordEnding(time: Int) {
    when (time) {
        in MINUTE + 1..HOUR -> {
            if (time / MINUTE % 10 == 1 && time / MINUTE != 11) println("Был(а) " + time / MINUTE + " минуту назад")
            else if (time / MINUTE % 10 in 2..4 && time / MINUTE !in 12..14) println("Был(а) " + time / MINUTE + " минуты назад")
            else println("Был(а) " + time / MINUTE + " минут назад")
        }
        in HOUR + 1..DAY -> {
            if (time / HOUR % 10 == 1 && time / HOUR != 11) println("Был(а) " + time / HOUR + " час назад")
            else if (time / HOUR % 10 in 2..4 && time / HOUR !in 12..14) println("Был(а) " + time / HOUR + " часа назад")
            else println("Был(а) " + time / HOUR + " часов назад")
        }
        else -> error("Что-то пошло не так")


    }
}

