// Reduced String
//
// https://www.hackerrank.com/challenges/reduced-string

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  static void build(StringBuilder sb, int seqLength, char last) {
    if (seqLength % 2 == 1) {
      if (sb.length() != 0 && sb.charAt(sb.length() - 1) == last) {
        sb.deleteCharAt(sb.length() - 1);
      } else {
        sb.append(last);
      }
    }
  }

  static String super_reduced_string(String s) {i

    StringBuilder sb = new StringBuilder();
    int seqLength = 1;
    char last = s.charAt(0);
    char c = last;

    for (int i = 1; i < s.length(); i++) {
      c = s.charAt(i);
      if (c != last) {
        build(sb, seqLength, last);
        seqLength = 0;
      }
      seqLength++;

      last = c;
    }

    build(sb, seqLength, last);

    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    String result = super_reduced_string(s);
    System.out.println(result.length() > 0 ? result : "Empty String");
  }
}

