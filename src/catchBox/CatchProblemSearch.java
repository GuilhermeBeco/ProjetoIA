package catchBox;

import agentSearch.Action;
import agentSearch.Problem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;
import java.util.List;

public class CatchProblemSearch<S extends CatchState> extends Problem<S> {
    private Cell goalPos;
    private S initial;
    private List<Action> actions;
    public CatchProblemSearch(S initialCatchState, Cell goalPosition) {
        super(initialCatchState);
        actions = new LinkedList<Action>() {{
            add(new ActionDown());
            add(new ActionUp());
            add(new ActionRight());
            add(new ActionLeft());
        }};
        this.goalPos=goalPosition;

    }

    @Override
    public List<S> executeActions(S state) {
        List<S> successors = new LinkedList<>();

        for (Action action : actions) {
            if (action.isValid(state)) {
                S sucessor = (S) state.clone();
                action.execute(sucessor);
                successors.add(sucessor);
            }
        }
        return successors;
    }

    public boolean isGoal(S state) {
      int line=state.getLine();
      int col=state.getCatchCol();
      if(line==goalPos.getLine()&&col==goalPos.getColumn()){
          return true;
      }
      return false;
    }
    public double computePathCost(List<Action> path) {
        return path.size();
    }
}
