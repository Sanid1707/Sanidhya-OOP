package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.ClubDAO;
import com.dkit.oop.sd2.DAOs.ClubInterface;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteClubById {
    public void deleteClubById()
    { ClubInterface IUserDao = new ClubDAO();
        // delete a club by id
        try {
            System.out.println("\nCall deleteClubById()");
            System.out.println("Enter ID to delete: ");
            Scanner keyboard = new Scanner(System.in);
            int userId = keyboard.nextInt();
            IUserDao.deleteClubByID(userId);
            System.out.println("Club with ID " + userId + " is deleted successfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
