package es.udc.intelligentsystems.example;

import es.udc.intelligentsystems.*;

import java.util.ArrayList;


public class GraphSearchStrategy implements SearchStrategy {
    public GraphSearchStrategy() {

    }


    public ArrayList<Node> reconstruct_sol(ArrayList<Node> nodes){
        int size = nodes.size();
        ArrayList<Node> solution = new ArrayList<Node>();
        Node currentNode = nodes.getLast();
        solution.add(currentNode);
        for(int i = size - 1; i > 0; i--){
            Node tempNode=nodes.get(i);
            if (tempNode.getState().equals(currentNode.getParent())){
                solution.add(tempNode);
                currentNode=tempNode;
            }

        }

        return solution;
    }

    @Override
    public ArrayList<Node> solve(SearchProblem p) throws Exception {
        ArrayList<State> explored = new ArrayList<State>();
        ArrayList<Node> nodes= new ArrayList<Node>();
        State currentState = p.getInitialState();
        nodes.add(new Node(currentState,null));

        int i = 1;

        System.out.println((i++) + " - Starting search at " + currentState);
        while (!p.isGoal(currentState)) {

            System.out.println((i++) + " - " + currentState + " is not a goal");
            Action[] availableActions = p.actions(currentState);
            boolean modified = false;
            for (Action acc : availableActions) {
                State sc = p.result(currentState, acc);
                System.out.println((i++) + " - RESULT(" + currentState + "," + acc + ")=" + sc);
                if (!explored.contains(sc)) {
                    nodes.add(new Node(sc, currentState));
                    currentState = sc;
                    System.out.println((i++) + " - " + sc + " NOT explored");
                    explored.add(currentState);
                    modified = true;
                    System.out.println((i++) + " - Current state changed to " + currentState);
                    break;
                } else
                    System.out.println((i++) + " - " + sc + " already explored");
            }
            if(!modified){
                currentState = nodes.getLast().getParent();
            }
        }
        System.out.println((i++) + " - END - " + currentState);

        ArrayList<Node> solution = reconstruct_sol(nodes);
        return solution;
    }
}
