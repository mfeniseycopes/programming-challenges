// Non-Divisible Subset
//
// https://www.hackerrank.com/challenges/non-divisible-subset

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] set = new int[N];

    for (int i = 0; i < N; i++) {
      set[i] = sc.nextInt();
    }

    System.out.println(nonDivisibleSubset(set, N, K));
  }

  static int nonDivisibleSubset(int[] set, int n, int k) {
    // initialize count for each modulus value
    int[] mods = new int[k];
    for (int i = 0; i < k; i++) { mods[i] = 0; }

    // get count for each modulus for each element of set
    for (int i = 0; i < n; i++) {
      mods[set[i] % k]++;
    }

    // we can only include one which is evenly divisible by k
    int maxSize = mods[0] > 0 ? 1 : 0;
    // we don't want to include k/2 in our iteration
    int midpt = k % 2 == 0 ? ((k - 1) / 2) : (k / 2);
    
    // take the largest of each pair which sums to a value
    // divisible by k; add to maxSize
    for (int i = 1; i <= midpt; i++) {
      maxSize += Math.max(mods[i], mods[k - i]);
    }
  
    // again, we can only take one of values that evenly divide
    // k/2; if we took a pair they would sum to k
    if (k % 2 == 0 && mods[k / 2] > 0) maxSize++;

    return maxSize;
  }
}
