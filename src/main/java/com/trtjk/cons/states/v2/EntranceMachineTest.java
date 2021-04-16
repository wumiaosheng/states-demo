package com.trtjk.cons.states.v2;

import com.trtjk.cons.states.v2.constants.Action;
import com.trtjk.cons.states.v2.constants.EntranceMachine;
import com.trtjk.cons.states.v2.constants.LockedEntranceMachineState;
import com.trtjk.cons.states.v2.constants.UnlockedEntranceMachineState;
import org.junit.Test;

class EntranceMachineTest {

    @Test
    void should_be_unlocked_when_insert_coin_given_a_entrance_machine_with_locked_state() {
        EntranceMachine entranceMachine = new EntranceMachine(new LockedEntranceMachineState());

        String result = entranceMachine.execute(Action.INSERT_COIN);

        then(result).isEqualTo("opened");
        then(entranceMachine.isUnlocked()).isTrue();
    }

    @Test
    void should_be_locked_and_alarm_when_pass_given_a_entrance_machine_with_locked_state() {
        EntranceMachine entranceMachine = new EntranceMachine(new LockedEntranceMachineState());

        String result = entranceMachine.execute(Action.PASS);

        then(result).isEqualTo("alarm");
        then(entranceMachine.isLocked()).isTrue();
    }

    @Test
    void should_fail_when_execute_invalid_action_given_a_entrance_with_locked_state() {
        EntranceMachine entranceMachine = new EntranceMachine(new LockedEntranceMachineState());

        assertThatThrownBy(() -> entranceMachine.execute(null))
                .isInstanceOf(InvalidActionException.class);
    }

    @Test
    void should_locked_when_pass_given_a_entrance_machine_with_unlocked_state() {
        EntranceMachine entranceMachine = new EntranceMachine(new UnlockedEntranceMachineState());

        String result = entranceMachine.execute(Action.PASS);

        then(result).isEqualTo("closed");
        then(entranceMachine.isLocked()).isTrue();
    }

    @Test
    void should_refund_and_unlocked_when_insert_coin_given_a_entrance_machine_with_unlocked_state() {
        EntranceMachine entranceMachine = new EntranceMachine(new UnlockedEntranceMachineState());

        String result = entranceMachine.execute(Action.INSERT_COIN);

        then(result).isEqualTo("refund");
        then(entranceMachine.isUnlocked()).isTrue();
    }
}