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
        in MINUTE + 1..HOUR -> selectWordEnding(time, MINUTE, "минуту", "минуты", "минут")
        in HOUR + 1..DAY -> selectWordEnding(time, HOUR, "час", "часа", "часов")
        in DAY + 1..DAY * 2 -> ("Был(а) сегодня")
        in DAY * 2 + 1..DAY * 3 -> ("Был(а) вчера")
        in DAY * 3 + 1..Int.MAX_VALUE -> ("Был(а) давно")
        else -> error("Что-то пошло не так")
    }
}

fun selectWordEnding(time: Int, divider: Int, pluralOne: String, pluralFew: String, pluralMany: String): String {
    val timeValue = time / divider
    return if (timeValue % 10 == 1 && timeValue != 11) ("Был(а) $timeValue $pluralOne назад")
    else if (timeValue % 10 in 2..4 && timeValue !in 12..14) ("Был(а) $timeValue $pluralFew назад")
    else ("Был(а) $timeValue $pluralMany назад")
}

