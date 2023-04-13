package com.dkit.oop.sd2.services;


import com.dkit.oop.sd2.DAOs.MySqlUserDao;
import com.dkit.oop.sd2.DAOs.UserDaoInterface;
import com.dkit.oop.sd2.DTOs.User;
import com.dkit.oop.sd2.Exceptions.DaoException;

import java.util.Scanner;

public class FindById
{
    public void findUserById()
    {
        UserDaoInterface IUserDao = new MySqlUserDao();
        // Find a User by ID
        try {
            System.out.println("\nCall findUserById()");
            System.out.println("Enter ID: ");
            Scanner keyboard = new Scanner(System.in);
            int userId = keyboard.nextInt();  // read user input
            User user = IUserDao.findUserById(userId);     // call a method in the DAO with the user input as argument

            if (user == null)
                System.out.println("There is no User with that ID");
            else {
                System.out.println("Player: " + user.toString());
            }

        } catch (DaoException e) {
            throw new RuntimeException(e);
        }

    }
}
