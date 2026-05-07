package fr.univ_amu.iut.exercice3;

/**
 * Exercice 3 - Convertisseur de chiffres romains en nombres arabes.
 *
 * <p>Règles :
 *
 * <ul>
 *   <li>Les symboles valides sont {@code I=1, V=5, X=10, L=50, C=100, D=500, M=1000}
 *   <li>Lus de gauche à droite, les symboles s'additionnent : {@code VI = 5 + 1 = 6}
 *   <li>Un symbole placé avant un symbole de valeur supérieure se soustrait : {@code IV = 5 - 1 =
 *       4}
 *   <li>Les seules soustractions valides sont :
 *       <ul>
 *         <li>I avant V ou X ({@code IV = 4}, {@code IX = 9})
 *         <li>X avant L ou C ({@code XL = 40}, {@code XC = 90})
 *         <li>C avant D ou M ({@code CD = 400}, {@code CM = 900})
 *       </ul>
 *       Toute autre soustraction doit lever {@link IllegalArgumentException}.
 * </ul>
 *
 * <p>Conseils TDD : commencez par gérer uniquement {@code I}, puis {@code II} / {@code III} (fake
 * it), puis {@code V} (triangulation), puis {@code VI} (addition de deux symboles différents), puis
 * {@code IV} (introduction de la soustraction). À ce moment-là, <b>extrayez une méthode</b> pour
 * calculer la valeur d'un symbole - vous en aurez besoin pour les symboles suivants.
 */
public class ConvertisseurDeNombreRomain {

  /**
   * Convertit une chaîne de chiffres romains en valeur entière.
   *
   * @param chiffreRomain chaîne composée de symboles romains (par exemple {@code "XLIX"})
   * @return la valeur entière correspondante
   * @throws IllegalArgumentException si la chaîne contient un symbole invalide ou une soustraction
   *     interdite
   */
  public int valeuDe(char c) {
    if (c == 'I') {
      return 1;
    } else if (c == 'V') {
      return 5;
    } else if (c == 'X') {
      return 10;
    } else if (c == 'L') {
      return 50;
    } else if (c == 'C') {
      return 100;
    } else if (c == 'D') {
      return 500;
    } else if (c == 'M') {
      return 1000;
    }
    throw new IllegalArgumentException("pas bon chiffre");
  }

  public int enNombreArabe(String chiffreRomain) {
    int total = 0;
    for (int i = 1; i <= chiffreRomain.length(); i = i + 1) {
      if (i < chiffreRomain.length()
          && ((chiffreRomain.charAt(i - 1) == 'I'
                  && (chiffreRomain.charAt(i) == 'V' || chiffreRomain.charAt(i) == 'X'))
              || (chiffreRomain.charAt(i - 1) == 'X'
                  && (chiffreRomain.charAt(i) == 'L' || chiffreRomain.charAt(i) == 'C'))
              || (chiffreRomain.charAt(i - 1) == 'C'
                  && (chiffreRomain.charAt(i) == 'D' || chiffreRomain.charAt(i) == 'M')))) {
        char u = chiffreRomain.charAt(i - 1);
        char b = chiffreRomain.charAt(i);
        int n = valeuDe(u);
        int c = valeuDe(b);
        total = total + (c - n);
        i = i + 1;
      } else {
        char c = chiffreRomain.charAt(i - 1);
        int n = valeuDe(c);
        total += n;
      }
    }
    return total;
  }
}
