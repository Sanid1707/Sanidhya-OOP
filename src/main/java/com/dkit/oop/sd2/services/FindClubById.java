package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.ClubDAO;
import com.dkit.oop.sd2.DAOs.ClubInterface;
import com.dkit.oop.sd2.DTOs.Club;
import com.dkit.oop.sd2.Exceptions.DaoException;

import java.util.Scanner;

public class FindClubById {
   public void findClubById() {
      ClubInterface IUserDao = new ClubDAO();
        // Find a Club by ID
        try {
            System.out.println("\nCall findClubById()");
            System.out.println("Enter ID: ");
            Scanner keyboard = new Scanner(System.in);
            int userId = keyboard.nextInt();  // read user input
            Club club = IUserDao.findClubById(userId);     // call a method in the DAO with the user input as argument

            if (club == null)
                System.out.println("There is no Club with that ID");
            else {
                System.out.println("Club: " + club.toString());
            }

        } catch (DaoException e) {
            throw new RuntimeException(e);
        }




   }
}