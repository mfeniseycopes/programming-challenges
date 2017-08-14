// Sherlock and the anagrams
// https://www.hackerrank.com/challenges/sherlock-and-anagrams

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  static int choose(int n, int k) {
    int num = 1;
    int den = 1;

    for (int i = 0; i < k; i++) {
      num  = num * (n - i);
      den = den * (i + 1);
    }

    return num / den;
  }

  static int sherlockAndAnagrams(String s){
    HashMap<String, Integer> anagrams = new HashMap<String, Integer>();

    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {

        char[] subChars = s.substring(i, j).toCharArray();
        Arrays.sort(subChars);

        String sortedSub = new String(subChars);

        Integer count = anagrams.get(sortedSub);

        anagrams.put(sortedSub, count == null ? 1 : count + 1);
      }
    }

    Object[] anagramKeys = anagrams.keySet().toArray();
    int total = 0;

    for (int i = 0; i < anagramKeys.length; i++) {

      String key = (String) anagramKeys[i];
      Integer count = anagrams.get(key);

      if (count > 1) total = total + choose(count, 2);
    }

    return total;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for(int a0 = 0; a0 < q; a0++){
      String s = in.next();
      int result = sherlockAndAnagrams(s);
      System.out.println(result);
    }
  }
}
