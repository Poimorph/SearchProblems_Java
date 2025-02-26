package es.udc.intelligentsystems.example;

import es.udc.intelligentsystems.*;



public class Node {
    private State state;
    private State parentState;


    public Node(State state, State parentState) {
        this.state=state;
        this.parentState = parentState;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public State getParent(){
        return parentState;
    }

    public void setParent(State parentState){
        this.parentState = parentState;
    }

}
