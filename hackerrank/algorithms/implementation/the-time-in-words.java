// The Time in WOrds
//
// https://www.hackerrank.com/challenges/the-time-in-words

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int h = in.nextInt();
    int m = in.nextInt();

    System.out.println(timeInWords(h, m));
  }

  static String timeInWords(int h, int m) {
    String hour = subTwenty(h);
    switch(m) {
      case 0:  return subTwenty(h) + " o' clock";
      case 15: return "quarter past " + subTwenty(h);
      case 30: return "half past " + subTwenty(h);
      case 45: return "quarter to " + subTwenty(h + 1);
    }

    if (m == 1) {
      return "one minute past " + subTwenty(h);
    } else if (m < 20) {
      return subTwenty(m) + " minutes past " + subTwenty(h);
    } else if (m < 30) {
      return "twenty " + subTwenty(m % 10) + " minutes past " + subTwenty(h);
    } else if (m < 40) {
      return "twenty " + subTwenty(10 - (m % 10)) + " minutes to " + subTwenty((h % 12) + 1);
    } else if (m != 59) {
      return subTwenty(60 - m) + " minutes to " + subTwenty((h % 12) + 1);
    } else {
      return "one minute to " + subTwenty((h % 12) + 1);
    }
  }

  static String subTwenty(int n) {
    switch(n) {
      case 1: return "one";
      case 2: return "two";
      case 3: return "three";
      case 4: return "four";
      case 5: return "five";
      case 6: return "six";
      case 7: return "seven";
      case 8: return "eight";
      case 9: return "nine";
      case 10: return "ten";
      case 11: return "eleven";
      case 12: return "twelve";
      case 13: return "thirteen";
      case 14: return "fifteen";
      case 16: return "sixteen";
      case 17: return "seventeen";
      case 18: return "eighteen";
      case 19: return "nineteen";
      default: return "";
    }
  }
}
