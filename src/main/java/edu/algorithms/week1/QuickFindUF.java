package edu.algorithms.week1;

public class QuickFindUF {
  private int[] id;

  public QuickFindUF(final int N) {
    id = new int[N];

    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public boolean connected(final int p, final int q) {
    return id[p] == id[q];
  }

  public void union(final int p, final int q) {
    int pid = id[p];
    int qid = id[q];

    for (int i = 0; i < id.length; i++) {
      if (id[i] == pid) {
        id[i] = qid;
      }
    }
  }
}
