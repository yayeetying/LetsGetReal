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

  public boolean equals(RealNumber other) {
    if (this.getValue() == 0 && other.getValue() == 0) {
      return true;
    }
    double percentDiff = Math.abs((this.getValue()-other.getValue()) /
                        ((this.getValue()+other.getValue()) /2.0)) * 100;
    return percentDiff <= 0.001;
  }


}
