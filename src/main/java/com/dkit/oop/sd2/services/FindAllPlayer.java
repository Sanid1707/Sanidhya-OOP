package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.PlayerDAO;
import com.dkit.oop.sd2.DAOs.PlayerDaoInterface;
import com.dkit.oop.sd2.DTOs.Player;
import com.dkit.oop.sd2.Exceptions.DaoException;

import java.util.List;

public class FindAllPlayer

{
    PlayerDaoInterface playerDAO = new PlayerDAO();
   //"IUserDao" -> "I" stands for for
      public void findAllUsers() throws DaoException
      {
          try {
              System.out.println("\nCall findAllUsers()");
              List<Player> players = playerDAO.findAllUsers();     // call a method in the DAO

              if (players.isEmpty())
                  System.out.println("There are no Users");
              else {
//

                  // Print table header
                  System.out.format("%-4s%-15s%-15s%-15s%-15s%-10s%-5s%-6s%n",
                          "ID", "First Name", "Last Name", "Position", "Nationality", "Salary", "Age", "Club ID");
                  System.out.println("-------------------------------------------------------------------------------------");

                  // Print each player's information
                  for (Player player : players)
                  {
                      System.out.format("%-4d%-15s%-15s%-15s%-15s%-10d%-5d%-6d%n",
                              player.getId(), player.getFirstName(), player.getLastName(),
                              player.getPosition(), player.getNationality(), player.getSalary(),
                              player.getAge(), player.getClubId());
                  }
              }

          } catch (DaoException e) {
              throw new RuntimeException(e);
          }
      }

}

