package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.MySqlUserDao;
import com.dkit.oop.sd2.DAOs.UserDaoInterface;
import com.dkit.oop.sd2.DTOs.User;

import java.sql.SQLException;

public class InsertPlayer
{
    public void insertPlayer()
    {
        UserDaoInterface IUserDao = new MySqlUserDao();
        // create an instance of the class that contains the insert method
        MySqlUserDao userDao = new MySqlUserDao();

// create a User object with the values to be inserted
        User user = new User(2, "armando ", "brosa", "defense", "spain", 50000, 28);

        try {
            // call the insert method with the User object as parameter
            userDao.insertPlayer(user);
            System.out.println("User inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting user: " + e.getMessage());
        }



    }
}
