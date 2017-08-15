// Ema's Supercomputer
//
// https://www.hackerrank.com/challenges/two-pluses

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Plus implements Comparable<Plus> {
  boolean[][] grid;
  public int[] pos;
  public int length;
  public int size;
  
  Plus(int[] pos, boolean[][] grid) {
    this.pos = pos;
    this.grid = grid;
  }
  
  public String toString() {
    return "{ pos: [" + pos[0] + ", " + pos[1] + "], size: " + size + " }";
  }
  
  public void grow() {
    int i = this.pos[0];
    int j = this.pos[1];
    
    int l = 0;
    int maxSize = Math.min(Math.min(i, this.grid.length - i - 1), Math.min(j, this.grid[0].length - j - 1)); 
    
    for (int k = 1; k <= maxSize; k++) {
      if (this.grid[i - k][j] &&
          this.grid[i + k][j] &&
          this.grid[i][j - k] &&
          this.grid[i][j + k]) {
        l++;
      } else { 
        break;
      }
    }
    
    this.length = l;
    this.size = this.length * 4 + 1;
  }
  
  public int compareTo(Plus other) {
    if (this.size > other.size) {
      return 1;
    } else if (this.size < other.size) {
      return -1;
    } else {
      return 0;
    }
  }
  
  public boolean overlaps(Plus smaller) {
    
    if ((this.pos[0] == smaller.pos[0]) && 
        (this.length + smaller.length >= Math.abs(this.pos[1] - smaller.pos[1]))) {
      return true;
    } 
    
    if ((this.pos[1] == smaller.pos[1]) && 
        (this.length + smaller.length >= Math.abs(this.pos[0] - smaller.pos[0]))) {
      return true;
    } 
    
    boolean inside = (
      (this.pos[0] - this.length) <= smaller.pos[0] && smaller.pos[0] <= (this.pos[0] + this.length) &&
      (this.pos[1] - this.length) <= smaller.pos[1] && smaller.pos[1] <= (this.pos[1] + this.length));
    boolean cross = (
      Math.abs(this.pos[0] - smaller.pos[0]) <= smaller.length ||
      Math.abs(this.pos[1] - smaller.pos[1]) <= smaller.length);
    
    return (inside && cross);
  }
}  

public class Solution {

  public static void main(String[] args) {
    // read the inputs
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    boolean [][] grid = new boolean[n][m];
    ArrayList<Plus> plusList = new ArrayList<Plus>();
    
    for (int i = 0; i < n; i++) {
      char[] s = scan.next().toCharArray();
      for (int j = 0; j < m; j++) {
        grid[i][j] = s[j] == 'G' ? true : false;
        
        // add as plus to be explored
        if (grid[i][j]) {
          int[] pos = new int[] { i, j };
          Plus p = new Plus(pos, grid);
          plusList.add(p);
        }
      }
    }
    
    // find all the plusses by iterating over
    int s = plusList.size();
    for (int i = 0; i < s; i++) {
      Plus p = plusList.get(i);
      p.grow();
      
      // brutishly add a Plus for each smaller version 
      for (int l = 1; l < p.length; l++) {
        Plus newP = new Plus(p.pos, grid);
        newP.length = l;
        newP.size = l * 4 + 1;
        plusList.add(newP);
      }
    }
    
    // sort them by length
    Collections.sort(plusList);
    
    // find the maximal/non-overlapping pair
    int maxProd = 0;
    for (int i = plusList.size() - 1; i > 0; i--) {
      for (int j = i - 1; j > -1; j--) {
        Plus a = plusList.get(i);
        Plus b = plusList.get(j);
        int prod = a.size * b.size;

        if (prod >= maxProd && !a.overlaps(b)) {
          maxProd = prod;
        }    
      }
    }
    
    System.out.println(maxProd);
  }
}

