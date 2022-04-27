
fun main(){

    var amount = 0.0
    var pay = 0.0

    print("Введите сумму перевода в руб.: ")
    val `in` = readln()
    amount = `in`.toDouble()
    amount *= 100
    println("Сумма перевода в копейках составит:$amount коп.")
    pay = amount * 0.075
    if (pay < 3500.0) {
        pay = 3500.0
    }

    println("С вас будет взята комиссия в размере 0.75% от суммы перевода: $pay коп.")
    println("Итоговая сумма в копейках составит: " + (amount + pay) + " коп.")
    println("Итоговая сумма в рублях составит: " + (amount + pay) / 100 + " руб.")

}

