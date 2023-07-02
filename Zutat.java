package arraylist.cocktailgen;

import java.io.Serializable;

/**
 * Speichert den Name und die Menge einer Cocktail-Zutat ab.
 * @author skalt
 * @version 3.0, 07/2009   
 */
public class Zutat implements Serializable {

  private String zutat; // Zutat-Objekt
  private String menge; // Menge als String, 
                        // da Einheit dazu angegeben wird z.B. 2 cl

  /**
   * Erzeugt ein Zutat Objekt.
   * @param zutat Zutatenname
   * @param menge Mengenangabe
   */
  public Zutat(String zutat, String menge) {
    this.zutat=zutat;
    this.menge=menge;
  }
  /**
   * Methode zur Rueckgabe der gespeicherten Werte; Hier: Menge.
   * @return Mengenangabe
   */
  public String getMenge(){
    return menge;
  }

  /**
   * Methode zur Rueckgabe der gespeicherten Werte; Hier: Zutat
   * @return Zutatenname
   */
  public String getZutat(){
    return zutat;
  }

   /**
     * Methode zum Ausgeben eines Zutat-Objektes als String.
     * @return Zutatenname
     */
    public String toString(){
      return "[Zutat: " + zutat +" Menge: " + menge+"]";
  }

}