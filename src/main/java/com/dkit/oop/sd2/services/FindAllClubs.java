//package com.dkit.oop.sd2.services;
//
//import com.dkit.oop.sd2.DAOs.ClubDAO;
//import com.dkit.oop.sd2.DAOs.ClubInterface;
//import com.dkit.oop.sd2.DTOs.Club;
//import com.dkit.oop.sd2.Exceptions.DaoException;
//
//import java.util.List;
//
//public class FindAllClubs {
//    ClubInterface IUserDao = new ClubDAO();
//
//    public void findAllClubs() throws DaoException {
//        try {
//            System.out.println("\nCall findAllClubs()");
//            List<Club> clubs = IUserDao.findAllClubs();     // call a method in the DAO
//
//            if (clubs.isEmpty())
//                System.out.println("There are no Clubs");
//            else {
//                for (Club club : clubs)
//                    System.out.println("Club: " + club.toString());
//            }
//
//        } catch (DaoException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//}
//



package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.ClubDAO;
import com.dkit.oop.sd2.DAOs.ClubInterface;
import com.dkit.oop.sd2.DTOs.Club;
import com.dkit.oop.sd2.Exceptions.DaoException;

import java.util.List;

public class FindAllClubs {
    ClubInterface clubDAO = new ClubDAO();

    public void findAllClubs() throws DaoException {
        try {
//            System.out.println("\nCall findAllClubs()");
            List<Club> clubs = clubDAO.findAllClubs();     // call a method in the DAO

            if (clubs.isEmpty())
                System.out.println("There are no Clubs");
            else {
                // Print table header
                System.out.format("%-6s%-20s%-15s%n",
                        "Id", "Club Name", "Jersey Colour");
                System.out.println("------------------------------------------");

                // Print each club's information
                for (Club club : clubs) {
                    System.out.format("%-6d%-20s%-15s%n",
                            club.getClubId(), club.getClubName(), club.getJerseyColour());
                }
            }

        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
}
