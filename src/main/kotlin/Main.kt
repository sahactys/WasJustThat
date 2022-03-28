const val MINUTE = 60
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


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

        println(agoToText(time))
    }
}

fun agoToText(time: Int): String {
    return when (time) {
        in 0..MINUTE -> ("Был(а) только что")
        in MINUTE + 1..HOUR -> selectWordEnding(time)
        in HOUR + 1..DAY -> selectWordEnding(time)
        in DAY + 1..DAY * 2 -> ("Был(а) сегодня")
        in DAY * 2 + 1..DAY * 3 -> ("Был(а) вчера")
        in DAY * 3 + 1..Int.MAX_VALUE -> ("Был(а) давно")
        else -> error("Что-то пошло не так")
    }
}

fun selectWordEnding(time: Int): String {
    val timeMinute = time / MINUTE
    val timeHour = time / HOUR
    return when (time) {
        in MINUTE + 1..HOUR -> {
            if (timeMinute % 10 == 1 && timeMinute != 11) ("Был(а) $timeMinute минуту назад")
            else if (timeMinute % 10 in 2..4 && timeMinute !in 12..14) ("Был(а) $timeMinute минуты назад")
            else ("Был(а) $timeMinute минут назад")
        }
        in HOUR + 1..DAY -> {
            if (timeHour % 10 == 1 && timeHour != 11) ("Был(а) $timeHour час назад")
            else if (timeHour % 10 in 2..4 && timeHour !in 12..14) ("Был(а) $timeHour часа назад")
            else ("Был(а) $timeHour часов назад")
        }
        else -> error("Что-то пошло не так")


    }
}

