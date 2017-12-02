/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondubar.humains.clients;

import gestiondubar.humains.Humain;

/**
 *
 * @author ISEN
 */
public enum AttributSpecial {

    TSHIRTR("T-shirt", "Rouge"), TSHIRTB("T-shirt", "Bleu"), TSHIRTV("T-shirt", "Vert"),//Non serveur
    BIJOUXC("Bijoux", "Collier"), BIJOUXB("Bijoux", "Bague"), BIJOUXP("Bijoux", "Perles"),//Non serveur
    TOUR1("Tour de bras", "=1"), TOUR5("Tour de bras", "=5"), TOURV10("Tour de bras", "=10"),//Non serveur
    CHARME1("Charme", "=1"), CHARME5("Charme", "=5"), CHARME10("Charme", "=10"),//Non serveur
    ;
    public final String name;
    public final String specialite;

    private static Integer debut1 = 0;
    private static Integer fin1 = 2;
    private static Integer debut2 = 3;
    private static Integer fin2 = 5;
    private static Integer debut3 = 6;
    private static Integer fin3 = 8;
    private static Integer debut4 = 9;
    private static Integer fin4 = 11;

    private AttributSpecial(String name, String spe) {
        this.name = name;
        this.specialite = spe;
    }

    @Override
    public String toString() {
        return this.name + " " + this.specialite; //To change body of generated methods, choose Tools | Templates.
    }

    public static String afficherLesAttributDeLobjet(Humain o) throws Exception {
        Integer i = 0;
        String str = "";
        if (o instanceof Serveur) {
            if (o.getSexe().equals(Sexe.MR)) {
                str = afficherLesAttributMasculinServeur();
            } else {
                str = afficherLesAttributFemininServeur();
            }
        } else if (o instanceof Object) {
            if (o.getSexe().equals(Sexe.MR)) {
                str = afficherLesAttributMasculinNonServeur();
            } else {
                str = afficherLesAttributFemininNonServeur();
            }
        } else {
            throw new Exception("L'Humain = null");
        }

        return str;
    }

    private static String afficherLesAttributMasculinNonServeur() {
        return afficherLesAttribut(debut1, fin1);
    }

    private static String afficherLesAttributFemininNonServeur() {
        return afficherLesAttribut(debut2, fin2);
    }

    private static String afficherLesAttributMasculinServeur() {
        return afficherLesAttribut(debut3, fin3);
    }

    private static String afficherLesAttributFemininServeur() {
        return afficherLesAttribut(debut4, fin4);
    }

    public static String afficherLesAttribut(Integer debut, Integer fin) {
        Integer i = 0;
        String str = "";
        AttributSpecial[] A = AttributSpecial.values();
        for (int l = debut; l <= fin; l++) {
            str += "\n" + "N°" + l + " " + A[l].toString();
            i++;
        }
        return str;
    }

    public static AttributSpecial choisirUnAttribut(Humain o, Integer i) throws Exception {
        if (o instanceof Serveur) {
            if (o.getSexe().equals(Sexe.MR)) {
                return choisirAttributMasculinServeur(o, i);
            } else {
                return choisirAttributFemininServeur(o, i);
            }
        } else if (o instanceof Object) {
            if (o.getSexe().equals(Sexe.MR)) {
                return choisirAttributMasculinNonServeur(o, i);
            } else {
                return choisirAttributFemininNonServeur(o, i);
            }
        } else {
            throw new Exception("L'Humain = null");
        }

    }

    public static AttributSpecial AutoChoisirUnAttribut(Humain o) throws Exception {
        if (o instanceof Serveur) {
            if (o.getSexe().equals(Sexe.MR)) {
                return choisirAttributMasculinServeur(o, debut3);
            } else {
                return choisirAttributFemininServeur(o, debut4);
            }
        } else if (o instanceof Object) {
            if (o.getSexe().equals(Sexe.MR)) {
                return choisirAttributMasculinNonServeur(o, debut1);
            } else {
                return choisirAttributFemininNonServeur(o, debut2);
            }
        } else {
            throw new Exception("L'Humain = null");
        }

    }

    private static AttributSpecial choisirAttributMasculinNonServeur(Humain h, Integer i) throws Exception {
        if (choisirAttribut(i, debut1, fin1)) {
            return AttributSpecial.values()[i];
        } else {
            throw new Exception("mauvais choix de l'attribut");
        }
    }

    private static AttributSpecial choisirAttributFemininNonServeur(Humain h, Integer i) throws Exception {
        if (choisirAttribut(i, debut2, fin2)) {
            return AttributSpecial.values()[i];
        } else {
            throw new Exception("mauvais choix de l'attribut");
        }
    }

    private static AttributSpecial choisirAttributMasculinServeur(Humain h, Integer i) throws Exception {
        if (choisirAttribut(i, debut3, fin3)) {
            return AttributSpecial.values()[i];
        } else {
            throw new Exception("mauvais choix de l'attribut");
        }
    }

    private static AttributSpecial choisirAttributFemininServeur(Humain h, Integer i) throws Exception {
        if (choisirAttribut(i, debut4, fin4)) {
            return AttributSpecial.values()[i];
        } else {
            throw new Exception("mauvais choix de l'attribut");
        }
    }

    public static boolean choisirAttribut(int i, Integer debut, Integer fin) {
        return i >= debut && i <= fin;

    }
}
