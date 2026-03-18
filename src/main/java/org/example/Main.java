package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Application Boutique démarrée");

        // Boucle infinie pour garder le conteneur actif
        while (true) {
            try {
                Thread.sleep(10000); // 10 secondes
                System.out.println("Application toujours en cours...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
