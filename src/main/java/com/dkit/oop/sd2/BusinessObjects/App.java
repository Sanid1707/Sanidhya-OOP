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
import java.util.*;



public class App
{
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main( String[] args ) throws DaoException {
        System.out.println("Welcome to Foot ball player - an app to browse for and add your own recipes!");

        boolean exit = false;

        String userInput;

        while(!exit)
        {
            printPlayerMenuInstructions();
            final Scanner keyboard = new Scanner(System.in);
            userInput = keyboard.nextLine().trim();
//            userInput = InputHandler.getAndValidateEnumOptions(Validation.WHOLE_NUMBER_REGEX, MainMenuOptions.values().length, "(0-2)");
            int choice = Integer.parseInt(userInput);

            switch (choice)
            {
                case 0:
                    exit = true;
                    break;
                case 1:
//                    FindAllPlayer findAllPlayer = new FindAllPlayer();
//                    findAllPlayer.findAllUsers();
                    FindAllClubs findAllClubs = new FindAllClubs();
                    findAllClubs.findAllClubs();
                    break;
                case 2:
//                    FindById findById = new FindById();
//                    findById.findUserById();
                    FindClubById findClubById = new FindClubById();
                    findClubById.findClubById();
                    break;

                case 3:
//                    DeleteById deleteById = new DeleteById();
//                    deleteById.deleteById();
                    DeleteClubById deleteClubById = new DeleteClubById();
                    deleteClubById.deleteClubById();
                    break;

                case 4:
                    InsertPlayer insertPlayer = new InsertPlayer();
                    insertPlayer.insertPlayer();
                    break;
                default:
                    System.out.println("Invalid Input. Try again.");
                    break;
            }
        }
    }

    private static void printPlayerMenuInstructions()
    {
        System.out.println("\nPress:");
        System.out.println("0. Exit App");
        System.out.println("1. display all players in the database");
        System.out.println("2. find by id " );
        System.out.println("3. delete " );
        System.out.println("4. add " );
        System.out.println("5. Find all Players as JSON " );
        System.out.println("6. Find Players by id as JSON" );

    }




}

