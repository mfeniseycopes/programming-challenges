// Big Sorting
// https://www.hackerrank.com/challenges/big-sorting

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void sort(String[] arr) {

    int MAX_DIGITS = (int)Math.pow(10, 6);
    int NUM_BUCKETS = 10;

    ArrayList<Queue<String>> buckets = new ArrayList<Queue<String>>();

    for (int i = 0; i < NUM_BUCKETS; i++) {
      buckets.add(new LinkedList<String>());
    }

    // initially populate buckets
    for (int i = 0; i < arr.length; i++) {
      // get num and one's digits
      String num = arr[i];
      int digit = num.length() - 1;
      int bucket = Integer.parseInt(num.substring(digit, digit + 1));

      // place in right bucket
      buckets.get(bucket).add(num);
    }

    int sortedIdx = 0;
    // for each radix (1 <= el <= 2 * 10 ^ 5)
    for (int i = 2; i <= MAX_DIGITS; i++) {


      // add sentinels
      for (int j = 0; j < NUM_BUCKETS; j++) {
        buckets.get(j).add("SENTINEL");
      }

      for (int j = 0; j < NUM_BUCKETS; j++) {

        String num;

        while (true) {
          num = buckets.get(j).remove();

          if (num.equals("SENTINEL")) break;

          int digit = num.length() - i;

          // this number still has sorting to be done
          if (digit > -1) {
            int bucket = Integer.parseInt(num.substring(digit, digit + 1));
            buckets.get(bucket).add(num);

          // this number should be placed in the sorted arr
          } else {
            arr[sortedIdx] = num;
            sortedIdx++;
          }
        }
      }
    }

    // put elements back in array
    for (int i = 0; i < NUM_BUCKETS; i++) {

      while (buckets.get(i).size() > 0) {
        arr[sortedIdx] = buckets.get(i).remove();

        sortedIdx++;
      }

    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String[] unsorted = new String[n];
    for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
      unsorted[unsorted_i] = in.next();
    }
    sort(unsorted);

    for (int i = 0; i < unsorted.length; i++) {

      System.out.println(unsorted[i]);

    }
  }
}
