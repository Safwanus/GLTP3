
package roman;

import java.util.LinkedHashMap;
import java.util.Map;
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

  public static String valueOf(int value) {
    return new RomanNumber(value).toString();
  }

  public static void valueOf(double v) {
    throw new IllegalArgumentException();
  }

  private static int fromRoman(String romanValue) {

    int sum = 0;
    sum += SYMBOLS.get(romanValue.charAt(0));
    for(int i = 1; i < romanValue.length(); i++){
      sum += SYMBOLS.get(romanValue.charAt(i));
      if(SYMBOLS.get(romanValue.charAt(i)) > SYMBOLS.get(romanValue.charAt(i - 1)))
        sum -= SYMBOLS.get(romanValue.charAt(i - 1)) * 2;
    }
    return sum;
    
  }
  

  private static String toRoman(int value) {
  if((value <= 3999) && ( value > 0)){

    String res = "";
    for(Map.Entry<String, Integer> entry : SYMBOLS.entrySet()){
      int matches = value/entry.getValue();
      res += repeat(entry.getKey(), matches);
      value = value % entry.getValue();
    }
    return res;
  }
  else { throw new IllegalArgumentException();}

  }
  public static String repeat(String s, int n) {
      if(s == null) {
        return null;
      }
      final StringBuilder sb = new StringBuilder();
      for(int i = 0; i < n; i++) {
        sb.append(s);
      }
      return sb.toString();
  }

  private static String toRoman(float value){
    throw new IllegalArgumentException();
  }

  private static String toRoman(String value) {
    throw new IllegalArgumentException();
  }
}
