package edu.algorithms.week1;

public class Main {
  public static void main(final String[] args) {
    final int N = 10;
    QuickFindUF quickFind = new QuickFindUF(N);

    quickFind.union(2, 3);
    quickFind.union(1, 3);
    quickFind.union(4, 7);

    System.out.println(quickFind.connected(1, 3));
    System.out.println(quickFind.connected(2, 3));
    System.out.println(quickFind.connected(3, 4));
    System.out.println(quickFind.connected(4, 6));
  }
}
