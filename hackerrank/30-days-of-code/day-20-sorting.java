// Day 20 - Sorting
//
// https://www.hackerrank.com/challenges/30-sorting

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    for(int a_i=0; a_i < n; a_i++){
      a[a_i] = in.nextInt();
    }
    bubbleSort(a);
  }

  public static void bubbleSort(int[] arr) {

    int numSwaps = 0;

    for (int i = 0; i < arr.length; i++) {
      int numInnerSwaps = 0;

      for (int j = 0; j < arr.length - 1; j++) {

        if (arr[j] > arr[j + 1]) {
          numInnerSwaps++;
          int t = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = t;
        }
      }

      numSwaps += numInnerSwaps;
      if (numInnerSwaps == 0) break;
    }

    System.out.println("Array is sorted in " + numSwaps + " swaps.");
    System.out.println("First Element: " + arr[0]);
    System.out.println("Last Element: " + arr[arr.length - 1]);
    return;
  }
}

