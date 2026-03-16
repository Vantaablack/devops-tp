package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class PanierReductionTest {

    @ParameterizedTest
    @CsvSource({
            "       , 100.0",
            "REDUC10,  90.0",
            "REDUC20,  80.0"
    })
    void calculerTotalDoitAppliquerLaBonneReduction(String code, double totalAttendu) {
        Panier panier = new Panier();
        Article article = new Article("REF-001", "Classeur", 10.0);
        panier.ajouterArticle(article, 10); // sous-total = 100.0

        if (code != null && !code.isBlank()) {
            panier.appliquerCodeReduction(code.trim());
        }

        assertEquals(totalAttendu, panier.calculerTotal(), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
            "       , 40.0",
            "REDUC10, 36.0",
            "REDUC20, 32.0"
    })
    void calculerTotalAvecPlusieursArticlesDoitAppliquerLaReduction(String code, double totalAttendu) {
        Panier panier = new Panier();
        Article crayon = new Article("REF-002", "Crayon", 4.0);
        Article livre  = new Article("REF-003", "Livre",  10.0);
        panier.ajouterArticle(crayon, 5);  // 20.0
        panier.ajouterArticle(livre, 2);   // 20.0

        if (code != null && !code.isBlank()) {
            panier.appliquerCodeReduction(code.trim());
        }

        assertEquals(totalAttendu, panier.calculerTotal(), 0.001);
    }
}
