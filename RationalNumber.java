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
  }

  public double getValue() {
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

}
