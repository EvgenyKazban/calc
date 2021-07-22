package tokens;

import utils.RomanUtils;

public class RomanNumber extends NumberToken {
  
  private int value;

  public RomanNumber(String token) {
    value = RomanUtils.romanToArab(token);
  }

  public RomanNumber(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return RomanUtils.arabToRoman(value);
  }

  public int getValue() {
    return value;
  }

}