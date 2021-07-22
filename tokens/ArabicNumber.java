package tokens;

public class ArabicNumber extends NumberToken {
  private int value;

  public ArabicNumber(String token) {
    value = Integer.parseInt(token);
  }

  public ArabicNumber(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public int getValue() {
    return value;
  }
}