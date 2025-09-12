package DavidRobertBDD

import io.kotest.core.spec.style.BehaviorSpec
import kotlinx.datetime.LocalDateTime

class NumeroDeFactureTests : BehaviorSpec({
    given("la date du jour est 2400-09-01") {

        val fakeHorlorge = FakeHorloge(dateDuJour = LocalDateTime.parse("2400-09-01"))

        `when`("on génère le numéro de facture ") {

            val numeroDeFacture = NumeroDeFacture(fakeHorlorge)

            then("ce numéro est FACT-2400-09-0001") {
                // test code
            }


        }
    }
})