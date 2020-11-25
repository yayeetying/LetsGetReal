public class RationalNumber extends Number {
  //'extends': RationalNumber (subclass/child) inherited Number (superclass/parent)
  //subclass inherits instance variables and methods from superclass
  //can override inherited methods in the subclass to modify the fxn of the method
    //specifically in that subclass

  private int numerator, denominator;

  //Initialize the RationalNumber with the provided values
  //if the denominator is 0, make the fraction 0/1 instead
  //If the denominator is negative, negate both numerator and denominator
  public RationalNumber(int nume, int deno) {
    //super(0.0); //this value is ignored!
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
    reduce();
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
    RationalNumber reci = new RationalNumber(getDenominator(), getNumerator());
    return reci;
  }

  //Rational.equals(Rational) calls this (RationalNumber method)
  //Real.equals(Real) or Real.equals(Rational) calls equals method from Number class
  //what about Rational.equals(Real)? *calls equals method from Number class
  public boolean equals(RationalNumber other) { //overriden method
    //System.out.println("pog");
    return this.getNumerator() == other.getNumerator() && this.getDenominator() == other.getDenominator();
  }

  public String toString() {
    if (getDenominator() == 1) return "" + getNumerator();
    if (getNumerator() == 0) return "" + 0;
    return "" + getNumerator() + "/" + getDenominator();
  }

  private static int gcd(int a, int b) {
    int gcd = 1;
    int x = Math.abs(a);
    int y = Math.abs(b);
    for (int i = 2; i <= Math.min(x,y); i++) {
      if (a % i == 0 && b % i == 0) {
        gcd = i;
      }
    }
    return gcd;
  }

  private void reduce() {
    int common = gcd(getNumerator(), getDenominator());
    if (common != 0) {
      numerator /= common;
      denominator /= common;
    }
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

  //static method to get least common denominator
  public static int getLCD(int a, int b) {
    int common = gcd(a,b);
    return (a*b)/common;
  }
  //30/-50 - 63/81. Expected -7/5 | Output -70/50

  public RationalNumber add(RationalNumber other) {
    int deno = getLCD(this.getDenominator(), other.getDenominator());
    int nume1 = (deno/this.getDenominator()) * getNumerator();
    int nume2 = (deno/other.getDenominator()) * other.getNumerator();
    RationalNumber sum = new RationalNumber(nume1+nume2, deno);
    return sum;
  }

  public RationalNumber subtract(RationalNumber other) {
    int deno = getLCD(this.getDenominator(), other.getDenominator());
    int nume1 = (deno/this.getDenominator()) * getNumerator();
    int nume2 = (deno/other.getDenominator()) * other.getNumerator();
    RationalNumber difference = new RationalNumber(nume1-nume2, deno);
    return difference;
  }

}
