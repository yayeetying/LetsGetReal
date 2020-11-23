public class RationalNumber extends RealNumber {
  //'extends': RationalNumber (subclass/child) inherited RealNumber (superclass/parent)
  //subclass inherits instance variables and methods from superclass
  //can override inherited methods in the subclass to modify the fxn of the method
    //specifically in that subclass

  private int numerator, denominator;

  //Initialize the RationalNumber with the provided values
  //if the denominator is 0, make the fraction 0/1 instead
  //If the denominator is negative, negate both numerator and denominator
  public RationalNumber(int nume, int deno) {
    super(0.0); //this value is ignored!
    numerator = nume;
    denominator = deno;
    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    }
    else if (deno < 0) {
      numerator *= -1;
      denominator *= -1;
    }
    if (this.getValue() != 0.0) reduce(); //(1/-4); switch the negate sign
  }

  public double getValue() { //overridden method
    return (double) numerator / (double) denominator;
  }

  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  //return a new RationalNumber w/ nume and deno of this RationalNumber reversed
  public RationalNumber reciprocal() {
    RationalNumber reci = new RationalNumber(this.getDenominator(), this.getNumerator());
    return reci;
  }

  //Rational.equals(Rational) calls this (RationalNumber method)
  //Real.equals(Real) or Real.equals(Rational) calls equals method from RealNumber class
  //what about Rational.equals(Real)? *calls equals method from RealNumber class
  public boolean equals(RationalNumber other) { //overriden method
    //System.out.println("pog");
    return this.getNumerator() == other.getNumerator() && this.getDenominator() == other.getDenominator();
  }

  public String toString() {
    return "" + this.getNumerator() + "/" + this.getDenominator();
  }

  //calculate the GCD of 2 integers; http://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
  //public static int gcd(int a, int b) {
  private static int gcd(int a, int b) {
  //   int gcd = 1;
  //   for(int i = 2; i < Math.min(a, b); i++) {
  //     if(a % i == 0 && b % i == 0) {
  //       gcd = i;
  //     }
  //   }
  //   return gcd;
  // }
    if (a < b) {
      int temp = a;
      a = b;
      b = temp;
    } //a will always be >= b
    int r = 1;
    while (r != 0) {
      r = a%b;
      if (r != 0) {
        a = b;
        b = r;
      }
    }
    return b;
  }

  private void reduce() {
    int common = gcd(numerator, denominator);
    numerator /= common;
    denominator /= common;
  }

  public RationalNumber multiply(RationalNumber other) {
    RationalNumber product = new RationalNumber(this.getNumerator()*other.getNumerator(),
                                                this.getDenominator()*other.getDenominator());
    return product;
  }

  public RationalNumber divide(RationalNumber other) {
    RationalNumber quotient = new RationalNumber(this.getNumerator()*other.reciprocal().getNumerator(),
                                                this.getDenominator()*other.reciprocal().getDenominator());
    return quotient;
  }

  public static int getLCD(int a, int b) {
    int gcd = 1;
    int factor = 1;
    while (true) {
      if ((factor * a) % b == 0) {
        return factor * a;
      }
      factor++;
    }
  }

  public RationalNumber add(RationalNumber other) {
    int deno = getLCD(this.getDenominator(), other.getDenominator());
    int nume1 = (deno/this.getDenominator()) * getNumerator();
    int nume2 = (deno/other.getDenominator()) * other.getDenominator();
    RationalNumber sum = new RationalNumber(nume1+nume2, deno);
    return sum;
  }

  public RationalNumber subtract(RationalNumber other) {
    int deno = getLCD(this.getDenominator(), other.getDenominator());
    int nume1 = (deno/this.getDenominator()) * getNumerator();
    int nume2 = (deno/other.getDenominator()) * other.getDenominator();
    RationalNumber difference = new RationalNumber(nume1-nume2, deno);
    return difference;
  }

}
