// Day 21 - Generics
//
// https://www.hackerrank.com/challenges/30-generics

class Printer <T> {
  /*
   * Method Name: printArray
   * Print each element of the generic array on a new line. Do not return anything.
   * @param A generic array
   */
  void printArray(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
}
