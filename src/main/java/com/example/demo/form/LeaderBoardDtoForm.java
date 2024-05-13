package com.example.demo.form;

import lombok.Data;

import java.util.List;

@Data
public class LeaderBoardDtoForm {

    private String shard;

    private String actId;

    private Long totalPlayers;

    private List<PlayerDtoForm> players;
}
