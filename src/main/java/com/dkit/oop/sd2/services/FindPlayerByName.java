//package com.dkit.oop.sd2.services;
//import com.dkit.oop.sd2.DAOs.PlayerDAO;
//import com.dkit.oop.sd2.DAOs.PlayerDaoInterface;
//import com.dkit.oop.sd2.DTOs.Player;
//import com.dkit.oop.sd2.Exceptions.DaoException;
//import com.google.gson.Gson;
//
//import com.dkit.oop.sd2.DAOs.PlayerDAO;
//
//import java.util.Scanner;
//
//public class FindPlayerByName
//{
//    public void findPlayerByFirstName()
//    {
//            PlayerDaoInterface IUserDao = new PlayerDAO();
//
//        try {
//
//            System.out.println("Enter First NAme of the player: ");
//            Scanner keyboard = new Scanner(System.in);
//            int userId = keyboard.nextInt();  // read user input
//            Player player = IUserDao.findUserById(userId);     // call a method in the DAO with the user input as argument
//
//            if (player == null)
//                System.out.println("There is no Player with that ID");
//            else {
//                // Print table header with dashes only after the heading
//                System.out.format("%-4s | %-15s | %-15s | %-15s | %-15s | %-10s | %-5s | %-6s%n",
//                        "ID", "First Name", "Last Name", "Position", "Nationality", "Salary", "Age", "Club ID");
//                System.out.println("---------------------------------------------------------------------------------------------------------------------");
//
//                // Print the player's information
//                System.out.format("%-4d | %-15s | %-15s | %-15s | %-15s | %-10d | %-5d | %-6d%n",
//                        player.getId(), player.getFirstName(), player.getLastName(),
//                        player.getPosition(), player.getNationality(), player.getSalary(),
//                        player.getAge(), player.getClubId());
//            }
//
//        } catch (DaoException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//
//
//}
//


package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.PlayerDAO;
import com.dkit.oop.sd2.DAOs.PlayerDaoInterface;
import com.dkit.oop.sd2.DTOs.Player;
import com.dkit.oop.sd2.Exceptions.DaoException;

import java.sql.SQLException;
import java.util.Scanner;

public class FindPlayerByName {
//    public void findPlayerByFirstName() {
//        PlayerDaoInterface playerDAO = new PlayerDAO();
//
//        // Find a Player by First Name
//        try {
//            System.out.println("Enter the First Name of the player: ");
//            Scanner keyboard = new Scanner(System.in);
//            String firstName = keyboard.nextLine();  // read user input
//            Player player = playerDAO.findPlayerByFirstName(firstName);
//
//            if (player == null) {
//                System.out.println("There is no Player with that First Name");
//            } else {
//                // Print table header with dashes only after the heading
//                System.out.format("%-4s | %-15s | %-15s | %-15s | %-15s | %-10s | %-5s | %-6s%n",
//                        "ID", "First Name", "Last Name", "Position", "Nationality", "Salary", "Age", "Club ID");
//                System.out.println("---------------------------------------------------------------------------------------------------------------------");
//
//                // Print the player's information
//                System.out.format("%-4d | %-15s | %-15s | %-15s | %-15s | %-10d | %-5d | %-6d%n",
//                        player.getId(), player.getFirstName(), player.getLastName(),
//                        player.getPosition(), player.getNationality(), player.getSalary(),
//                        player.getAge(), player.getClubId());
//            }
//        } catch (DaoException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
