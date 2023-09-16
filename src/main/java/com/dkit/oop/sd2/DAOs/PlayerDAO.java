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


import com.dkit.oop.sd2.DTOs.Player;
import com.dkit.oop.sd2.Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class PlayerDAO extends MySqlDao implements PlayerDaoInterface
{

    List<Player> usersList = new ArrayList<>();
    HashMap< Integer, Player> playerMap = new HashMap<Integer, Player>(); //Cache implemented, feature 6

    @Override
    public List<Player> findAllUsers() throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Player> usersList = new ArrayList<>();

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM players";
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
                int clubId = resultSet.getInt("club_id");
                Player u = new Player(userId, firstname, lastname, position, nationality, salary, age, clubId);
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
    public Player findUserById(int userId) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Player player = null;

        if(playerMap.containsKey(userId)){
            System.out.println("From cache");
            return playerMap.get(userId);
        }
        else {
            try {
                // Get connection object using the methods in the super class (MySqlDao.java)...
                connection = this.getConnection();

                String query = "SELECT * FROM players WHERE id = ?";
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
                    int clubId = resultSet.getInt("club_id");
                    player = new Player(userId, firstname, lastname, position, nationality, salary, age, clubId);
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
            playerMap.put(userId, player);
            return player;   // may be null

        }


    }

    @Override
    public void deleteByID(int id) throws SQLException {
        Connection connection = this.getConnection();
        String SQL = "DELETE FROM players WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(SQL);
        ps.setInt(1, id);
        ps.executeUpdate();

    }

    @Override
    public void insertPlayer(Player player) throws SQLException {
        Connection connection = this.getConnection();
        String SQL = "INSERT INTO players (id, first_name, last_name, position, nationality, salary, age) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(SQL);
        ps.setInt(1, player.getId());
        ps.setString(2, player.getFirstName());
        ps.setString(3, player.getLastName());
        ps.setString(4, player.getPosition());
        ps.setString(5, player.getNationality());
        ps.setInt(6, player.getSalary());
        ps.setInt(7, player.getAge());
        ps.executeUpdate();


    }
//    public Player findPlayerByFirstName(String firstName) throws DaoException {
//        Connection connection = null;
//        PreparedStatement ps = null;
//        ResultSet resultSet = null;
//        Player player = null;
//
//        if (playerMap.containsKey(firstName)) {
//            System.out.println("From cache");
//            return playerMap.get(firstName);
//        } else {
//            try {
//                // Get connection object using the methods in the super class (MySqlDao.java)...
//                connection = this.getConnection();
//
//                String query = "SELECT * FROM players WHERE first_name = ?";
//                ps = connection.prepareStatement(query);
//                ps.setString(1, firstName);
//
//                // Using a PreparedStatement to execute SQL...
//                resultSet = ps.executeQuery();
//                if (resultSet.next()) {
//                    String lastName = resultSet.getString("last_name");
//                    String position = resultSet.getString("position");
//                    String nationality = resultSet.getString("nationality");
//                    int age = resultSet.getInt("age");
//                    int salary = resultSet.getInt("salary");
//                    int userId = resultSet.getInt("id");
//                    int clubId = resultSet.getInt("club_id");
//                    player = new Player(userId, firstName, lastName, position, nationality, salary, age, clubId);
//                }
//            } catch (SQLException e) {
//                throw new DaoException("findPlayerByFirstName() " + e.getMessage());
//            } finally {
//                try {
//                    if (resultSet != null) {
//                        resultSet.close();
//                    }
//                    if (ps != null) {
//                        ps.close();
//                    }
//                    if (connection != null) {
//                        freeConnection(connection);
//                    }
//                } catch (SQLException e) {
//                    throw new DaoException("findPlayerByFirstName() " + e.getMessage());
//                }
//            }
//            if (player != null) {
//                playerMap.put(firstName, player);
//            }
//            return player; // may be null
//        }
//    }



}

