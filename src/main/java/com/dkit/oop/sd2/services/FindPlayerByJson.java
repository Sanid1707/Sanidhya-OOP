package com.dkit.oop.sd2.services;

import com.dkit.oop.sd2.DAOs.PlayerDAO;
import com.dkit.oop.sd2.DAOs.PlayerDaoInterface;
import com.dkit.oop.sd2.DTOs.Player;
import com.dkit.oop.sd2.Exceptions.DaoException;
import com.google.gson.Gson;

import java.util.List;
import java.util.Scanner;

public class FindPlayerByJson
{
    PlayerDaoInterface playerDAO = new PlayerDAO();
    Gson gson = new Gson();
    public void findAllPlayerJson()
    {
        try {
            System.out.println("\nCall findAllUsers()");
            List<Player> players = playerDAO.findAllUsers();     // call a method in the DAO

            if (players.isEmpty())
                System.out.println("There are no Users");
            else {
                System.out.println("Player: " + gson.toJson(players));
            }

        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
}



