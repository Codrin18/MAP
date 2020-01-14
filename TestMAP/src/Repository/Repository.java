package Repository;

import Domain.Equation;

import java.util.ArrayList;

public class Repository {
    private ArrayList<Equation> equations = new ArrayList<>();

    public void add(Equation e){
        this.equations.add(e);
    }

    public ArrayList<Equation> getEquations() {
        return equations;
    }

    public void setEquations(ArrayList<Equation> equations) {
        this.equations = equations;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "equations=" + equations +
                '}';
    }
}
