package com.trtjk.cons.states.v2.constants;

import com.trtjk.cons.states.v2.interfaces.EntranceMachineState;

public class UnlockedEntranceMachineState implements EntranceMachineState {

    @Override
    public String insertCoin(EntranceMachine entranceMachine) {
        return entranceMachine.refund();
    }

    @Override
    public String pass(EntranceMachine entranceMachine) {
        return entranceMachine.close();
    }
}