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
    RationalNumber tog = new RationalNumber(1, 3);
    RationalNumber fog = new RationalNumber(3, 1);

    RationalNumber[] rat = new RationalNumber[8];
    rat[0] = cat;
    rat[1] = dog;
    rat[2] = frog;
    rat[3] = log;
    rat[4] = stonks;
    rat[5] = pog;
    rat[6] = tog;
    rat[7] = fog;

    for (int i = 0; i < rat.length; i++) {
      System.out.println(rat[i].getNumerator());
      System.out.println(rat[i].getDenominator());
      System.out.println(rat[i].getValue());
      System.out.println();
    }

    RealNumber bub = new RealNumber(0.6);
    System.out.println(bub.equals(cat));
    System.out.println(cat.equals(bub));
    System.out.println(f.add(log));
    System.out.println(f.add(dog));
    System.out.println(log.add(f));
    System.out.println();

    for (int i = 0; i < rat.length; i++) {
      RationalNumber recipro = rat[i].reciprocal();
      System.out.println(recipro.getNumerator());
      System.out.println(recipro.getDenominator());
      System.out.println(recipro.getValue());
      //System.out.println(rat[i].reciprocal()); //automatically calls toString
      System.out.println();
    }

    //RationalNumber.equals(RationalNumber) --> calls equals method from RationalNumber class
    System.out.println(log.equals(log));
    System.out.println(pog.equals(log));
    System.out.println(stonks.equals(pog));
    System.out.println(tog.equals(fog.reciprocal()));
    System.out.println();
    //RealNumber.equals(RealNumber) --> calls equals method from RealNumber class
    //RealNumber.equals(RationalNumber) --> calls equals method from RealNumber class
    System.out.println(bub.equals(cat));
    RationalNumber tub = new RationalNumber(51, 4);
    System.out.println(f.equals(tub));
    System.out.println(a.equals(tub));
    System.out.println();
    //RationalNumber.equals(RealNumber) --> calls equals method from RealNumber class
    System.out.println(cat.equals(bub));
    System.out.println(tub.equals(f));
    System.out.println(tub.equals(a));


  }
}
