package arraylist.cocktailgen;

/**
 * Dient als Menue und Realisierung der Benutzerinteraktionen.
 * 
 * @author VFH, Anka Shergowski, Karsten Hornemann
 * @version 2.0
 */
public class MeinCocktailMixer {

    private CocktailBar cbar;

    /** Main-Methode. */
    public static void main(String[] args) {
        new MeinCocktailMixer();
    }

    /** Konstruktor. */
    public MeinCocktailMixer() {
        cbar = new CocktailBar();
        String file = CocktailKonsole
                .getInputString("\n  Bitte geben Sie den Namen Ihres Cocktailmixers ein: "
                        + "\n  ('***' wenn noch kein Name vorhanden ist)");
        if (!file.equals("***")) {
            cbar.einlesen(file);
        }
        System.out
                .println("\n  Willkommen bei -> M e i n C o c k t a i l M i x e r <- und Gutes Gelingen!\n");
        menue();
    }

    /**
     * menue() wird vom Konstruktor aufgerufen und stellt die Menueauswahl von 5
     * Punkten.:<br>
     * 1. Suche nach Cocktail nach Name<br>
     * 2. Neuen Cocktail eingeben<br>
     * 3. Alle Cocktails ausgeben<br>
     * 4. MeinCocktailMixer speichern und beenden<br>
     * 0. Ohne Speichern Beenden<br>
     * Nach Auswahl des Menuepunktes wird in einer swich-case Anweisung die
     * naechste Methode aufgerufen (z.B. sucheCock()).
     */
    public void menue() {
        int auswahlInt;
        do {
            menueText();
            auswahlInt = CocktailKonsole
                    .getInputInt("\n  Bitte geben Sie eine Nummer ein: ");
            switch (auswahlInt) {
            case 1:
                String cName = CocktailKonsole
                        .getInputString("\n  Welchen Cocktail suchen Sie?: ");
                sucheCock(cName);
                break;
            case 2:
                neuCock();
                break;
            case 3:
                outCock();
                break;
            case 4:
                close();
                break;
            case 0:
                unsave();
                break;
            default:
                System.out.println("\n  Eingabefehler!");
                break;
            }
        } while (auswahlInt != 4 && auswahlInt != 0);
    }

    /**
     * Gibt das Hauptmenue aus.
     */
    private void menueText() {
        System.out
                .println("\n\n  ~~~~~~~~~~~~~~~~~~~~~~~ MeinCocktailMixer ~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out
                .println("\n  Bitte waehlen Sie eine Funktion:\n  1. Suche nach Cocktail nach Name\n  2. Neuen Cocktail eingeben");
        System.out
                .println("  3. Alle Cocktails ausgeben\n  4. MeinCocktailMixer speichern und beenden");
        System.out.println("  0. Ohne Speichern Beenden");
    }

    /**
     * Die Methode durchsucht die in CocktailBar gespeicherten Cocktails nach
     * dem uebergebenen Cocktailname. Moegliche Suchergebnisse:<br>
     * - Es sind noch keine Cocktailrezepte vorhanden<br>
     * - Fuer diesen Cocktail ist noch kein Rezept vorhanden<br>
     * - Ausgabe des Cocktailrezeptes, wenn eines gefunden wurde
     * 
     * @param name
     *            Cocktailname nach dem gesucht werden soll
     */
    public boolean sucheCock(String name) {
        // alle in der Cocktailbar vorhanden Cocktails holen
        Cocktail[] coAr = cbar.getCocktails();

        boolean found = false;

        // pruefen ob Cocktails vorhanden sind
        if (coAr.length < 1) {
            System.out
                    .println("\n  Es sind noch keine Cocktailrezepte vorhanden");
            return found;
        } else {
            int i = 0;
            // pruefen ob Cocktailname in Cocktailbar vorhanden ist
            while (i < coAr.length && !coAr[i].getCName().equals(name)) {
                i++;
            }
            // Cocktail gefunden
            if (i < coAr.length) {
                System.out.println("\n  Das Rezept fuer den " + name
                        + " lautet:");
                System.out.println(coAr[i]);
                found = true;
                // Cocktail nicht gefunden
            } else {
                System.out.println("\n  Fuer" + name
                        + " ist noch kein Rezept vorhanden");
            }
        }
        return found;
    }

    /**
     * Die Methode neuCock() erstellt ein neues Cocktailrezept. Dabei wird
     * zunaechst geprueft, ob es den Cocktail bereits gibt. Wenn nicht, wird der
     * Konstruktor der Klasse Cocktail aufgerufen, welcher die Eingabe des
     * Cocktails regelt. Ist der Cocktail eingegeben, wird er in CocktailBar
     * gespeichert.
     */
    public void neuCock() {
        String cName = CocktailKonsole.getInputString("  Name des Cocktails: ");
        // Pruefen ob Cocktail bereits vorhanden ist
        if (sucheCock(cName)) {
            System.out.println("\n  Diesen Cocktail gibt es schon!");
            return;
        }
        // neuen Cocktail eingeben
        Cocktail cockObj = new Cocktail(cName);
        // Cocktail in die Cocktailbar speichern
        cbar.addCocktail(cockObj);
        System.out.println("\n  Neuer Cocktail ist in der BAR!");
    }

    /**
     * outCock() gibt alle in CocktailBar gespeicherten Rezepte aus, bzw. gibt
     * eine Fehlermeldung falls keine Rezepte vorhanden sind.
     */
    public void outCock() {
        Cocktail[] coAr = cbar.getCocktails();
        if (coAr.length < 1) {
            System.out.println("\n  Keine Cocktailrezepte vorhanden!");
            return;
        } else {
            System.out.println("\n  Liste aller Cocktails:");
            for (int i = 0; i < coAr.length; i++) {
                System.out.println(coAr[i]);
            }
        }
    }

    /**
     * Speichert die CocktailBar in die angegebene Datei und beendet das
     * Programm.
     */
    public void close() {
        String file = CocktailKonsole
                .getInputString("\n  Bitte geben Sie den Namen Ihres Cocktailmixers ein: ");
        cbar.sichern(file);
        System.out.println("\n  MeinCocktailMixer wird gesichert.");
        System.out
                .println("\n\n  Danke, Bis zum naechsten Mal!\n  Ihre Cocktailsoftware AG\n");
    }

    /**
     * Beendet das Programm ohne zu speichern.
     */
    public void unsave() {
        System.out
                .println("\n  ! ! ! MeinCocktailMixer wird ohne Speicherung beendet ! ! !");
        System.out
                .println("\n\n   Danke, Bis zum naechsten Mal!\n  Ihre Cocktailsoftware AG\n\n");
    }
}
