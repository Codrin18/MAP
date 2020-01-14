package Domain;

import java.util.ArrayList;

public class SecondDegreeEquation extends Equation {
    public SecondDegreeEquation(ArrayList<Double> coeff) {
        super(coeff);
    }

    @Override
    public ArrayList<Double> getCoefficients() {
        return this.coefficients;
    }

    @Override
    public ArrayList<Double> getSolutions() {
        Double a = this.coefficients.get(0);
        Double b = this.coefficients.get(1);
        Double c = this.coefficients.get(2);

        Double delta = b*b - 4 * a * c;
        ArrayList<Double> sol = new ArrayList<>();
        if (delta == 0)
        {
            sol.add((-1)*b/(2*a));

        }
        else{
            sol.add(((-1)*b + Math.sqrt(delta))/(2*a));
            sol.add(((-1)*b - Math.sqrt(delta))/(2*a));
        }

        return sol;
    }

    @Override
    public String toString() {
        Double a = this.coefficients.get(0);
        Double b = this.coefficients.get(1);
        Double c = this.coefficients.get(2);

        String equ = a.toString() + "*" + "x^2" + "+" + b.toString() + "*" + "x" + "+" + c.toString();

        return equ;
    }
}
