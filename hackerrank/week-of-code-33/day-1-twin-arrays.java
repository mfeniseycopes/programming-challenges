// Day 1 - Twin Arrays
//
// https://www.hackerrank.com/contests/w33/challenges/twin-arrays

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  static int twinArrays(int[] ar1, int[] ar2){
    Integer idx1a = 0;
    Integer idx1b = null;
    Integer idx2a = 0;
    Integer idx2b = null;

    for (int i = 1; i < ar1.length; i++) {
      if (ar1[i] < ar1[idx1a]) {
        idx1b = idx1a;
        idx1a = i;
      } else if (idx1b == null || ar1[i] < ar1[idx1b]) {
        idx1b = i;
      }
    }

    for (int i = 1; i < ar2.length; i++) {
      if (ar2[i] < ar2[idx2a]) {
        idx2b = idx2a;
        idx2a = i;
      } else if (idx2b == null || ar2[i] < ar2[idx2b]) {
        idx2b = i;
      }
    }

    if (idx1a != idx2a) {
      return ar1[idx1a] + ar2[idx2a];
    } else {
      return Math.min(ar1[idx1b] + ar2[idx2a], ar1[idx1a] + ar2[idx2b]);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] ar1 = new int[n];
    for(int ar1_i = 0; ar1_i < n; ar1_i++){
      ar1[ar1_i] = in.nextInt();
    }
    int[] ar2 = new int[n];
    for(int ar2_i = 0; ar2_i < n; ar2_i++){
      ar2[ar2_i] = in.nextInt();
    }
    int result = twinArrays(ar1, ar2);
    System.out.println(result);
  }
}

