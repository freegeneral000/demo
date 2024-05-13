package com.example.demo.form;

import lombok.Data;

@Data
public class PlayerDtoForm {

    private String puuid;

    private String gameName;

    private String tagLine;

    private Long leaderboardRank;

    private Long rankedRating;

    private Long numberOfWins;
}
