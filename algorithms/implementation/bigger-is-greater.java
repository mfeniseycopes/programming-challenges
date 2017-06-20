// Bigger is Greater
//
// https://www.hackerrank.com/challenges/bigger-is-greater

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();

    for (int i = 0; i < N; i++) {
      System.out.println(embiggen(in.next()));
    }
  }

  static String embiggen(String s) {

    char[] chars = s.toCharArray();

    int low, high;
    low = high = -1;
    for (int i = chars.length - 1; i > 0; i--) {
      if (i <= low) break;
      for (int j = i; j >= 0; j--) {
        if (chars[j] < chars[i] && j > low) {
          low = j;
          high = i;
        }
      }
    }

    if (low != -1) {
      char t = chars[low];
      chars[low] = chars[high];
      chars[high] = t;
      Arrays.sort(chars, low + 1, chars.length);
      return new String(chars);
    } else {
      return "no answer";
    }
  }
}
