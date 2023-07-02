package arraylist.cocktailgen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Wickelt Einlesevorgaenge ab.
 * 
 * @author VFH, Anka Shergowski, Karsten Hornemann
 * @version 2.0
 */
public class CocktailKonsole {

    private static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

    /**
     * Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und
     * gibt diese als String zurueck.
     * 
     * @param text
     *                Text, der als Eingabeaufforderung fuer den Benutzer
     *                ausgegeben wird.
     * @return Einen Wert vom Typ <tt>String</tt> der die Benutzereingabe
     *         enthaelt.
     */
    public static String getInputString(String text) {
        while (true) {
            System.out.print(text);
            try {
                return br.readLine();
            } catch (Exception e) {
                System.err.println("Fehler bei der Verarbeitung: "
                        + e.getLocalizedMessage());
            }
        }
    }

    /**
     * Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und
     * gibt diese als String zurueck.
     * 
     * @return Einen Wert vom Typ <tt>String</tt> der die Benutzereingabe
     *         enthält.
     */
    public static String getInputString() {
        while (true) {
            try {
                return br.readLine();
            } catch (Exception e) {
                System.err.println("Fehler bei der Verarbeitung: "
                        + e.getLocalizedMessage());
            }
        }
    }

    /**
     * Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und
     * gibt diese als Integer zurueck.
     * 
     * @param text Enthaelt die Eingabeaufforderung fuer den Benutzer
     * @return Einen Wert vom Typ <tt>int</tt> der die Benutzereingabe
     *         enthaelt.
     */
    public static int getInputInt(String text) {
        while (true) {
            System.out.print(text);
            try {
                return Integer.parseInt(br.readLine());
            } catch (Exception e) {
                System.err.println("Fehler bei der Verarbeitung: "
                        + e.getLocalizedMessage());
            }
        }
    }

    /**
     * Die Methode liest eine Benutzereingabe von der Eingabeaufforderung und
     * gibt diese als Character zurueck.
     * 
     * @param text Enthaelt die Eingabeaufforderung fuer den Benutzer
     * @return Einen Wert vom Typ <tt>int</tt> der die Benutzereingabe
     *         enthaelt.
     */
    public static char getInputChar(String text) {
        String buffer;
        while (true) {
            System.out.print(text);
            try {
                buffer = br.readLine();
                return buffer.charAt(0);
            } catch (Exception e) {
                System.err.println("Fehler bei der Verarbeitung: "
                        + e.getLocalizedMessage());
            }
        }
    }

    /**
     * Die Methode liest Benutzereingaben mehrerer Zeilen von der
     * Eingabeaufforderung ein und speichert sie in einem ArrayList 
     * 'alleZeilen' und gibt diese ArrayList zurueck.
     * 
     * @param text enthaelt die Eingabeaufforderung fuer den Benutzer
     * @return ArrayList die die Benutzereingabe enthaelt. 
     */
    public static ArrayList<String> getInputStringList(String text) {
        System.out.print(text);
        String zeile;

        // ArrayListObjekt erzeugen
        ArrayList<String> alleZeilen = new ArrayList<>();

        // Eine Zeichenkette wird in einer while-Schleife eingelesen.
        // solange bis der Anwender die Zeichenkette *** eingibt
        zeile = getInputString();
        while (!zeile.equals("***")) {
            // eingelesene Zeile wird ueber die Methode add() in die 
            // ArrayList eingefuegt 
            alleZeilen.add(zeile);
            // Zeile als String ueber die Konsole eingelesen
            zeile = getInputString();
        }
        return alleZeilen;
    }
}