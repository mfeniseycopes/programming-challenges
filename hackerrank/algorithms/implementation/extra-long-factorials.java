// Extra Long Factorials
//
// https://www.hackerrank.com/challenges/extra-long-factorials

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(factorial(n));
  }

  static BigInteger factorial(int n) {
    BigInteger fact = BigInteger.valueOf(1);
    for (int i = 1; i <= n; i++) {
      fact = fact.multiply(BigInteger.valueOf(i));
    }

    return fact;
  }
}

