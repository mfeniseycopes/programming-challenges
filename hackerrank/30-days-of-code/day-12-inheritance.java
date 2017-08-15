// Day 12 - Inheritance
//
// https://www.hackerrank.com/challenges/30-inheritance

class Student extends Person{
  private int[] testScores;

  private float average() {
    int sum = 0;

    for (int val : this.testScores) {
      sum += val;
    }

    return (sum / (float)this.testScores.length);
  }

  /*
   * Class Constructor
   * @param firstName - A string denoting the Person's first name.
   * @param lastName - A string denoting the Person's last name.
   * @param id - An integer denoting the Person's ID number.
   * @param scores - An array of integers denoting the Person's test scores.
   *	                            */
  Student(String firstName, String lastName, int identification, int[] testScores) {
    super(firstName, lastName, identification);
    this.testScores = testScores;
  }

  /*
   * Method Name: calculate
   * @return A character denoting the grade.
   */
  char calculate() {
    float avg = this.average();

    if (avg >= 90) {
      return 'O';
    } else if (avg >= 80) {
      return 'E';
    } else if (avg >= 70) {
      return 'A';
    } else if (avg >= 55) {
      return 'P';
    } else if (avg >= 40) {
      return 'D';
    } else {
      return 'T';
    }
  }
}
