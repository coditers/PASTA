package codit;

/**
 * Created by Jisung on 7/19/2016.
 */
public class Test {
  private static Test ourInstance = new Test();

  public static Test getInstance() {
    return ourInstance;
  }

  private Test() {
  }

  enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    // field
    private final int value;

    // constructor
    Coin(int value) {this.value = value; }

    // method
    public int value() {return value;}

  }

  enum Pet {
    DOG("doggy", 5, 4) {
      public String toString() {
        return this.getName() +":"+ this.getAge() +":"+ this.getLeg();
      }
    },
    CAT("kitty", 2, 4) {
      public String toString() {
        return this.getName() +":::"+ this.getAge() +":::"+ this.getLeg();
      }

    }

    ;


    private final String name;
    private final int age;
    private final int leg;

    Pet(String name, int age, int leg) {
      this.name = name;
      this.age = age;
      this.leg = leg;
    }

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }

    public int getLeg() {
      return leg;
    }
  }

  public int Price(Coin coin) {

    return coin.value();
  }



  public int[] [] []test1(int[][][][][][] aaaaaa)[] [] []{
    return aaaaaa;
  }

  public int [] test2(int[] a) {
    return a;
  }

  public int test3(int[] a) [] {
    return a;
  }



  public static void main(String[] args) {

    Test test = new Test();

    int price = test.Price(Coin.PENNY);

    int price2 = Coin.DIME.value();

    System.out.println(price);
    System.out.println(price2);

    String str = Pet.DOG.toString();
    System.out.println(str);

    String str2 = Pet.CAT.toString();
    System.out.println(str2);

    System.out.println( test.test1(new int[][][][][][]{{{{{{1}}}}}})[0][0][0][0][0][0] );
    System.out.println( test.test2(new int[]{1})[0] );
    System.out.println( test.test3(new int[]{2})[0] );
  }
}
