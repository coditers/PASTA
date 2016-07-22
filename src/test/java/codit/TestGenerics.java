package codit;

/**
 * Created by Jisung on 7/19/2016.
 */
public class TestGenerics<T> {

  private final T t;
  private final Object k;
  private final Object v;

  public <K, V> TestGenerics(T t, K k, V v) {
    this.t = t;
    this.k = k;
    this.v = v;
  }

  public T getT() {
    return t;
  }

  public Object getK() {
    return k;
  }

  public Object getV() {
    return v;
  }

  public static void main(String[] args) {

    TestGenerics<String> tg = new <String, Integer> TestGenerics<String>("t", "k", 1);


    System.out.println(tg.getT() + ":" + tg.getK() + ":" + tg.getV());

    System.out.println("Wdadawdawdawddd\rd\naa\\\'\"");

    System.out.println(Integer.parseInt("111111"));

    System.out.println(Integer.parseInt("7FFFFFFF", 16));

    int a = 0xFFFFFFFF;
    System.out.println(a);

    int aa = -0xFFFFFFFF;
    System.out.println(aa);

    int b = 0x80000000;
    System.out.println(b);

    int bb = -0x80000000;
    System.out.println(bb);

    int bbb = 0x7FFFFFFF;
    System.out.println(bbb);

    int bbba = -0x7FFFFFFF;
    System.out.println(bbba);

    int bbbb = 0x00000000;
    System.out.println(bbbb);

    int bbbba = -0x00000000;
    System.out.println(bbbba);

    int c = 2147483647;
    System.out.println(c);

    int cc = -2147483648;
    System.out.println(cc);

    for(int in = 0; in < 127; in++) {
      char ch = (char) in;
      System.out.println( "|" + in + " " + ch + " | ");
    }
  }
}
