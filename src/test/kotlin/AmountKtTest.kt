import org.junit.Test

import org.junit.Assert.*

class AmountKtTest {

    @Test
    fun analizCardVisa() {


        // arrange

        val itemCard = "Visa"
        val itemSumPerevod = 15000
        val itemSumPredPerevod = 1000


        // act
        val result = analizCard(
            card = itemCard,
            sumperevod = itemSumPerevod,
            sumpredperevod = itemSumPredPerevod
        )

        // assert
        assertEquals(11250, result)
    }

    @Test
    fun analizCardMir() {


        // arrange

        val itemCard = "Мир"
        val itemSumPerevod = 25000
        val itemSumPredPerevod = 1500


        // act
        val result = analizCard(
            card = itemCard,
            sumperevod = itemSumPerevod,
            sumpredperevod = itemSumPredPerevod
        )

        // assert
        assertEquals(18750, result)
    }

    @Test
    fun analizCardMastercard() {


        // arrange

        val itemCard = "Mastercard"
        val itemSumPerevod = 76000
        val itemSumPredPerevod = 1000


        // act
        val result = analizCard(
            card = itemCard,
            sumperevod = itemSumPerevod,
            sumpredperevod = itemSumPredPerevod
        )

        // assert
        assertEquals(47600, result)
    }

    @Test
    fun analizCardMaestro() {


        // arrange

        val itemCard = "Maestro"
        val itemSumPerevod = 70000
        val itemSumPredPerevod = 1000


        // act
        val result = analizCard(
            card = itemCard,
            sumperevod = itemSumPerevod,
            sumpredperevod = itemSumPredPerevod
        )

        // assert
        assertEquals(0, result)
    }

    @Test
    fun analizLimitPerevodMaestro() {


        // arrange

        val itemCard = "Maestro"
        val itemSumPerevod = 160000 // добавлено неверное значение для ломки сборки
        val itemSumPredPerevod = 2000


        // act
        val result = analizLimitPerevod(
            card = itemCard,
            sumperevod = itemSumPerevod,
            sumpredperevod = itemSumPredPerevod
        )

        // assert
        assertEquals(true, result)
    }

    @Test
    fun analizLimitPerevodSchet() {


        // arrange

        val itemCard = "VKPay"
        val itemSumPerevod = 15000
        val itemSumPredPerevod = 2000


        // act
        val result = analizLimitPerevod(
            card = itemCard,
            sumperevod = itemSumPerevod,
            sumpredperevod = itemSumPredPerevod
        )

        // assert
        assertEquals(true, result)
    }

    @Test
    fun analizLimitPerevodVisa() {


        // arrange

        val itemCard = "Visa"
        val itemSumPerevod = 120000
        val itemSumPredPerevod = 2000


        // act
        val result = analizLimitPerevod(
            card = itemCard,
            sumperevod = itemSumPerevod,
            sumpredperevod = itemSumPredPerevod
        )

        // assert
        assertEquals(true, result)
    }

    @Test
    fun analizLimitPerevodMir() {


        // arrange

        val itemCard = "Мир"
        val itemSumPerevod = 70000
        val itemSumPredPerevod = 2600


        // act
        val result = analizLimitPerevod(
            card = itemCard,
            sumperevod = itemSumPerevod,
            sumpredperevod = itemSumPredPerevod
        )

        // assert
        assertEquals(true, result)
    }

    @Test
    fun analizLimitPerevodMastercard() {


        // arrange

        val itemCard = "Mastercard"
        val itemSumPerevod = 63000
        val itemSumPredPerevod = 2700


        // act
        val result = analizLimitPerevod(
            card = itemCard,
            sumperevod = itemSumPerevod,
            sumpredperevod = itemSumPredPerevod
        )

        // assert
        assertEquals(true, result)
    }
}
