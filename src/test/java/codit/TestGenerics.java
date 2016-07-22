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
  }
}
