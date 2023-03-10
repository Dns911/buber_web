package com.epam.buber.command.impl;

import com.epam.buber.controller.RequestParameterName;
import com.epam.buber.exception.CommandException;
import com.epam.buber.exception.ServiceException;
import com.epam.buber.service.UserService;
import com.epam.buber.service.impl.UserServiceImpl;
import com.epam.buber.command.Command;
import com.epam.buber.controller.PagePath;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter(RequestParameterName.LOGIN);
        String password = request.getParameter(RequestParameterName.PASSWORD);
        UserService userService = UserServiceImpl.getInstance();
        HttpSession session = request.getSession();
        String page;
        try {
            if (userService.authenticate(login, password)) {
                request.setAttribute(RequestParameterName.USER, login);
                session.setAttribute(RequestParameterName.USER_LOGIN, login);
                page = PagePath.MAIN;
            } else {
                request.setAttribute(RequestParameterName.LOGIN_MSG, "Incorrect login or password");
                page = PagePath.INDEX;
            }
            session.setAttribute(RequestParameterName.CURRENT_PAGE, page);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return page;
    }
}
