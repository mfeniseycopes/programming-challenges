// Common Child
// https://www.hackerrank.com/challenges/common-child

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  // delegates to char[] method to prevent unnecessary String creations
  static int commonChild(String s1, String s2){

    int[][] memo = new int[s1.length()][s2.length()];

    for (int i = 0; i < s1.length(); i++) {
      for (int j = 0; j < s2.length(); j++) {
        memo[i][j] = -1;
      }
    }

    return commonChild(s1.toCharArray(), 0, s2.toCharArray(), 0, memo);
  }

  public static int commonChild(char[] c1, int i1, char[] c2, int i2, int[][] memo) {

    // base case
    if (i1 >= c1.length || i2 >= c2.length) return 0;

    // memo
    int precalculated = memo[i1][i2];
    int[] keys = new int[] { i1, i2 };

    if (precalculated != -1) return precalculated;

    // we found a match, check neighbors
    if (c1[i1] == c2[i2]) {

      return 1 + commonChild(c1, i1 + 1, c2, i2 + 1, memo);

      // no match check left, right or middle
    } else {

      int left = 0, middle = 0, right = 0;

      // left
      left = commonChild(c1, i1 + 1, c2, i2, memo);

      // middle
      middle = commonChild(c1, i1 + 1, c2, i2 + 1, memo);

      // right
      right = commonChild(c1, i1, c2, i2 + 1, memo);

      // choose the best
      int result = Math.max(left, Math.max(middle, right));

      // memoize result
      memo[keys[0]][keys[1]] = result;

      return result;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s1 = in.next();
    String s2 = in.next();
    int result = commonChild(s1, s2);
    System.out.println(result);
  }
}
