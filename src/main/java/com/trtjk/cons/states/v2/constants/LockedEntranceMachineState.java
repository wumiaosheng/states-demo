package com.trtjk.cons.states.v2.constants;

import com.trtjk.cons.states.v2.interfaces.EntranceMachineState;

public class LockedEntranceMachineState implements EntranceMachineState {

    @Override
    public String insertCoin(EntranceMachine entranceMachine) {
        return entranceMachine.open();
    }

    @Override
    public String pass(EntranceMachine entranceMachine) {
        return entranceMachine.alarm();
    }
}