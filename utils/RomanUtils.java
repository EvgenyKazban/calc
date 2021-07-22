package utils;

public class RomanUtils {
  private static int[] arab = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
  private static String[] roman = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

  
  public static String arabToRoman(int number)
  {
    String ret = "";
    var i = arab.length - 1;
    while(number > 0) {
      if(number >= arab[i]) {
        ret += roman[i];
        number -= arab[i];
      }
      else {
        i--;
      }
    }
    return ret;
  }

  public static int romanToArab(String number)
  {
    number = number.toUpperCase();
    int ret = 0;
    int i = arab.length - 1;
    int pos = 0;
    while(i >= 0 && pos < number.length()) {
      if(number.length() - pos >= roman[i].length() && number.substring(pos, pos + roman[i].length()).equals(roman[i])) {
        ret += arab[i];
        pos += roman[i].length();
      }
      else
      {
        i--;
      }
    }
    return ret;
  }
}