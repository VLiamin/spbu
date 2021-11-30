package ru.liamin.vladimir.util;


public class Factorial {

  public static int getValue(int n) {
    if (n <= 1) {
      return 1;
    }

    return n * getValue(n - 1);
  }

}
