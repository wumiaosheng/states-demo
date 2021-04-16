package com.trtjk.cons.states.v4;

import com.trtjk.cons.states.v4.constants.Action;
import com.trtjk.cons.states.v4.constants.EntranceMachine;
import com.trtjk.cons.states.v4.constants.EntranceMachineState;
import org.junit.Test;

class EntranceMachineTest {

    @Test
    void should_unlocked_when_insert_coin_given_a_entrance_machine_with_locked_state() {
        EntranceMachine entranceMachine = new EntranceMachine(EntranceMachineState.LOCKED);
        String result = entranceMachine.execute(Action.INSERT_COIN);
    }

    @Test
    void should_alarm_when_pass_given_a_entrance_machine_with_locked_state() {
        EntranceMachine entranceMachine = new EntranceMachine(EntranceMachineState.LOCKED);
        String result = entranceMachine.execute(Action.PASS);

    }

    @Test
    void should_fail_when_execute_invalid_action_given_a_entrance_machine() {
        EntranceMachine entranceMachine = new EntranceMachine(EntranceMachineState.LOCKED);
    }

    @Test
    void should_refund_when_insert_coin_given_a_entrance_machine_with_unlocked_state() {
        EntranceMachine entranceMachine = new EntranceMachine(EntranceMachineState.UNLOCKED);
        String result = entranceMachine.execute(Action.INSERT_COIN);
    }

    @Test
    void should_closed_when_pass_given_a_entrance_machine_with_unlocked_state() {
        EntranceMachine entranceMachine = new EntranceMachine(EntranceMachineState.UNLOCKED);
        String result = entranceMachine.execute(Action.PASS);
    }

}