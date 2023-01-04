package com.epam.buber.dao;

import com.epam.buber.exception.DaoException;

public interface UserDao {
    boolean authenticate(String login, String password) throws DaoException;
}
