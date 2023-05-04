package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.ClubDAO;
import com.dkit.oop.sd2.DAOs.ClubInterface;
import com.dkit.oop.sd2.DAOs.PlayerDAO;
import com.dkit.oop.sd2.DAOs.PlayerDaoInterface;
import com.dkit.oop.sd2.DTOs.Club;
import com.dkit.oop.sd2.DTOs.Player;

import java.sql.SQLException;

public class AddClubs
{
    public void addClub()
    {
        ClubInterface IUserDao = new ClubDAO();
        // create an instance of the class that contains the insert method
        ClubDAO userDao = new ClubDAO();

// create a User object with the values to be inserted
        Club club = new Club(6, "armando ", "brosa");

        try {
            // call the insert method with the User object as parameter
            userDao.insertClubPlayer(club);
            System.out.println("User inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting user: " + e.getMessage());
        }



    }

}
