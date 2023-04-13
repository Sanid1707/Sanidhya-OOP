package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.MySqlUserDao;
import com.dkit.oop.sd2.DAOs.UserDaoInterface;
import com.dkit.oop.sd2.Exceptions.DaoException;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteById {
    public  void deleteById()
    {
        UserDaoInterface iUserDao = new MySqlUserDao();
        try {
            System.out.println("\nCall deleteByID()");
            System.out.println("Enter ID to delete: ");
            Scanner keyboard = new Scanner(System.in);
            int userId = keyboard.nextInt();
            iUserDao.deleteByID(userId);
            System.out.println("User with ID " + userId + " is deleted successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
