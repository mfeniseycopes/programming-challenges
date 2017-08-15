// Bomber main
//
// https://www.hackerrank.com/challenges/bomber-man

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int r = scan.nextInt();
    int c = scan.nextInt();
    int s = scan.nextInt();

    // read rows
    int[][] grid = new int[r][c];
    for (int i = 0; i < r; i++) {
      String line = scan.next();
      for (int j = 0; j < c; j++) {
        char letter = line.charAt(j);
        grid[i][j] = letter == 'O' ? 3 : 0;
      }
    }

    // otherwise skip and return original
    if (s > 1) {
      // first second (does nothing)
      tick(grid);


      if (s > 5) {
        if (s % 2 == 0) {
          s = 4;
        } else {
          s = ((s - 2) % 4) + 2;
        }
      }

      Boolean planting = true; // initial state
      for (int t = 1; t < s; t++) {
        // decrement and explode bombs
        tick(grid);

        // plant bombs in empty spaces
        if (planting) plantBombs(grid);

        // toggle
        planting = !planting;
      }
    }
    // return final grid / printGrid will be separate function
    printFinal(grid);
  }

  static void tick(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] > 0) {
          grid[i][j]--;

          // if this is exploding && neighbor is not exploding
          // destroy neighbor
          if (grid[i][j] == 0) {
            if (i > 0 && grid[i - 1][j] != 1)
              grid[i - 1][j] = 0;
            if (i < grid.length - 1 && grid[i + 1][j] != 1)
              grid[i + 1][j] = 0;
            if (j > 0 && grid[i][j - 1] != 1)
              grid[i][j - 1] = 0;
            if (j < grid[i].length - 1 && grid[i][j + 1] != 1)
              grid[i][j + 1] = 0;
          }
        }
      }
    }
    return;
  }

  static void plantBombs(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 0) grid[i][j] = 3;
      }
    }
    return;
  }

  static void print(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        System.out.print(grid[i][j]);
      }
      System.out.print("\n");
    }
    System.out.println("----");
    return;
  }

  static void printFinal(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        System.out.print(grid[i][j] < 1 ? '.' : 'O');
      }
      System.out.print("\n");
    }
    return;
  }
}
