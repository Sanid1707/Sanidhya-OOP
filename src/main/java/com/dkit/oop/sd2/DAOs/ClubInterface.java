package com.dkit.oop.sd2.DAOs;

import com.dkit.oop.sd2.DTOs.Club;
import com.dkit.oop.sd2.DTOs.Player;
import com.dkit.oop.sd2.Exceptions.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface ClubInterface {
    public List<Club> findAllClubs() throws DaoException;
    public Club findClubById(int userId) throws DaoException;
    public void deleteClubByID(int id) throws SQLException;
    public void insertClubPlayer(Club club) throws SQLException;


}
