//package com.dkit.oop.sd2.services;
//
//import com.dkit.oop.sd2.DAOs.ClubDAO;
//import com.dkit.oop.sd2.DAOs.ClubInterface;
//import com.dkit.oop.sd2.DTOs.Club;
//import com.dkit.oop.sd2.Exceptions.DaoException;
//
//import java.util.Scanner;
//
//public class FindClubById {
//   public void findClubById() {
//      ClubInterface clubDAO = new ClubDAO();
//        // Find a Club by ID
//        try {
//            System.out.println("\nCall findClubById()");
//            System.out.println("Enter ID: ");
//            Scanner keyboard = new Scanner(System.in);
//            int clubId = keyboard.nextInt();  // read user input
//            Club club = clubDAO.findClubById(clubId);     // call a method in the DAO with the user input as argument
//
//            if (club == null)
//                System.out.println("There is no Club with that ID");
//            else {
//                System.out.println("Club: " + club.toString());
//            }
//
//        } catch (DaoException e) {
//            throw new RuntimeException(e);
//        }
//
//
//
//
//   }
//}

package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.ClubDAO;
import com.dkit.oop.sd2.DAOs.ClubInterface;
import com.dkit.oop.sd2.DTOs.Club;
import com.dkit.oop.sd2.Exceptions.DaoException;

import java.util.Scanner;

public class FindClubById {
    ClubInterface clubDAO = new ClubDAO();

    public void findClubById() {
        // Find a Club by ID
        try {
            System.out.println("\nCall findClubById()");
            System.out.print("Enter ID of the club: ");
            Scanner keyboard = new Scanner(System.in);
            int clubId = keyboard.nextInt();  // read user input
            Club club = clubDAO.findClubById(clubId);     // call a method in the DAO with the user input as an argument

            if (club == null)
                System.out.println("There is no Club with that ID");
            else {
                // Print table header with dashes only after the heading
                System.out.format("%-6s | %-20s | %-15s%n",
                        "ID", "Club Name", "Jersey Colour");
                System.out.println("------------------------------------------");

                // Print the club's information
                System.out.format("%-6d | %-20s | %-15s%n",
                        club.getClubId(), club.getClubName(), club.getJerseyColour());
            }

        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
}
