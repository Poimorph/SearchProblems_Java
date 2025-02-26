package es.udc.intelligentsystems.MagicSquare;

import es.udc.intelligentsystems.*;


import java.util.ArrayList;

public class MagicSquareProblem extends SearchProblem {


    public static class MagicSquareState extends State {
        public ArrayList<ArrayList<Integer>> magicSquare;

        public MagicSquareState(ArrayList<ArrayList<Integer>> magicSquare) {
            this.magicSquare=magicSquare;
        }
        public ArrayList<ArrayList<Integer>> getState() {
            return this.magicSquare;
        }
        public void setState(ArrayList<ArrayList<Integer>> state) {
            this.magicSquare = state;
        }
        @Override
        public String toString() {
            String stateString = "[ ";
            for(int i=0; i<magicSquare.size(); i++) {
                stateString += "[ ";
                for(int j=0; j<magicSquare.get(i).size(); j++) {
                    stateString += magicSquare.get(i).get(j)+", ";
                }
                stateString += "]";
            }
            stateString += " ]";
            return stateString;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MagicSquareState that = (MagicSquareState) o;

            for (int i=0; i<magicSquare.size(); i++) {
                for (int j=0; j<magicSquare.get(i).size(); j++) {
                    if (!(this.getState().get(i).get(j).equals(that.getState().get(i).get(j)))) return false;
                }
            }
            return true;
        }
        public int getSize(){
            return magicSquare.size();
        }
        @Override
        public int hashCode() {
            return magicSquare.hashCode();
        }
    }

    @Override
    public boolean isGoal(State st) {
        System.out.println(st.toString());
        return false;
    }

    public static class MagicSquareActions extends Action{

    }


    public MagicSquareProblem() {


    }

}
