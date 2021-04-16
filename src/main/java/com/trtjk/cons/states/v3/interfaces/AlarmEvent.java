package com.trtjk.cons.states.v3.interfaces;

public class AlarmEvent implements Event {
    @Override
    public String execute() {
        return "alarm";
    }
}