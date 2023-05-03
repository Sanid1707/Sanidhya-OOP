package com.dkit.oop.sd2.DTOs;

public class Club {
    private int clubId;
    private String clubName;
    private String jerseyColour;

    public Club(int clubId, String clubName, String jerseyColour) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.jerseyColour = jerseyColour;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getJerseyColour() {
        return jerseyColour;
    }

    public void setJerseyColour(String jerseyColour) {
        this.jerseyColour = jerseyColour;
    }

    @Override
    public String toString() {
        return "Club{" +
                "clubId=" + clubId +
                ", clubName='" + clubName + '\'' +
                ", jerseyColour='" + jerseyColour + '\'' +
                '}';
    }


}
