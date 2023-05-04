package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.PlayerDAO;
import com.dkit.oop.sd2.DAOs.PlayerDaoInterface;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteById {
    public  void deleteById()
    {
        PlayerDaoInterface iUserDao = new PlayerDAO();
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
