package com.trtjk.cons.states.v3.constant;

import com.trtjk.cons.states.v3.interfaces.AlarmEvent;
import com.trtjk.cons.states.v3.interfaces.CloseEvent;
import com.trtjk.cons.states.v3.interfaces.OpenEvent;
import com.trtjk.cons.states.v3.interfaces.RefundEvent;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Data
public class EntranceMachine {

    List<EntranceMachineTransaction> entranceMachineTransactionList = Arrays.asList(
            EntranceMachineTransaction.builder()
                    .currentState(EntranceMachineState.LOCKED)
                    .action(Action.INSERT_COIN)
                    .nextState(EntranceMachineState.UNLOCKED)
                    .event(new OpenEvent())
                    .build(),
            EntranceMachineTransaction.builder()
                    .currentState(EntranceMachineState.LOCKED)
                    .action(Action.PASS)
                    .nextState(EntranceMachineState.LOCKED)
                    .event(new AlarmEvent())
                    .build(),
            EntranceMachineTransaction.builder()
                    .currentState(EntranceMachineState.UNLOCKED)
                    .action(Action.PASS)
                    .nextState(EntranceMachineState.LOCKED)
                    .event(new CloseEvent())
                    .build(),
            EntranceMachineTransaction.builder()
                    .currentState(EntranceMachineState.UNLOCKED)
                    .action(Action.INSERT_COIN)
                    .nextState(EntranceMachineState.UNLOCKED)
                    .event(new RefundEvent())
                    .build()
    );

    private EntranceMachineState state;

    public EntranceMachine(EntranceMachineState state) {
        setState(state);
    }

    public String execute(Action action) {
        Optional<EntranceMachineTransaction> transactionOptional = entranceMachineTransactionList
                .stream()
                .filter(transaction ->
                        transaction.getAction().equals(action) && transaction.getCurrentState().equals(state))
                .findFirst();

        if (!transactionOptional.isPresent()) {
            throw new RuntimeException();
        }

        EntranceMachineTransaction transaction = transactionOptional.get();
        setState(transaction.getNextState());
        return transaction.getEvent().execute();
    }
}