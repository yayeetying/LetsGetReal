public abstract class Number {

  public abstract double getValue();

  // public int compareTo(Number other) {
  //
  // }

  public boolean equals(Number other) {
    //^Number other: means you can take in a RealNumber or a Rational
    if (getValue() == 0 && other.getValue() == 0) {
      return true;
    }
    double percentDiff = Math.abs((this.getValue()-other.getValue()) /
                        ((this.getValue()+other.getValue()) /2.0)) * 100;
    return percentDiff <= 0.001;
  }


}
