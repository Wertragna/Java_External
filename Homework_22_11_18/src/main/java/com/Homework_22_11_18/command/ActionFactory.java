package com.Homework_22_11_18.command;

import com.Homework_22_11_18.Managers.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) { // если команда не задана в текущем запросе
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return current;

    }
    public ActionCommand defineCommand(HttpServletRequest request, String command) {
        ActionCommand current = new EmptyCommand();
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(command.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", command + MessageManager.getProperty("message.wrongaction"));
        }
        return current;

    }
}
