// Day 18 - Stacks and Queues
//
// https://www.hackerrank.com/challenges/30-queues-stacks/problem

public class Solution {

  Stack<Character> stack;
  Queue<Character> queue;

  Solution() {
    this.stack = new Stack<Character>();
    this.queue = new LinkedList<Character>();
  }

  void pushCharacter(char ch) {
    this.stack.push(ch);
    return;
  }

  void enqueueCharacter(char ch) {
    this.queue.add(ch);
    return;
  }

  char popCharacter() {
    return this.stack.pop();
  }

  char dequeueCharacter() {
    return this.queue.remove();
  }
}
