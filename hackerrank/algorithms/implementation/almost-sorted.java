// Almost Sorted
//
// https://www.hackerrank.com/challenges/almost-sorted

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    int[] arr = new int[n];

    int last = 100001;
    int revCount = 0;
    int revStart = -1;
    int revEnd = -1;
    int offCount = 0;
    int[] offs = new int[2];

    for (int i = 0; i < n; i++) {
      int el = scan.nextInt();
      arr[i] = el;

      // track reverses
      if (el <= last) {
        revEnd = i;

      // track out of orders
      } else if (el < last) {
        if (offCount < 2) offs[offCount] = i;
        offCount++;

      // reset reverses
      } else {
        if (revStart != revEnd) revCount++;
        revStart = i;
        revEnd = i;
      }

      last = el;
    }
    if (revStart != revEnd) revCount++;

    // we can swap
    if (offCount == 2 && revCount < 2) {
      System.out.println("swap " + offs[0] + " " + offs[1]);

    // we can reverse
    } else if (revCount == 1 && revStart < revEnd) {
       System.out.println("reverse " + revStart + " " + revEnd);
    }
  }
}
