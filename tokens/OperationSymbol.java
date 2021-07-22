package tokens;

public class OperationSymbol extends Token {
  private char operation;
  
  public OperationSymbol(String operation) {
      this.operation = operation.charAt(0);
  }

  private int calc(int a, int b) {
    switch(operation) {
      case '+':
        return a + b;
      case '-':
        return a - b;
      case '*':
        return a * b;
      case '/':
        return a / b;
    }
    return -1;
  }

  public NumberToken operate(NumberToken firstParam, NumberToken secondParam) {
    int result = calc(firstParam.getValue(), secondParam.getValue());

    if(firstParam instanceof ArabicNumber) {
      return new ArabicNumber(result);
    } else {
      return new RomanNumber(result);
    }
  }
}