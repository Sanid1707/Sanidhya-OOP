package com.dkit.oop.sd2.BusinessObjects;

/** OOP Feb 2022
 * This App demonstrates the use of a Data Access Object (DAO)
 * to separate Business logic from Database specific logic.
 * It uses Data Access Objects (DAOs),
 * Data Transfer Objects (DTOs), and  a DAO Interface to define
 * a contract between Business Objects and DAOs.
 *
 * "Use a Data Access Object (DAO) to abstract and encapsulate all
 * access to the data source. The DAO manages the connection with
 * the data source to obtain and store data" Ref: oracle.com
 *
 * Here, we use one DAO per database table.
 *
 * Use the SQL script "CreateUsers.sql" included with this project
 * to create the required MySQL user_database and User table.
 */

import com.dkit.oop.sd2.DAOs.MySqlUserDao;
import com.dkit.oop.sd2.DAOs.UserDaoInterface;
import com.dkit.oop.sd2.DTOs.User;
import com.dkit.oop.sd2.Exceptions.DaoException;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.dkit.oop.sd2.services.*;





public class App {
    public static void main(String[] args) throws DaoException {
//        App app = new App();
      FindAllPlayer findAllPlayer = new FindAllPlayer();
      findAllPlayer.findAllUsers();



//
//

//        try {
//            System.out.println("\nCall deleteByID()");
//            System.out.println("Enter ID to delete: ");
//            Scanner keyboard = new Scanner(System.in);
//            int userId = keyboard.nextInt();
//            IUserDao.deleteByID(userId);
//            System.out.println("User with ID " + userId + " deleted successfully.");
//
//        } catch (DaoException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


    }
}
