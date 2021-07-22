import tokens.*;
import utils.RomanUtils;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    String[] tokens = line.split(" ");

    if(tokens.length != 3) {
      throw new IllegalArgumentException("Неверный формат ввода (допустимые форматы: a + b, a - b, a * b, a / b)");
    }

    Token one = Token.parse(tokens[0]);
    Token two = Token.parse(tokens[1]);
    Token three = Token.parse(tokens[2]);

    if(!(two instanceof OperationSymbol)) {
      throw new IllegalArgumentException("Допустимые арифметические символы: +, -, *, /");
    }

    if(!(one instanceof NumberToken) || !(three instanceof NumberToken)) {
      throw new IllegalArgumentException("Неверный формат ввода (допустимые форматы: a + b, a - b, a * b, a / b)");
    }

    if((one instanceof ArabicNumber && three instanceof RomanNumber) || (one instanceof RomanNumber && three instanceof ArabicNumber)) {
      throw new NumberFormatException("Оба числа должны быть либо арабскими, либо римскими");
    }

    int oneValue = ((NumberToken) one).getValue();
    int threeValue = ((NumberToken) three).getValue();

    if(oneValue < 1 || oneValue > 10 || threeValue < 1 || threeValue > 10) {
      throw new NumberFormatException("Числа должны быть от 1 до 10 включительно");
    }

    Token result = ((OperationSymbol) two).operate(((NumberToken) one), ((NumberToken) three));
    System.out.println(result);
  }
}