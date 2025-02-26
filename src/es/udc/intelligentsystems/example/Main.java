package es.udc.intelligentsystems.example;

import es.udc.intelligentsystems.SearchStrategy;
import es.udc.intelligentsystems.SearchProblem;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        VacuumCleanerProblem.VacuumCleanerState initialState = new VacuumCleanerProblem.VacuumCleanerState(VacuumCleanerProblem.VacuumCleanerState.RobotPosition.LEFT,
                                                                                                    VacuumCleanerProblem.VacuumCleanerState.DirtPosition.BOTH);
        SearchProblem aspiradora = new VacuumCleanerProblem(initialState);

        SearchStrategy buscador = new GraphSearchStrategy();
        ArrayList<Node> sol=buscador.solve(aspiradora);
        System.out.print("Solution : [");
        int n = sol.size();
        for (int i = n-1; i >=0; i--) {
            System.out.print(sol.get(i).getState().toString()+" ");
        }
        System.out.println("\b]");
    }
}
