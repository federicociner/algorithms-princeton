package edu.algorithms.week1;

public class QuickUnionUF {
  private int[] id;

  public QuickUnionUF(final int N) {
    id = new int[N];

    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public int root(final int j) {
    int i = j;

    while (i != id[i]) {
      i = id[i];
    }

    return i;
  }

  public boolean connected(final int q, final int p) {
    return root(p) == root(q);
  }

  public void union(final int p, final int q) {
    int i = root(p);
    int j = root(q);
    id[i] = j;
  }
}
