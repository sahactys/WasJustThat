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
        in MINUTE + 1..HOUR -> {
            val timeValue = time / MINUTE
            val ending = selectWordEnding(timeValue, "минуту", "минуты", "минут")
            "Был(а) $timeValue $ending назад"
        }
        in HOUR + 1..DAY -> {
            val timeValue = time / HOUR
            val ending = selectWordEnding(timeValue, "час", "часа", "часов")
            "Был(а) $timeValue $ending назад"
        }
        in DAY + 1..DAY * 2 -> ("Был(а) сегодня")
        in DAY * 2 + 1..DAY * 3 -> ("Был(а) вчера")
        in DAY * 3 + 1..Int.MAX_VALUE -> ("Был(а) давно")
        else -> error("Что-то пошло не так")
    }
}

fun selectWordEnding(timeValue: Int, pluralOne: String, pluralFew: String, pluralMany: String): String {
    return if (timeValue % 10 == 1 && timeValue != 11) pluralOne
    else if (timeValue % 10 in 2..4 && timeValue !in 12..14) pluralFew
    else pluralMany
}

