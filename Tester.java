public class Tester {

  public static void main(String[] args) {
    RealNumber a = new RealNumber(0.0000005);
    System.out.println(a.getValue());
    System.out.println(a.toString());

    RealNumber b = new RealNumber(0.0000001);
    System.out.println(a.equals(b));
    System.out.println(b.equals(a));

    RealNumber c = new RealNumber(1.0000005);
    RealNumber d = new RealNumber(1.0000001);
    System.out.println(c.equals(d));
    System.out.println(d.equals(c));

    RealNumber e = new RealNumber(0);
    System.out.println(e.equals(e));
    System.out.println(e.equals(b));
    System.out.println(b.equals(e));
  }
}
