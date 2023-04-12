package com.dkit.oop.sd2.DAOs;

/** OOP Feb 2022
 *
 * Data Access Object (DAO) for User table with MySQL-specific code
 * This 'concrete' class implements the 'UserDaoInterface'.
 *
 * The DAO will contain the SQL query code to interact with the database,
 * so, the code here is specific to a particular database (e.g. MySQL or Oracle etc...)
 * No SQL queries will be used in the Business logic layer of code, thus, it
 * will be independent of the database specifics.
 *
 * The Business Logic layer is only permitted to access the database by calling
 * methods provided in the Data Access Layer - i.e. by callimng the DAO methods.
 *
 */


import com.dkit.oop.sd2.DTOs.User;
import com.dkit.oop.sd2.Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySqlUserDao extends MySqlDao implements UserDaoInterface
{

    List<User> usersList = new ArrayList<>();

    @Override
    public List<User> findAllUsers() throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<User> usersList = new ArrayList<>();

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM player";
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                int userId = resultSet.getInt("id");
                String position = resultSet.getString("position");
                String nationality = resultSet.getString("nationality");
                int age = resultSet.getInt("age");
                int salary = resultSet.getInt("salary");
                String lastname = resultSet.getString("last_name");
                String firstname = resultSet.getString("first_name");
                User u = new User(userId, firstname, lastname, position, nationality, salary, age);
                usersList.add(u);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllUseresultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllUsers() " + e.getMessage());
            }
        }
        return usersList;   // may be empty
    }

    @Override
    public User findUserById(int userId) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            // Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM player WHERE id = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, userId);

            // Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String position = resultSet.getString("position");
                String nationality = resultSet.getString("nationality");
                int age = resultSet.getInt("age");
                int salary = resultSet.getInt("salary");
                String lastname = resultSet.getString("last_name");
                String firstname = resultSet.getString("first_name");
                user = new User(userId, firstname, lastname, position, nationality, salary, age);
            }
        } catch (SQLException e) {
            throw new DaoException("findUserById() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("findUserById() " + e.getMessage());
            }
        }
        return user;   // may be null
    }

    @Override
    public void deleteByID(int id) throws SQLException {
        Connection connection = this.getConnection();
        String SQL = "DELETE FROM player WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(SQL);
        ps.setInt(1, id);
        ps.executeUpdate();

    }





}

