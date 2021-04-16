package com.trtjk.cons.states.v3.interfaces;

public class OpenEvent implements Event {
    @Override
    public String execute() {
        return "opened";
    }
}