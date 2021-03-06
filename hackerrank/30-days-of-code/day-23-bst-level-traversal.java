// Day 23 - BST Level Traversal
//
// https://www.hackerrank.com/challenges/30-binary-trees

import java.io.*;
import java.util.*;

class Node{
  Node left,right;
  int data;
  Node(int data){
    this.data=data;
    left=right=null;
  }
}

class Solution {

  static void levelOrder(Node root){
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);

    Node next;
    while(q.peek() != null) {
      next = q.remove();
      if (next.left != null) q.add(next.left);
      if (next.right != null) q.add(next.right);
      System.out.print(next.data + " ");
    }
  }

  public static Node insert(Node root,int data){
    if(root==null){
      return new Node(data);
    }
    else{
      Node cur;
      if(data<=root.data){
        cur=insert(root.left,data);
        root.left=cur;
      }
      else{
        cur=insert(root.right,data);
        root.right=cur;
      }
      return root;
    }
  }

  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int T=sc.nextInt();
    Node root=null;
    while(T-->0){
      int data=sc.nextInt();
      root=insert(root,data);
    }
    levelOrder(root);
  }
}
