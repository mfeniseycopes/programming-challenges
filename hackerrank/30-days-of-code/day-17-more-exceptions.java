// Day 17 - More Exceptions
//
// https://www.hackerrank.com/challenges/30-more-exceptions/problem

class Calculator {

  int power(int n, int p) throws Exception {
    if (n < 0 || p < 0) {
      throw new Exception("n and p should be non-negative");
    }

    int pow = 1;
    for (int i = 0; i < p; i++) {
      pow *= n;
    }

    return pow;
  }
}
