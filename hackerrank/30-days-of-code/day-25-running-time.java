// Day 25 - Running Time
//
// https://www.hackerrank.com/challenges/30-running-time-and-complexity

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int i = 0; i < T; i++) {
      System.out.println(prime(sc.nextInt()) ? "Prime" : "Not prime");
    }
  }

  public static Boolean prime(int k) {
    if (k == 1) return false;

    for (int i = 2; i < k / 2 + 1; i++) {
      if (k % i == 0) return false;
    }

    return true;
  }
}

