public class RealNumber extends Number{
  //instance variables
  private double value;

  //constructor
  public RealNumber(double v) {
    value = v;
  }

  public double getValue(){
    return value;
  }

  public String toString() {
    return "" + getValue();
  }

  //has inherited .equals() method;

  public RealNumber add(RealNumber other) {
    //other can be ANY RealNumber, including a RationalNumber
    //or other subclasses of RealNumber (that aren't written yet)
    double sum = this.getValue() + other.getValue();
    RealNumber total = new RealNumber(sum);
    return total;
  }

  public RealNumber multiply(RealNumber other) {
    RealNumber product = new RealNumber(this.getValue() * other.getValue());
    return product;
  }

  public RealNumber divide(RealNumber other) {
    RealNumber quotient = new RealNumber(this.getValue() / other.getValue());
    return quotient;
  }

  public RealNumber subtract(RealNumber other) {
    RealNumber difference = new RealNumber(this.getValue() - other.getValue());
    return difference;
  }


}
