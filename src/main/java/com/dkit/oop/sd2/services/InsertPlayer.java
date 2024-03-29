package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.PlayerDAO;
import com.dkit.oop.sd2.DAOs.PlayerDaoInterface;
import com.dkit.oop.sd2.DTOs.Player;

import java.sql.SQLException;

public class InsertPlayer
{
    public void insertPlayer()
    {
        PlayerDaoInterface IUserDao = new PlayerDAO();
        // create an instance of the class that contains the insert method
        PlayerDAO userDao = new PlayerDAO();

// create a User object with the values to be inserted
        Player player = new Player(2, "armando ", "brosa", "defense", "spain", 50000, 28, 1);

        try {
            // call the insert method with the User object as parameter
            userDao.insertPlayer(player);
            System.out.println("User inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting user: " + e.getMessage());
        }



    }
}
