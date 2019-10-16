
package roman;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public final class RomanNumber extends Number {

  public static final long serialVersionUID = 1L;

  // Table des symboles
  private static final LinkedHashMap<String, Integer> SYMBOLS = new LinkedHashMap<>();
  static {
    SYMBOLS.put("M",  1000);
    SYMBOLS.put("CM", 900);
    SYMBOLS.put("D",  500);
    SYMBOLS.put("CD", 400);
    SYMBOLS.put("C",  100);
    SYMBOLS.put("XC", 90);
    SYMBOLS.put("L",  50);
    SYMBOLS.put("XL", 40);
    SYMBOLS.put("X",  10);
    SYMBOLS.put("IX", 9);
    SYMBOLS.put("V",  5);
    SYMBOLS.put("IV", 4);
    SYMBOLS.put("I", 1);
  }

  // Expression reguliere de validation
  private static final Pattern VALIDATION_RE = Pattern.compile(
      "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

  private final int value;

  public RomanNumber(String romanValue) {
    this.value = fromRoman(romanValue);
  }

  public RomanNumber(int value) {
    this.value = value;
  }

  /**
   * @{inheritDoc}
   */
  @Override
  public double doubleValue() {
    // TODO
    return 0;
  }

  /**
   * @{inheritDoc}
   */
  @Override
  public float floatValue() {
    // TODO
    return 0;
  }

  /**
   * @{inheritDoc}
   */
  @Override
  public int intValue() {
    // TODO
    return 0;
  }

  /**
   * @{inheritDoc}
   */
  @Override
  public long longValue() {
    // TODO
    return 0;
  }

  @Override
  public String toString() {
    return toRoman(this.value);
  }

  public static RomanNumber valueOf(String roman) {
    return new RomanNumber(roman);
  }

  public static RomanNumber valueOf(int value) {
    return new RomanNumber(value);
  }

  private static int fromRoman(String romanValue) {
    
    int roman = 0;
    int val1, val2;
    for (int i = 0; i < value.length(); i++) {
	val1 = SYMBOLS.get(value.charAt(i));
	 if (i < value.length()-1) {
		val2 = SYMBOLS.get(value.charAt(i+1));
		if (val1 >= val2) {
			resultat += val1;
		} else {
			resultat += (val2 - val1);
			i += 1;
		}
	} else {
		resultat += val1;
		}			
    }
    return roman;
  }
  

  private static String toRoman(int value) {
  if((value <= 3999) && ( value > 0)){

    int l =  SYMBOLS.floorKey(value);

    if ( value == l ) {
       return SYMBOLS.get(value);
    }

    return SYMBOLS.get(l) + toRoman(value-l);
  }

  else { throw new IllegalArgumentException();}
    
  }
}
