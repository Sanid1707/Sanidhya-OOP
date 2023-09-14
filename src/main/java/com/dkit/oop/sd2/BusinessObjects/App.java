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

import com.dkit.oop.sd2.DTOs.Club;
import com.dkit.oop.sd2.DTOs.Player;
import com.dkit.oop.sd2.Exceptions.DaoException;

import java.util.Scanner;
import com.dkit.oop.sd2.services.*;


public class App
{
    private static final Scanner keyboard = new Scanner(System.in);

    public static <FindAllPlayerAsJson> void main(String[] args ) throws DaoException {

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
                    FindAllPlayer findAllPlayer = new FindAllPlayer();
                    findAllPlayer.findAllUsers();
//                    FindAllClubs findAllClubs = new FindAllClubs();
//                    findAllClubs.findAllClubs();
                    break;
                case 2:
                    FindById findById = new FindById();
                    findById.findUserById();
//                    FindClubById findClubById = new FindClubById();
//                    findClubById.findClubById();
                    break;

                case 3:
                    DeleteById deleteById = new DeleteById();
                    deleteById.deleteById();
//                    DeleteClubById deleteClubById = new DeleteClubById();
//                    deleteClubById.deleteClubById();
                    break;

                case 4:
                    InsertPlayer insertPlayer = new InsertPlayer();
                    insertPlayer.insertPlayer();
                    break;

                case 5:
                    FindPlayerByJson findPlayerByJson = new FindPlayerByJson();
                    findPlayerByJson.findAllPlayerJson();
                    break;

                case 6:
                    FindPlayerByIdJson findPlayerByIdJson = new FindPlayerByIdJson();
                    findPlayerByIdJson.findPlayerByIdJson();
                    break;
                default:
                    System.out.println("Invalid Input. Try again.");
                    break;

                case 7:
                    FindAllClubs findAllClubs = new FindAllClubs();
                    findAllClubs.findAllClubs();
                    break;
                case 8:
                    FindClubById findClubById = new FindClubById();
                    findClubById.findClubById();
                    break;
                case 9:
                    AddClubs addClubs = new AddClubs();
                    addClubs.addClub();

                    break;
                case 10:
                    DeleteClubById deleteClubById = new DeleteClubById();
                    deleteClubById.deleteClubById();
                    break;
                case 11:
                    FindAllClubsJson findAllClubsJson = new FindAllClubsJson();
                    findAllClubsJson.findAllClubsJson();
                    break;
                case 12:
                    FindClubByIdJson findClubByIdJson = new FindClubByIdJson();
                    findClubByIdJson.findClubByIdJson();
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
        System.out.println("5. Display all Players as JSON " );
        System.out.println("6. find Players by id as JSON" );
        System.out.println("7.display all clubs in the database");
        System.out.println("8.find  clubs in the database by id ");
        System.out.println("9.add clubs to the database  ");
        System.out.println("10.delete clubs  ");
        System.out.println("11.Find all Clubs as JSON ");
        System.out.println("12.Find Clubs by id as JSON ");



    }




}

