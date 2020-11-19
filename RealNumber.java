public class RealNumber {
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


}
