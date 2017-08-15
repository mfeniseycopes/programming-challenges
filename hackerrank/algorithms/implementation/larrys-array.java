// Larry's Array
//
// https://www.hackerrank.com/challenges/larrys-array

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int k = scan.nextInt();
      
      int[] arr = new int[k];
      for (int j = 0; j < k; j++) arr[j] = scan.nextInt();
      
      System.out.println(larry(k, arr) ? "YES" : "NO");
    }
  }

  public static boolean larry(int n, int[] arr) {
    int rightAndLess = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[i] > arr[j]) rightAndLess++;
      }
    }
    /* 
    * each element, starting with the rightmost which has elements less 
    * than it to its right, can "hop" right (2 steps) and successfully be 
    * relatively ordered compared to its neighbors on the left 
    */
    return rightAndLess % 2 == 0; 
  }
}
