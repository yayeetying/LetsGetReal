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

    RealNumber f = new RealNumber(12.75);
    RealNumber g = new RealNumber(0.75);
    System.out.println(f.add(g)); //Java calls RealNumber's getValue() automatically
    RealNumber h = new RealNumber(g.add(f).getValue());
    //add returns RealNumber, but constructor needs double
    System.out.println(h);

    System.out.println(e.add(e));
    System.out.println(e.add(c));

    for (int i = 0; i < 50; i++) {
      RealNumber pos = new RealNumber(Math.random()*10000);
      RealNumber neg = new RealNumber(Math.random()*-10000);
      System.out.println(pos);
      System.out.println(neg);

      RealNumber sum1 = new RealNumber(neg.add(pos).getValue());
      RealNumber sum2 = new RealNumber(pos.add(neg).getValue());
      System.out.println(sum1); //calls RealNumber's getValue()
      System.out.println(sum1.equals(sum2)); //all should be true

      System.out.println(neg.add(neg));
      System.out.println();
    }

  }
}
