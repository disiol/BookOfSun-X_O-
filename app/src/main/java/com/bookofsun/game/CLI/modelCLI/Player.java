package com.bookofsun.game.CLI.modelCLI;

/**
 * Author: Olenyk Denis (deoniisii@gmail.com)
 * on 30.07.15.
 */

public class Player {

    private final String name;

    private final Figure figure;
    private final int playerFigure;


    public Player(String name, Figure figure, int playerFigure) {
        this.name = name;
        this.figure = figure;
        this.playerFigure = playerFigure;
    }


    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }

    public int getPlayerFigure() {
        return playerFigure;
    }
}
