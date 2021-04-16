package com.trtjk.cons.states.v3.interfaces;

public class CloseEvent implements Event {
    @Override
    public String execute() {
        return "closed";
    }
}