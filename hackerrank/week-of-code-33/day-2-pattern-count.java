// Day 2 - Pattern Count
//
// https://www.hackerrank.com/contests/w33/challenges/pattern-count

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  static int patternCount(String s) {
    Integer p = 0;
    Boolean first = false;
    Boolean zero = false;

    for (int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      switch(c) {
        case '0':
          if (first) { zero = true; }
          break;
        case '1':
          if (first && zero) { p += 1; zero = false; }
          else { first = true; zero = false; }
          break;
        default:
          first = false;
          zero = false;
      }
    }

    return p;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for(int a0 = 0; a0 < q; a0++){
      String s = in.next();
      int result = patternCount(s);
      System.out.println(result);
    }
  }
}

