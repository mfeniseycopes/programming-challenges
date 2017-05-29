// Day 4: Class vs Instance
//
// https://www.hackerrank.com/challenges/30-class-vs-instance

public class Person {

  private int age;

  public Person(int initialAge) {
    if (initialAge < 0) {
      System.out.println("Age is not valid, setting age to 0.");
      age = 0;
    } else {
      age = initialAge;
    }
  }

  public void amIOld() {
    String status;
    if (age < 13) {
      status = "young";
    } else if (age < 18) {
      status = "a teenager";
    } else {
      status = "old";
    }

    System.out.println("You are " + status + ".");
  }

  public void yearPasses() {
    age++;
  }
}

