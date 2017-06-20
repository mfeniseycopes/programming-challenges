// Encryption
//
// https://www.hackerrank.com/challenges/encryption

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();

    System.out.println(encrypt(s));
  }

  static String encrypt(String s) {
    // get length
    int l = s.length();

    // begin the building
    StringBuilder sb = new StringBuilder();

    int rows, cols;
    rows = cols = (int)Math.sqrt(l);
    // ensure rows * cols > l
    if (rows * cols < l) cols++;
    if (rows * cols < l) rows++;

    // build encoded string by indexing into original string
    for (int c = 0; c < cols; c++) {
      for (int r = 0; r < rows; r++) {
        if ((r * cols + c) >= l) continue;
        sb.append(s.charAt(r * cols + c));
      }
      sb.append(' ');
    }

    // extract
    return sb.toString();
  }
}
