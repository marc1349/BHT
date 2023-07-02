package arraylist.cocktailgen;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Speichert alle neuen Cocktail-Objekte ab, liest alle Cocktails bei
 * File-Aufruf aus und speichert sie beim Beenden => Eigentliches
 * Speichermanagement fuer den Cocktailmixer.
 * 
 * @author skalt
 * @version 3.0, 07/2009
 */
public class CocktailBar {

    // Die Verwendung eines Interface fuer die Deklaration ermoeglicht die Wahl
    // einer Implementierung, hier ArrayList (siehe im Konstruktor) und
    // leichtere Anpassung.
    private List<Cocktail> cocktails; // alle Cocktails

    /**
     * Konstruktor - erzeugt eine leere CocktailBar.
     */
    public CocktailBar() {
        cocktails = new ArrayList<>();
    }

    /**
     * Konstruktor - erzeugt eine leere CocktailBar mit den uebergebenen
     * Cocktails.
     */
    public CocktailBar(List<Cocktail> cocktails) {
        this.cocktails = cocktails;
    }

    /**
     * Liest eine gespeicherte CocktailBar aus der uebergebenen Datei ein. Wird
     * die Datei nicht gefunden wird eine leere CocktailBar erzeugt.
     * 
     * @param file
     *            Dateiname
     */
    public void einlesen(String file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            cocktails = (List<Cocktail>) ois.readObject();
            fis.close();
        } catch (Exception e) {
            System.err
                    .println(" Datei nicht vorhanden. Es wird eine leere CocktailBar fuer Sie erzeugt");
            cocktails = new ArrayList<>();
        }
    }

    /**
     * Liefert ein Array aller Cocktails.
     * 
     * @return Array aller Cocktails
     */
    public Cocktail[] getCocktails() {
        // zeigt examplarisch wie man einfach von einer Liste ein Array ereugen
        // kann!!!
        return cocktails.toArray(new Cocktail[0]);
    }

    /**
     * Speichert einen neuen Cocktail.
     * 
     * @param cockObj
     *            Instanz auf ein Cocktail-Objekt
     */
    public void addCocktail(Cocktail cockObj) {
        cocktails.add(cockObj);
    }

    /**
     * Schreibt die Cocktails der Cocktailbar in eine Datei.
     * 
     * @param file
     *            Dateiname
     */
    public void sichern(String file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cocktails);
            oos.close();
        } catch (Exception e) {
            System.err.println("  CocktailBar konnte nicht gesichert werden: "
                    + e);
        }
    }

}