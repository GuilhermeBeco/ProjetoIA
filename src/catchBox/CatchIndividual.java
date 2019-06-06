package catchBox;

import ga.IntVectorIndividual;

import java.util.HashMap;
import java.util.Hashtable;
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
        LinkedList<Cell> boxes = problem.getCellsBoxes();
        Cell catchCell = problem.getCellCatch();
        Cell door = problem.getDoor();
        fitness = computeFitnessAux(catchCell,boxes.get(genome[0]-1));



        for (int i = 0; i <genome.length - 1; i++) {
            fitness+=computeFitnessAux(boxes.get(genome[i]-1),boxes.get(genome[i+1]-1));
        }
        fitness+=computeFitnessAux(boxes.get(genome[genome.length-1]-1),door);

        return fitness;
    }
    public double computeFitnessAux(Cell c1,Cell c2){
        HashMap<String,Integer> hashtable=problem.getPairs();
        double ret=0;
        String s=""+c1.getLine()+"-"+c1.getColumn()+"-"+c2.getLine()+"-"+c2.getColumn();
         if(hashtable.containsKey(s)){
             return hashtable.get(s);
         }
         s=""+c2.getLine()+"-"+c2.getColumn()+"-"+c1.getLine()+"-"+c1.getColumn();;
        return hashtable.get(s);
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
