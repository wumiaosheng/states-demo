package com.trtjk.cons.states.v4.constants;

import lombok.Data;

import java.util.Objects;

@Data
public class EntranceMachine {

    private EntranceMachineState state;

    public EntranceMachine(EntranceMachineState state) {
        setState(state);
    }

    public String execute(Action action) {
        if (Objects.isNull(action)) {
            throw new RuntimeException();
        }

        return action.execute(this, state);
    }

    public String open() {
        return "opened";
    }

    public String alarm() {
        return "alarm";
    }

    public String refund() {
        return "refund";
    }

    public String close() {
        return "closed";
    }
}