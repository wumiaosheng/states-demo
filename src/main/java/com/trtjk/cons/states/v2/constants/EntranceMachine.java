package com.trtjk.cons.states.v2.constants;

import com.trtjk.cons.states.v2.interfaces.EntranceMachineState;

import java.util.Objects;

public class EntranceMachine {

    private EntranceMachineState state;

    public EntranceMachine(EntranceMachineState state) {
        this.state = state;
    }

    public String execute(Action action) {
        if (Objects.isNull(action)) {
            throw new RuntimeException();
        }

        if (Action.PASS.equals(action)) {
            return state.pass(this);
        }

        return state.insertCoin(this);
    }

    private void setState(EntranceMachineState state) {
        this.state = state;
    }
}