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
    //add returns RealNumber, but constructor needs double; thas why we have .getValue()
    System.out.println(h);

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

    System.out.println(e.add(e));
    System.out.println(e.add(c));

    for (int i = 0; i < 50; i++) {
      RealNumber pos = new RealNumber(Math.random()*100);
      RealNumber neg = new RealNumber(Math.random()*-100);
      System.out.println(pos);
      System.out.println(neg);

      RealNumber product = new RealNumber(pos.multiply(neg).getValue());
      System.out.println(product); //all should be (-)
      RealNumber quotient = new RealNumber(product.divide(neg).getValue());
      System.out.println(quotient); //should be equal to pos
      System.out.println(pos.equals(quotient)); //should all be true
      System.out.println();
    }

    System.out.println(e.multiply(f));
    System.out.println(f.multiply(d));
    System.out.println(e.divide(f));
    System.out.println(f.divide(e));

    for (int i = 0; i < 50; i++) {
      RealNumber pos = new RealNumber(Math.random()*10000);
      RealNumber neg = new RealNumber(Math.random()*-10000);
      System.out.println(pos);
      System.out.println(neg);

      //RealNumber e has value 0.0; should be all true
      System.out.println(pos.subtract(pos).equals(e));
      System.out.println(neg.subtract(neg).equals(e));

      System.out.println(pos.subtract(neg)); //should all be (+)
      System.out.println(neg.subtract(pos)); //should all be (-)
      System.out.println();
    }

    System.out.println(e.subtract(e));
    RealNumber j = new RealNumber(f.subtract(g).getValue());
    System.out.println(j);

    System.out.println();
    System.out.println();

    RationalNumber cat = new RationalNumber(3,5);
    RationalNumber dog = new RationalNumber(-10, 2);
    RationalNumber frog = new RationalNumber(2, -10);
    RationalNumber log = new RationalNumber(0, 0);
    RationalNumber stonks = new RationalNumber(0, 11);
    RationalNumber pog = new RationalNumber(10, 0);

    RationalNumber[] rat = new RationalNumber[6];
    rat[0] = cat;
    rat[1] = dog;
    rat[2] = frog;
    rat[3] = log;
    rat[4] = stonks;
    rat[5] = pog;

    for (int i = 0; i < rat.length; i++) {
      System.out.println(rat[i].getNumerator());
      System.out.println(rat[i].getDenominator());
      System.out.println(rat[i].getValue());
      System.out.println();
    }
  }
}
