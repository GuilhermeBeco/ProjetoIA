package catchBox;

import ga.Individual;
import ga.Problem;


import java.util.LinkedList;

public class CatchProblemForGA implements Problem<CatchIndividual> {
    private LinkedList<Cell> cellsBoxes;
    private LinkedList<Pair> pairs;
    private Cell cellCatch;
    private Cell door;

    public CatchProblemForGA(LinkedList<Cell> cellsBoxes,LinkedList<Pair> pairs,Cell cellCatch,Cell door) {
        this.cellsBoxes=cellsBoxes;
        this.pairs=pairs;
        this.cellCatch=cellCatch;
        this.door=door;

    }

    @Override
    public CatchIndividual getNewIndividual() {
       return new CatchIndividual(this,cellsBoxes.size());
    }

    @Override
    public String toString() {
        //TODO
        throw new UnsupportedOperationException();
    }

    public LinkedList<Cell> getCellsBoxes() {
        return cellsBoxes;
    }

    public void setCellsBoxes(LinkedList<Cell> cellsBoxes) {
        this.cellsBoxes = cellsBoxes;
    }

    public LinkedList<Pair> getPairs() {
        return pairs;
    }

    public void setPairs(LinkedList<Pair> pairs) {
        this.pairs = pairs;
    }

    public Cell getCellCatch() {
        return cellCatch;
    }

    public void setCellCatch(Cell cellCatch) {
        this.cellCatch = cellCatch;
    }

    public Cell getDoor() {
        return door;
    }

    public void setDoor(Cell door) {
        this.door = door;
    }
}
