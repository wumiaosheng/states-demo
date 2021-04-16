package com.trtjk.cons.states.v3.constant;

import com.trtjk.cons.states.v3.interfaces.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntranceMachineTransaction {

    private EntranceMachineState currentState;

    private Action action;

    private EntranceMachineState nextState;

    private Event event;
}