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
//
//    @Override
//    public User findUserByUsernamePassword(String user_name, String pass_word) throws DaoException
//    {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        User user = null;
//        try
//        {
//            connection = this.getConnection();
//
//            String query = "SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?";
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, user_name);
//            preparedStatement.setString(2, pass_word);
//
//            resultSet = preparedStatement.executeQuery();
//            if (resultSet.next())
//            {
//                int userId = resultSet.getInt("id");
//                String position = resultSet.getString("POSITION");
//                String nationality = resultSet.getString("NATIONALITY");
//                int age = resultSet.getInt("AGE");
//                int salary = resultSet.getInt("SALARY");
//                String lastname = resultSet.getString("LAST_NAME");
//                String firstname = resultSet.getString("FIRST_NAME");
//
//                user = new User(userId,);
//            }
//        } catch (SQLException e)
//        {
//            throw new DaoException("findUserByUsernamePassword() " + e.getMessage());
//        } finally
//        {
//            try
//            {
//                if (resultSet != null)
//                {
//                    resultSet.close();
//                }
//                if (preparedStatement != null)
//                {
//                    preparedStatement.close();
//                }
//                if (connection != null)
//                {
//                    freeConnection(connection);
//                }
//            } catch (SQLException e)
//            {
//                throw new DaoException("findUserByUsernamePassword() " + e.getMessage());
//            }
//        }
//        return user;     // reference to User object, or null value
//    }
}

