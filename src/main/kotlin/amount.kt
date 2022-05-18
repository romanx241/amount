import java.util.*


fun main() {

    val amount: Int
    val sumpredperevod: Int
    val `in` = Scanner(System.`in`)
    print("Введите тип карты: ")
    val typeCard = `in`.nextLine()
    print("Введите сумму перевода в рублях: ")
    amount = `in`.nextInt()
    print("Введите сумму предыдущих переводов: ")
    sumpredperevod = `in`.nextInt()
    analizCard(typeCard, amount, sumpredperevod)
    analizLimitPerevod(typeCard, amount, sumpredperevod)

}


fun analizCard(card: String, sumperevod: Int, sumpredperevod: Int): Int {

    val sumperevod = sumperevod * 100
    val limitPerevod = true
    var pay = 0
    if ((card == "Mastercard" || card == "Maestro") && sumperevod <= 7500000) {
        pay = 0
    }
    if ((card == "Mastercard" || card == "Maestro") && sumperevod > 7500000) {
        pay = (sumperevod * 0.6 / 100 + 2000).toInt()
    }
    if (card == "Visa" || card == "Мир") {
        pay = (sumperevod * 0.75 / 100).toInt()
        if (pay < 3500) {
            pay = 3500
        }
    }
    if (card == "VKPay") {
        pay = 0
    }

    if (limitPerevod === true) {
        println("Сумма перевода в копейках составит: " + sumperevod + "коп.")
        println("С вас будет взята комиссия в размере: $pay коп.")
        println("Итоговая сумма в копейках составит: " + (sumperevod + pay) + " коп.")
        println("Итоговая сумма в рублях составит: " + (sumperevod + pay) / 100 + " руб.")
    } else {
        println("Превышен лимит перевода")
    }
    return pay
}

fun analizLimitPerevod(card: String, sumperevod: Int, sumpredperevod: Int): Boolean {

    val sumperevod = sumperevod * 100
    var limitPerevod = true
    if (card == "Mastercard" || card == "Maestro" || card == "Visa" || card == "Мир") {
        if (sumperevod > 15000000 || sumperevod + sumpredperevod > 60000000) {
            limitPerevod = false
        }
    }
    if (card == "VKPay") {
        if (sumperevod > 1500000 || sumperevod + sumpredperevod > 4000000) {
            limitPerevod = false
        }
    }
    return limitPerevod
}



