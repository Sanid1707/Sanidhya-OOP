package com.dkit.oop.sd2.DAOs;

import com.dkit.oop.sd2.DTOs.Club;
import com.dkit.oop.sd2.DTOs.User;
import com.dkit.oop.sd2.Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClubDAO extends MySqlDao implements ClubInterface
{

    @Override
    public List<Club> findAllClubs() throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Club> clubList = new ArrayList<>();

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM clubs";
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                int userId = resultSet.getInt("Club_id");
                String name = resultSet.getString("name");
                String jerseyColour = resultSet.getString("jersey_colour");
                Club c= new Club(userId, name, jerseyColour);
                clubList.add(c);




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
        return clubList;   // may be empty
    }

    @Override
    public Club findClubById(int userId) throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Club club = null;

        try {
            // Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM player WHERE id = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, userId);

            // Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("club_id");
                String jerseyColour = resultSet.getString("jersey_colour");
                Club c= new Club(userId, name, jerseyColour);

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
        return club;
    }

    @Override
    public void deleteClubByID(int id) throws SQLException {
        Connection connection = this.getConnection();
        String SQL = "DELETE FROM clubs WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(SQL);
        ps.setInt(1, id);
        ps.executeUpdate();

    }

    @Override
    public void insertClubPlayer(User player) throws SQLException {
        Connection connection = this.getConnection();
        String SQL = "INSERT INTO player (id, first_name, last_name, position, nationality, salary, age) VALUES (?, ?, ?, ?, ?, ?, ?)";
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



}

