package catchBox;

import agentSearch.Heuristic;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class HeuristicCatch extends Heuristic<CatchProblemSearch, CatchState> {

    @Override
    public double compute(CatchState state) {
        return state.distancia(problem.getGoalPos());
        //qual a aproach???
    }

    @Override
    public String toString() {
        return "Distancia entre o carrigo e o objetivo";
    }
}