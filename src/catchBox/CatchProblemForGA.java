package catchBox;

import ga.Individual;
import ga.Problem;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

public class CatchProblemForGA implements Problem<CatchIndividual> {
    private LinkedList<Cell> cellsBoxes;
    private HashMap<String, Integer> hashtable;
    private Cell cellCatch;
    private Cell door;

    public CatchProblemForGA(LinkedList<Cell> cellsBoxes,LinkedList<Pair> pairs,Cell cellCatch,Cell door) {
        this.cellsBoxes=cellsBoxes;
        this.cellCatch=cellCatch;
        this.door=door;
        hashtable=new HashMap<String,Integer>();
        carregaHash(pairs);

    }

    private void carregaHash(LinkedList<Pair> pairs) {
        for (int i = 0; i <pairs.size(); i++) {
            Cell c1=pairs.get(i).getCell1();
            Cell c2 = pairs.get(i).getCell2();
            String s=""+c1.getLine()+"-"+c1.getColumn()+"-"+c2.getLine()+"-"+c2.getColumn();
            hashtable.put(s,pairs.get(i).getValue());
            //hashtable.put(c1.getLine()*1000+c1.getColumn()*100+c2.getLine()*10+c2.getColumn(),pairs.get(i).getValue())
        }
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

    public HashMap<String,Integer> getPairs() {
        return hashtable;
    }

    public void setPairs(LinkedList<Pair> pairs) {
        carregaHash(pairs);
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
