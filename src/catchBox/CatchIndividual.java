package catchBox;

import ga.IntVectorIndividual;

import java.util.LinkedList;

public class CatchIndividual extends IntVectorIndividual<CatchProblemForGA, CatchIndividual> {

    public CatchIndividual(CatchProblemForGA problem, int size) {
        super(problem, size);
    }

    public CatchIndividual(CatchIndividual original) {
        super(original);
    }

    @Override
    public double computeFitness() {
        LinkedList<Pair> pares= problem.getPairs();
        LinkedList<Cell> boxes=problem.getCellsBoxes();
        Cell catchCell = problem.getCellCatch();
        Cell door=problem.getDoor();
        double fitness=0;

        for (int i = 0; i < pares.size(); i++) {
            Pair par=pares.get(i);

            if(par.getCell1()==catchCell&&par.getCell2()==boxes.get(genome[0])){ ///de onde vei a ordem das caixa, é do genome???
                fitness=fitness+par.getValue();
            }

        }

        for (int i = 0; i <genome.length; i++) {
            for (int j = 0; j <pares.size(); j++) {
                Pair par=pares.get(i);
                if(par.getCell1(genome[i])==boxes)
            }

        }
    }

    public int[] getGenome() {
        return genome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("fitness: ");
        sb.append(fitness);
        sb.append("\npath: ");
        for (int i = 0; i <genome.length ; i++) {
            sb.append(genome[i]).append(" ");
        }
        return sb.toString();
    }

    /**
     * @param i
     * @return 1 if this object is BETTER than i, -1 if it is WORST than I and
     * 0, otherwise.
     */
    @Override
    public int compareTo(CatchIndividual i) {
        return (this.fitness == i.getFitness()) ? 0 : (this.fitness < i.getFitness()) ? 1 : -1;
    }

    @Override
    public CatchIndividual clone() {
        return new CatchIndividual(this);

    }
}
