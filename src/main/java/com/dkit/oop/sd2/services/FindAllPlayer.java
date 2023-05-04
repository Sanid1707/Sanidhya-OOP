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
                  for (Player player : players)
                      System.out.println("Player: " + player.toString());
              }

          } catch (DaoException e) {
              throw new RuntimeException(e);
          }
      }

}
