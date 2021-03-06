// Day 13 - Abstract Classes
//
// https://www.hackerrank.com/challenges/30-abstract-classes

abstract class Book {
  String title;
  String author;

  Book(String title, String author) {
    this.title = title;
    this.author = author;
  }

  abstract void display();
}

class MyBook extends Book {

  int price;

  /**
   * Class Constructor
   *
   * @param title The book's title.
   * @param author The book's author.
   * @param price The book's price.
   **/
  MyBook(String title, String author, int price) {
    super(title, author);
    this.price = price;
  }

  /**
   * Method Name: display
   *
   * Print the title, author, and price in the specified format.
   **/
  void display() {
    System.out.println("Title: " + this.title);
    System.out.println("Author: " + this.author);
    System.out.println("Price: " + this.price);
  }
}
