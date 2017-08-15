// Richie Rich
// https://www.hackerrank.com/challenges/richie-rich

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  static String richieRich(String s, int n, int k) {

    char[] digits = s.toCharArray();
    boolean[] changes = new boolean[digits.length];
    boolean isPalindrome = false;

    //for (int i = 0; i < s.length(); i++) digits[i] = Character.getNumericValue(s.charAt(i));

    // make palindrome
    for (int i = 0; i < digits.length / 2; i++) {

      // prevent negative indexing
      int j = digits.length - 1 - i;
      if (j < 0) break;

      char left = digits[i];
      char right = digits[j];

      if (left != right) {

        // can't fix
        if (k < 1) return "-1";

        // change smaller to larger
        if (left > right) digits[j] = left;
        else digits[i] = right;

        // mark as changed
        changes[i] = true;
        k--;
      }
    }

    // improve palindrome
    for (int i = 0; (i < digits.length / 2) && k > 0; i++) {

      // prevent negative indexing
      int j = digits.length - 1 - i;
      if (j < 0) break;

      if (digits[i] != '9') {

        // take back last change if already fixed
        int nextK = changes[i] ? k - 1 : k - 2;

        // update or break out
        if (nextK < 0) break;
        else k = nextK;

        // make larger palindrome
        digits[i] = '9';
        digits[j] = '9';
      }
    }

    // deal with the middle digit
    if (digits.length % 2 == 1 && k > 0) {
      digits[digits.length / 2] = '9';
    }

    return new String(digits);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    String s = in.next();
    String result = richieRich(s, n, k);
    System.out.println(result);
  }
}
