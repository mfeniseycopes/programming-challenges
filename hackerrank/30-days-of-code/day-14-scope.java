// Day 14 - Scope
//
// https://www.hackerrank.com/challenges/30-scope

class Difference {
  private int[] elements;
  public int maximumDifference;

  Difference(int[] elements) {
    this.elements = elements;
  }

  int computeDifference() {
    int min = this.elements[0];
    int max = this.elements[0];

    for (int i = 1; i < elements.length; i++) {
      int el = this.elements[i];
      if (el < min) { min = el; }
      if (el > max) { max = el; }
    }

    this.maximumDifference = Math.abs(max - min);
    return this.maximumDifference;
  }
}
