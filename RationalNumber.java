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
    if (deno == 0) {
      nume = 0;
      deno = 1;
    }
    numerator = nume;
    denominator = deno;
  }

}
