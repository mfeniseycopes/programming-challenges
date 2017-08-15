// Day 16: Exceptions - String to Integer
//
// https://www.hackerrank.com/challenges/30-exceptions-string-to-integer

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();

    try {
      System.out.println(Integer.parseInt(s));
    } catch (NumberFormatException e) {
      System.out.println("Bad String");
    }

  }
}
