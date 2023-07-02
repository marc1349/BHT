package arraylist.cocktailgen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Fuehrt alles was fuer einen Cocktail noetig ist zusammen.:
 * 1. Eingabe der Zutaten mit Menge (List zutaten)
 * 2. Eingabe der Zubereitung (List zubereitung)
 * 3. Ausgeben der Einkaufsliste fuer den Cocktail
 * 
 * @author skalt
 * @version 3.0, 07/2009
 */
public class Cocktail implements Serializable {

    // Standard ID fuer Versionskontroll in der Serialiable Klasse einfuegen  
    private static final long serialVersionUID = 1L;

    private String cName; // Name d. Cocktails

    // Die Verwendung eines Interface fuer die Deklaration ermoeglicht die Wahl
    // einer Implementierung, hier ArrayList (siehe im Konstruktor) und
    // leichtere Anpassung.
    // Statt ArrayList koennte man LinkedList waehlen. Nur eine einzige Zeile im
    // Konstruktor wird veraendert.
    private List<Zutat> zutaten; // Zutatenliste fuer diesen Cocktail
    private List<String> zubereitung; // Zubereitung ueber mehrere Zeilen

    /**
     * Erzeugt ein Cocktail-Objekt und liest alle benoetigten Informationen:
     * Zutaten und Zubereitung nacheinander ein.
     * 
     * @param cName
     *            - Namen des cocktails
     */
    public Cocktail(String cName) {
        this.cName = cName;
        zutaten = new ArrayList<>(); // ArrayList Implementierung gewaehlt
        // Zutaten eingeben
        zutatenEingeben();
        // Zubereitung eingeben
        zubereitung = CocktailKonsole
                .getInputStringList("\n  Zubereitung (zum Beenden tippen Sie '***' ein): ");
        // Einkaufsliste ausgeben
        einkaufslisteOut();
    }

    /**
     * Erzeugt ein Cocktail-Objekt.
     * 
     * @param cName
     *            Namen des Cocktails
     * @param zutaten
     *            Liste der Zutaten
     * @param zubereitung
     *            Liste der Zubereitungsschritte
     */
    public Cocktail(String cName, List<Zutat> zutaten, List<String> zubereitung) {
        this.cName = cName;
        this.zutaten = zutaten;
        this.zubereitung = zubereitung;
    }

    /**
     * Die Methode zutatenEingeben dient zum Einlesen der benoetigten Zutaten:
     * Namen und Mengen. Alle Zutaten werden in die Liste zutaten gespeichert.
     * Diese Methode wird vom Konstruktor aufgerufen.
     */
    public void zutatenEingeben() {
        char jn;
        do {
            // Zutaten und Menge einlesen
            String zutat = CocktailKonsole.getInputString("  Zutat Namen: ");
            String menge = CocktailKonsole.getInputString("\n  Menge: ");
            // Speichern des Zutat-Objekts, damit spaeter abrufbar
            zutaten.add(new Zutat(zutat, menge));
            jn = CocktailKonsole
                    .getInputChar("\n  Sind weitere Zutaten noetig? (j/n): ");
        } while (jn == 'j' || jn == 'J');
    }

    /**
     * Die Methode einkaufslisteOut dient zur Ausgabe der Einkausliste. , d.h
     * sie liest den Vector einkaufsliste aus, in dem alle Zutaten, die zuvor
     * nicht in der cbar gespeichert waren, eingegeben wurden. Sie wird vom
     * Konstruktor aufgerufen.
     */
    public void einkaufslisteOut() {
        System.out
                .println("  Folgende Zutaten muessen fuer diesen Cocktail eingekauft werden:  \n");
        System.out.println(zutaten);
    }

    /**
     * Rueckgabe des Namens des Cocktails
     * 
     * @return der Cocktailname
     */
    public String getCName() {
        return cName;
    }

    /**
     * Gibt die Liste von Zutaten zurueck.
     * 
     * @return zutaten
     */
    public List<Zutat> getZutaten() {
        return zutaten;
    }

    /**
     * Gibt die Zubereitung zurueck.
     * 
     * @return zubereitung
     */
    public List<String> getZubereitung() {
        return zubereitung;
    }

    /**
     * Gibt ein Cocktail-Objekt als Zeichenkette zurueck.
     * 
     * @return cocktail als String dargestellt
     */
    public String toString() {
        // Benutzung von StringBuilder fuer bessere Effizienz
        // da String-Objekte unveraenderbar sind.
        StringBuilder sb = new StringBuilder();
        sb.append("Coktail: " + cName + '\n' + "Zutaten: " + '\n');

        // Schleife fuer Java 5 oder hoeher
        for (Zutat z : zutaten) {
            sb.append(z.toString() + '\n');
        }
        sb.append("Zubereitung: " + '\n');
        for (String s : zubereitung) {
            sb.append(s + '\n');
        }
        return sb.toString();
    }
}
