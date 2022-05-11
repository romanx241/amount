import java.util.*


var limitPerevod = false


fun main(args: Array<String>) {

    var amount = 0
    var sumpredperevod = 0
    var pay = 0.0
    val `in` = Scanner(System.`in`)
    print("Введите тип карты: ")
    val typeCard = `in`.nextLine()
    print("Введите сумму перевода в рублях: ")
    amount = `in`.nextInt()
    amount *= 100
    print("Введите сумму предыдущих переводов: ")
    sumpredperevod = `in`.nextInt()
    sumpredperevod *= 100
    pay = analizCard(typeCard, amount, sumpredperevod)
    if (limitPerevod === true) {
        println("Сумма перевода в копейках составит: " + amount + "коп.")
        println("С вас будет взята комиссия в размере : $pay коп.")
        println("Итоговая сумма в копейках составит: " + (amount + pay) + " коп.")
        println("Итоговая сумма в рублях составит: " + (amount + pay) / 100 + " руб.")
    } else {
        println("Превышен лимит перевода")
    }
}


fun analizCard(card: String, sumperevod: Int, sumpredperevod: Int): Double {
    limitPerevod = true
    if (card == "Mastercard" || card == "Maestro" || card == "Visa" || card == "Мир") {
        if (sumperevod > 15000000 || sumperevod + sumpredperevod > 60000000) {
            limitPerevod = false
            return 0.0
        }
    }
    if (card == "VKPay") {
        if (sumperevod > 1500000 || sumperevod + sumpredperevod > 4000000) {
            limitPerevod = false
            return 0.0
        }
    }
    var pay = 0.0
    if ((card == "Mastercard" || card == "Maestro") && sumperevod <= 7500000) {
        return pay
    }
    if ((card == "Mastercard" || card == "Maestro") && sumperevod > 7500000) {
        pay = sumperevod * 0.6 / 100 + 2000
        return pay
    }
    if (card == "Visa" || card == "Мир") {
        pay = sumperevod * 0.75 / 100
        if (pay < 3500) {
            pay = 3500.0
        }
        return pay
    }
    return if (card == "VKPay") pay else 0.0
}

