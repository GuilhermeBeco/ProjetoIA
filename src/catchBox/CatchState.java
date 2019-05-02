package catchBox;

import agentSearch.Action;
import agentSearch.State;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.abs;

public class CatchState extends State implements Cloneable {
    private int catchLine;
    private int catchCol;
    private  int lineBlank;
    private  int colBlank;
    protected int[][] matrix;
    private int goalLine;
    private int goalCol;


    public CatchState(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix.length]; //é uma matriz sempre quadrada??
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j]=matrix[i][j];
                if(this.matrix[i][j]==0){
                    lineBlank=i;
                    colBlank=j;
                }
            }

        }
    }
    public CatchState(int[][] matrix,int x) {
        this.matrix = new int[matrix.length][matrix.length]; //é uma matriz sempre quadrada??
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j]=matrix[i][j];
                if(this.matrix[i][j]==0){
                    lineBlank=i;
                    colBlank=j;
                }
                if(this.matrix[i][j]==Properties.CATCH)
                {
                    catchLine=i;
                    catchCol=j;
                }
            }

        }
    }

    public void executeAction(Action action) {
        action.execute(this);
        // TODO
        fireUpdatedEnvironment();

        throw new NotImplementedException(); // delete after implementing
    }

    public boolean canMoveUp() {
        if(catchLine-1>=0) {
            if (matrix[catchLine - 1][catchCol] != Properties.WALL||matrix[catchLine - 1][catchCol] != Properties.DOOR) {
                return true;
            }
        }
        return false;
        //é isto??
    }

    public boolean canMoveRight() {
        if(catchCol+1<=matrix.length) {
            if (matrix[catchLine][catchCol + 1] != Properties.WALL||matrix[catchLine][catchCol + 1] != Properties.DOOR) {
                return true;
            }
        }
        return false;
    }

    public boolean canMoveDown() {
        if(catchLine+1<=matrix.length) {
            if (matrix[catchLine +1][catchCol] != Properties.WALL||matrix[catchLine +1][catchCol] != Properties.DOOR) {
                return true;
            }
        }
        return false;
    }

    public boolean canMoveLeft() {
        if(catchCol-1>=0) {
            if (matrix[catchLine][catchCol -1] != Properties.WALL||matrix[catchLine][catchCol -1] != Properties.DOOR) {
                return true;
            }
        }
        return false;
    }

    public void moveUp() {
       matrix[catchLine][catchCol]=Properties.EMPTY;
       matrix[catchLine--][catchCol]=Properties.CATCH;
       catchLine--;//está aqui bem e está certo?
    }

    public void moveRight() {
        matrix[catchLine][catchCol]=Properties.EMPTY;
        matrix[catchLine][catchCol++]=Properties.CATCH;
        catchCol++;
    }

    public void moveDown() {
        matrix[catchLine][catchCol]=Properties.EMPTY;
        matrix[catchLine++][catchCol]=Properties.CATCH;
        catchLine++;
    }

    public void moveLeft() {
        matrix[catchLine][catchCol]=Properties.EMPTY;
        matrix[catchLine][catchCol--]=Properties.CATCH;
        catchCol--;
    }

    public int getNumBox() {
        int count=0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
                if(matrix[i][j]==Properties.BOX)
                    count++;
            }
        }
        return count;
    }

    public void setCellCatch(int line, int column) {
        catchCol=column;
        catchLine=line;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setGoal(int line, int column) {
       goalLine=line;
       goalCol=column;
    }

    public int getGoalLine() {
        return goalLine;
    }

    public int getGoalCol() {
        return goalCol;
    }

    public int getSteps() {
        //TODO//idk
        throw new NotImplementedException();
    }

    public int getSize() {
        return matrix.length;//???
    }

    public Color getCellColor(int line, int column) {
        switch (matrix[line][column]) {
            case Properties.BOX:
                return Properties.COLORBOX;
            case Properties.CATCH:
                return Properties.COLORCATCH;
            case Properties.DOOR:
                return Properties.COLORDOOR;
            case Properties.WALL:
                return Properties.COLORWALL;
            default:
                return Properties.COLOREMPTY;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CatchState)) {
            return false;
        }

        CatchState o = (CatchState) other;
        if (matrix.length != o.matrix.length) {
            return false;
        }

        return Arrays.deepEquals(matrix, o.matrix);
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Arrays.deepHashCode(this.matrix);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            buffer.append('\n');
            for (int j = 0; j < matrix.length; j++) {
                buffer.append(matrix[i][j]);
                buffer.append(' ');
            }
        }
        return buffer.toString();
    }

    @Override
    public CatchState clone() {
        return new CatchState(matrix);
    }

    //Listeners
    private final ArrayList<EnvironmentListener> listeners = new ArrayList<>();

    public synchronized void addEnvironmentListener(EnvironmentListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

    public synchronized void removeEnvironmentListener(EnvironmentListener l) {
        listeners.remove(l);
    }

    public void fireUpdatedEnvironment() {
        for (EnvironmentListener listener : listeners) {
            listener.environmentUpdated();
        }
    }
    public int getCatchLine(){
        return catchLine;
    }

    public int getCatchCol() {
        return catchCol;
    }
    public double distancia(CatchState state){
        return abs(state.getCatchLine()-state.getGoalLine())+abs(state.getCatchCol()-state.getGoalCol());
    }
    //qual a aproach???
    public double distancia(Cell goal) {
        return abs(this.getCatchLine() - goal.getLine()) + abs(this.getCatchCol() - goal.getColumn());
    }
}
