package com.trtjk.cons.states.v2.interfaces;

import com.trtjk.cons.states.v2.constants.EntranceMachine;

public interface EntranceMachineState {

    String insertCoin(EntranceMachine entranceMachine);

    String pass(EntranceMachine entranceMachine);
}