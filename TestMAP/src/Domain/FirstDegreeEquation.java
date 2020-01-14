package Domain;

import java.util.ArrayList;

public class FirstDegreeEquation extends Equation {

    public FirstDegreeEquation(ArrayList<Double> coeff) {
        super(coeff);
    }

    @Override
    public ArrayList<Double> getCoefficients() {
        return this.coefficients;
    }



    @Override
    public ArrayList<Double> getSolutions() {
        ArrayList<Double> sol = new ArrayList<>();
        sol.add((-1)*this.coefficients.get(1)/this.coefficients.get(0));

        return  sol;
    }

    @Override
    public String toString() {
        String equ = new String(this.coefficients.get(0).toString() + "x" + "+ " + this.coefficients.get(1).toString());
        return equ;
    }
}
