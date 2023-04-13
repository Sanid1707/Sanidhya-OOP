package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.MySqlUserDao;
import com.dkit.oop.sd2.DAOs.UserDaoInterface;
import com.dkit.oop.sd2.DTOs.User;
import com.dkit.oop.sd2.Exceptions.DaoException;

import java.util.List;

public class FindAllPlayer

{
    UserDaoInterface IUserDao = new MySqlUserDao();  //"IUserDao" -> "I" stands for for
      public void findAllUsers() throws DaoException
      {
          try {
              System.out.println("\nCall findAllUsers()");
              List<User> users = IUserDao.findAllUsers();     // call a method in the DAO

              if (users.isEmpty())
                  System.out.println("There are no Users");
              else {
                  for (User user : users)
                      System.out.println("Player: " + user.toString());
              }

          } catch (DaoException e) {
              throw new RuntimeException(e);
          }
      }

}
