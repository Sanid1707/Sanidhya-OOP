package com.dkit.oop.sd2.DAOs;

/**
 * OOP Feb 2022
 * UserDaoInterface
 * <p>
 * Declares the methods that all UserDAO types must implement,
 * be they MySql User DAOs or Oracle User DAOs etc...
 * <p>
 * Classes from the Business Layer (users of this DAO interface)
 * should use reference variables of this interface type to avoid
 * dependencies on the underlying concrete classes (e.g. MySqlUserDao).
 * <p>
 * More sophisticated implementations will use a factory
 * method to instantiate the appropriate DAO concrete classes
 * by reading database configuration information from a
 * configuration file (that can be changed without altering source code)
 * <p>
 * Interfaces are also useful when testing, as concrete classes
 * can be replaced by mock DAO objects.
 */

import com.dkit.oop.sd2.DTOs.Player;
import com.dkit.oop.sd2.Exceptions.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface PlayerDaoInterface {
    List<Player> findAllUsers() throws DaoException;

    Player findUserById(int id) throws DaoException;

    void deleteByID(int id) throws SQLException;

    void insertPlayer(Player player) throws SQLException;


//    public User findUserByUsernamePassword(String username, String password) throws DaoException;

}

