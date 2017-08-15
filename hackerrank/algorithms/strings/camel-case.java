// CamelCase
//
// https://www.hackerrank.com/challenges/camelcase

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    
    int words = 0;
    
    if (s.length() > 0) words++;
    
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) < 'a') words++;
    }
    
    System.out.println(words);
  }
}

