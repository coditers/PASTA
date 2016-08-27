package io.jaylim.test;


public class Task {
  public int task(int A[]) {
    short s = 3;
    int i = 3;
    long l = 4L;

    char c = 'c';
    String s = "str";

    boolean b = true;

    String n = null;

    double d = 3.3;
    float f = 3.2f;

    int iArray[] = new int[10];
    for (int idx = 0; idx < 10; idx++) {
      iArray[idx] = idx;
    }

    for (int iElement : iArray) {
      System.out.println(iElement);
    }
  }
}
