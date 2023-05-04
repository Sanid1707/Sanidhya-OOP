package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.ClubDAO;
import com.dkit.oop.sd2.DAOs.ClubInterface;
import com.dkit.oop.sd2.DAOs.PlayerDAO;
import com.dkit.oop.sd2.DAOs.PlayerDaoInterface;
import com.dkit.oop.sd2.DTOs.Club;
import com.dkit.oop.sd2.DTOs.Player;
import com.dkit.oop.sd2.Exceptions.DaoException;
import com.google.gson.Gson;

import java.util.Scanner;

public class FindClubByIdJson
{
    public void findClubByIdJson()
    {
        ClubInterface clubDAO = new ClubDAO();

        Gson gson = new Gson();
        // Find a User by ID
        try {
            System.out.println("\nCall findUserById()");
            System.out.println("Enter ID: ");
            Scanner keyboard = new Scanner(System.in);
            int userId = keyboard.nextInt();  // read user input
            Club club = clubDAO.findClubById(userId);     // call a method in the DAO with the user input as argument

            if (club == null)
                System.out.println("There is no User with that ID");
            else {
                System.out.println("Player: " + gson.toJson(club));
            }

        } catch (DaoException e) {
            throw new RuntimeException(e);
        }

    }
}
