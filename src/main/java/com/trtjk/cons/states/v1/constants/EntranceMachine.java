package com.trtjk.cons.states.v1.constants;

import lombok.Data;

import java.util.Objects;

@Data
public class EntranceMachine {

    private MachineState state;

    public EntranceMachine(MachineState state) {
        this.state = state;
    }

    public String execute(Action action) {
        if (Objects.isNull(action)) {
            throw new RuntimeException();
        }

        if (MachineState.LOCKED.equals(state)) {
            switch (action) {
                case INSERT_COIN:
                    setState(MachineState.UNLOCKED);
                    return open();
                case PASS:
                    return alarm();
            }
        }

        if (MachineState.UNLOCKED.equals(state)) {
            switch (action) {
                case PASS:
                    setState(MachineState.LOCKED);
                    return close();
                case INSERT_COIN:
                    return refund();
            }
        }
        return null;
    }

    private String refund() {
        return "refund";
    }

    private String close() {
        return "closed";
    }

    private String alarm() {
        return "alarm";
    }

    private String open() {
        return "opened";
    }
}