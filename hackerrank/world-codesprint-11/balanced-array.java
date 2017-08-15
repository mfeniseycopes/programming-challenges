// Balanced Array
//
// https://www.hackerrank.com/contests/world-codesprint-11/challenges/balanced-array

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  static int solve(int[] a){
    int lhs = 0, rhs = 0;
    int midpt = a.length / 2;

    for (int i = 0; i < midpt; i++) {
      lhs += a[i];
      rhs += a[midpt + i];
    }

    return Math.abs(rhs - lhs);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    for (int a_i=0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }
    int result = solve(a);
    System.out.println(result);
  }
}

