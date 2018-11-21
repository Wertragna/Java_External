package com.Homework_15_11_18.Controller;

public class MenuProductController {
    private static final int NUMBER_OF_COMANTS = 8;
    private ActionCommand[] commands;

    public MenuProductController() {
        commands = new ActionCommand[NUMBER_OF_COMANTS];
        ActionCommand noCommand = new NoActionCommant();
        for (int i = 0; i < NUMBER_OF_COMANTS; ++i) {
            commands[i] = noCommand;
        }
    }

    public void setCommand(int slot, ActionCommand cmd) {
        commands[slot] = cmd;
    }

    public void menuItemPickedUp(int slot) {
        commands[slot].execute();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("**************Menu*****************\n");
        for (int i = 0; i < commands.length; ++i) {
                sb.append("[button " + i + "] " +commands[i].toString() + '\n');
        }
        return sb.toString();
    }
}

