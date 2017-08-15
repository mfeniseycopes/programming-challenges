// The Grid Search
//
// https://www.hackerrank.com/challenges/the-grid-search
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    for(int a0 = 0; a0 < t; a0++) {
      int R = in.nextInt();
      int C = in.nextInt();
      String[] G = new String[R];

      for(int G_i = 0; G_i < R; G_i++) {
        G[G_i] = in.next();
      }

      int r = in.nextInt();
      int c = in.nextInt();
      String[] P = new String[r];

      for(int P_i=0; P_i < r; P_i++) {
        P[P_i] = in.next();
      }

      System.out.println(hasPattern(G, P, R, C, r, c) ? "YES" : "NO");
    }
  }

  static Boolean hasPattern(String[] G, String[] P,
                            int G_r, int G_c, int P_r, int P_c) {

    // grid rows
    for (int G_i = 0; G_i < G_r - P_r + 1; G_i++) {
      // grid cols
      for (int G_j = 0; G_j < G_c - P_c + 1; G_j++) {

        // pattern rows
        Boolean match = true;
        for (int P_i = 0; P_i < P_r; P_i++) {

          // just compare strings
          String gridStr = G[G_i + P_i].substring(G_j, G_j + P_c);
          String patternStr = P[P_i];

          if (!gridStr.equals(patternStr)) {
            match = false;
            break;
          }
        }

        // if found, return result
        if (match == true) return true;
      }
    }

    return false;
  }
}
