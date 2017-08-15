// Absolute Permutation
//
// https://www.hackerrank.com/challenges/absolute-permutation

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    for(int a0 = 0; a0 < t; a0++){
      int n = in.nextInt();
      int k = in.nextInt();

       absolutePermutation(n, k);
    }
  }


  static void absolutePermutation(int n, int k) {

    // no swapping necessary
    if (k == 0 || n == 0) {
      for (int i = 1; i <= n; i++) System.out.print(i + " ");
    }
    // not possible
    else if (n % (2 * k) != 0) {
      System.out.print(-1);
    }
    // possible
    else {
      int i = 1;
      int g = 1;

      // in groups of 2k, swap ith with k + ith element
      while (i <= n) {
        int swap = g <= k ? i + k : i - k;
        // print as we go to keep space complexity constant
        System.out.print(swap + " ");

        // keep track of index and group index
        i++;
        g = (g % (2 * k)) + 1;
      }
    }

    System.out.println("");
  }
}
