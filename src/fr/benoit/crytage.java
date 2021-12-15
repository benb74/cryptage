package fr.benoit;

import java.util.Scanner;

public class crytage {

    /**
     * @param args
     */
    public static void main(String[] args) {
        char[][] alphabets = new char[26][26];

        // Initialisation alphabets
        // Le but est d'obtenir cette grille :
        //		ABCDEFGHIJKLMNOPQRSTUVWXYZ
        //		BCDEFGHIJKLMNOPQRSTUVWXYZA
        //		CDEFGHIJKLMNOPQRSTUVWXYZAB
        //		DEFGHIJKLMNOPQRSTUVWXYZABC
        //		EFGHIJKLMNOPQRSTUVWXYZABCD
        //		FGHIJKLMNOPQRSTUVWXYZABCDE
        //		GHIJKLMNOPQRSTUVWXYZABCDEF
        //		HIJKLMNOPQRSTUVWXYZABCDEFG
        //		IJKLMNOPQRSTUVWXYZABCDEFGH
        //		JKLMNOPQRSTUVWXYZABCDEFGHI
        //		KLMNOPQRSTUVWXYZABCDEFGHIJ
        //		LMNOPQRSTUVWXYZABCDEFGHIJK
        //		MNOPQRSTUVWXYZABCDEFGHIJKL
        //		NOPQRSTUVWXYZABCDEFGHIJKLM
        //		OPQRSTUVWXYZABCDEFGHIJKLMN
        //		PQRSTUVWXYZABCDEFGHIJKLMNO
        //		QRSTUVWXYZABCDEFGHIJKLMNOP
        //		RSTUVWXYZABCDEFGHIJKLMNOPQ
        //		STUVWXYZABCDEFGHIJKLMNOPQR
        //		TUVWXYZABCDEFGHIJKLMNOPQRS
        //		UVWXYZABCDEFGHIJKLMNOPQRST
        //		VWXYZABCDEFGHIJKLMNOPQRSTU
        //		WXYZABCDEFGHIJKLMNOPQRSTUV
        //		XYZABCDEFGHIJKLMNOPQRSTUVW
        //		YZABCDEFGHIJKLMNOPQRSTUVWX
        //		ZABCDEFGHIJKLMNOPQRSTUVWXY
        for (int ligne = 0; ligne < 26; ligne++) {
            for (int col = 0; col < 26; col++) {
                int codeLettre = ((col + ligne) % 26) + 65;
                alphabets[ligne][col] = (char) codeLettre;
            }
        }

        // Saisies utilisateur
        int mode = saisirInt("Veuillez choisir le mode (1=cryptage, 2=decryptage) :");
        String phraseInitiale = saisirString("Saisir la phrase initiale :");
        String cleCryptage = saisirString("Saisir la clé de cryptage (8 chrs max) :");

        // Vérification des saisies
        if ((cleCryptage.length() < 1) || (cleCryptage.length() > 8)) {
            System.out.println("Clé de cryptage invalide");
        } else if ((mode < 1) || (mode > 2)) {
            System.out.println("Le mode selectionné est invalide");
        } else {
            if (mode == 1) {
                // Cryptage
                String resultat = cryptString(alphabets, phraseInitiale,
                        cleCryptage);
                System.out.println("La phrase cryptée est : " + resultat);
            } else {
                // Décryptage
                String resultat = decryptString(alphabets, phraseInitiale,
                        cleCryptage);
                System.out.println("La phrase décryptée est : " + resultat);
            }
        }

    }

    private static String cryptString(char[][] alphabets,
                                      String phraseInitiale, String cleCryptage) {
        String resultat = "";
        int indiceCle = 0;
        int valLettreCle = 0;
        int valLettrePhrase = 0;

        for (int indicePhrase = 0; indicePhrase < phraseInitiale.length(); indicePhrase++) {
            valLettreCle = ((int) cleCryptage.charAt(indiceCle)) - 65;
            valLettrePhrase = ((int) phraseInitiale.charAt(indicePhrase)) - 65;
            resultat += alphabets[valLettreCle][valLettrePhrase];

            if (++indiceCle == cleCryptage.length()) {
                indiceCle = 0;
            }
        }
        return resultat;
    }

    /**
     * Décrypte une chaine de caractères en fonction d'un tableau d'alphabets
     *
     * @param alphabets
     * @param phraseInitiale
     * @param cleCryptage
     * @return chaine décryptée
     */
    private static String decryptString(char[][] alphabets,
                                        String phraseInitiale, String cleCryptage) {
        String resultat = "";
        int indiceCle = 0;
        int valLettreCle = 0;
        int valLettrePhrase = 0;

        for (int indicePhrase = 0; indicePhrase < phraseInitiale.length(); indicePhrase++) {
            valLettreCle = ((int) cleCryptage.charAt(indiceCle)) - 65;
            valLettrePhrase = 0;

            while (alphabets[valLettreCle][valLettrePhrase] != phraseInitiale
                    .charAt(indicePhrase)) {
                valLettrePhrase++;
            }

            resultat += ((char) (65 + valLettrePhrase));

            if (++indiceCle == (cleCryptage.length())) {
                indiceCle = 0;
            }
        }

        return resultat;
    }

    /**
     * Affiche les alphabets utilisés pour le cryptage / décryptage
     *
     * @param alphabets
     */
    private static void showAlphabets(char[][] alphabets) {
        for (int ligne = 0; ligne < alphabets.length; ligne++) {
            for (int col = 0; col < alphabets[0].length; col++) {
                System.out.print(alphabets[ligne][col]);
            }
            System.out.println("");
        }
    }

    /**
     * Affiche un message et retourne une saisie de type Int
     *
     * @param message à afficher
     * @return La saisie entrée par l'utilisateur
     */
    private static int saisirInt(String message) {
        System.out.println(message);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    /**
     * Affiche un message et retourne une saisie de type String
     *
     * @param message à afficher
     * @return La saisie entrée par l'utilisateur
     */
    private static String saisirString(String message) {
        System.out.println(message);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
