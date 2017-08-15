// Bear and the Steady Gene
// https://www.hackerrank.com/challenges/bear-and-steady-gene

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int geneswaps(String s) {
      int k = s.length() / 4;

      int a = 0, c = 0, t = 0, g = 0;

      for (int i = 0; i < s.length(); i++) {

        char gene = s.charAt(i);

         switch(gene) {
          case 'A': a++; break;
          case 'C': c++; break;
          case 'T': t++; break;
          case 'G': g++; break;
        }
      }

      if (a == k && c == k && t == k && g == k) return 0;

      a = 0; c = 0; t = 0; g = 0;

      int left = 0;

      while (true) {
        int _a = a, _c = c, _t = t, _g = g;
        char gene = s.charAt(left);

        switch(gene) {
          case 'A': _a++; break;
          case 'C': _c++; break;
          case 'T': _t++; break;
          case 'G': _g++; break;
        }

        if (_a > k || _c > k || _t > k || _g > k) break;

        left++;
        a = _a; c = _c; t = _t; g = _g;
      }

      int right = s.length() - 1;
      int min = s.length();

      while (!(a > k || c > k || t > k || g > k) && right > left && left >= 0) {

        int subSize = (right - left + 1);

        if (subSize < min) {
          min = subSize;
        }

        char gene = s.charAt(right);

        switch(gene) {
          case 'A': a++; break;i
          case 'C': c++; break;
          case 'T': t++; break;
          case 'G': g++; break;
        }

        right--;

        // while not meeting variant
        while ((a > k || c > k || t > k || g > k) && left > 0) {

          left--;
          gene = s.charAt(left);

          switch(gene) {
            case 'A': a--; break;
            case 'C': c--; break;
            case 'T': t--; break;
            case 'G': g--; break;
          }

        }
      }

      return min;
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      String s = in.next();
      int result = geneswaps(s);
      System.out.println(result);
    }
}
