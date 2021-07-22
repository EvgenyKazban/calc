package tokens;

public class Token {
  public static Token parse(String token) {
    if(token.equals("*") || token.equals("/") || token.equals("-") || token.equals("+")) {
      return new OperationSymbol(token);
    }
    
    try {
      Integer.valueOf(token);
      return new ArabicNumber(token);
    } catch(NumberFormatException exc) {
      return new RomanNumber(token);
    }
  }
}