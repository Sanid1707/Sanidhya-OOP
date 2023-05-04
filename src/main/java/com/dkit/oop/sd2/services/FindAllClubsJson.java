package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.ClubDAO;
import com.dkit.oop.sd2.DAOs.ClubInterface;
import com.dkit.oop.sd2.DTOs.Club;
import com.dkit.oop.sd2.DTOs.Player;
import com.dkit.oop.sd2.Exceptions.DaoException;
import com.google.gson.Gson;

import java.util.List;

public class FindAllClubsJson {
    ClubInterface clubDAO = new ClubDAO();
    Gson gson = new Gson();
    public void findAllClubsJson()
    {        try {
        System.out.println("\nCall findAllUsers()");
        List<Club> club = clubDAO.findAllClubs();     // call a method in the DAO

        if (club.isEmpty())
            System.out.println("There are no Clubs");
        else {
            System.out.println("Clubs: " + gson.toJson(club));
        }

    } catch (DaoException e) {
        throw new RuntimeException(e);
    }

    }
}
