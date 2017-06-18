// Day 24 - More Linked Lists
//
// https://www.hackerrank.com/challenges/30-linked-list-deletion

class Solution {

  public static Node removeDuplicates(Node head) {
    Node prev = null;
    Node now = head;
    Node next = null;

    while (now != null) {
      if (prev != null && prev.data == now.data) {
        prev.next = now.next;
      } else {
        prev = now;
      }

      now = prev.next;
    }

    return head;
  }

}
