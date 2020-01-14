package Domain;

import java.util.ArrayList;

public abstract class Equation {
    protected ArrayList<Double> coefficients;

    public Equation(ArrayList<Double> coeff){
        this.coefficients = coeff;
    }

      public abstract ArrayList<Double> getCoefficients();

      public int getDegree(){
          if (coefficients.size() == 2)
              return 1;
          return 2;
      }

      public abstract ArrayList<Double> getSolutions();

      public abstract String toString();
}
