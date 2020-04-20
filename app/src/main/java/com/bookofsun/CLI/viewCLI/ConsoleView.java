package com.bookofsun.CLI.viewCLI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.bookofsun.CLI.controlerCLI.CurrentMoveController;
import com.bookofsun.CLI.controlerCLI.MoveController;
import com.bookofsun.CLI.controlerCLI.WinnerController;
import com.bookofsun.CLI.modelCLI.Figure;
import com.bookofsun.CLI.modelCLI.Filed;
import com.bookofsun.CLI.modelCLI.Game;
import com.bookofsun.CLI.modelCLI.Player;
import com.bookofsun.CLI.modelCLI.exeptions.AlreadyOccupantException;
import com.bookofsun.CLI.modelCLI.exeptions.InvalidPointException;

/**
 * Author: Olenyk Denis (deoniisii@gmail.com)
 * on 07.08.15.
 */

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final
    WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show(final Game game) {
        System.out.printf("GameStart name: %s\n", game.getName());
        final Filed filed = game.getFiled();
        for (int x = 0; x < filed.getSize(); x++) {
            if (x != 0) {
                printSeparator();
            }
            printLine(filed, x);
        }

    }

    //TODO
    public boolean move(final Game game, Player[] players, TextView playerMove, int x, int y, ImageView imageView, Context view) {
        final Filed filed = game.getFiled();
        Figure winner = winnerController.getWinner(filed);

        final Figure currentFigure = currentMoveController.currentMove(filed);

        //check for winers
        if (checkForWiners(players, playerMove, imageView, view, winner, currentFigure)) {
            return false;
        }


        playerMove(players, filed, currentFigure, playerMove, x, y, imageView, view);

        winner = winnerController.getWinner(filed);

        if (checkForWiners(players, playerMove, imageView, view, winner, currentFigure)) {
            return false;
        }

        return true;

    }

    private boolean checkForWiners(Player[] players, TextView playerMove, ImageView imageView, Context view, Figure winner, Figure currentFigure) {
        if (winnerIsPlayer(players, winner, playerMove, imageView, view)) {
            return true;
        }

        if (noWinnerAndNoMovesLeft(winner, currentFigure, playerMove)) {
            return true;
        }
        return false;
    }

    @SuppressLint("SetTextI18n")
    boolean noWinnerAndNoMovesLeft(Figure winner, Figure currentFigure, TextView playerMove) {
        if (currentFigure == null) {
            if (winner == null) {
                System.out.printf("No winner and no moves left");

                playerMove.setText("No winner and no moves left");
                return true;
            }

        }
        return false;
    }

    boolean winnerIsPlayer(Player[] players, Figure winner, TextView playerMove, ImageView imageView, Context view) {
        if (winner != null) {

            System.out.println();
            System.out.printf("Winner is player: %s, Figure: %s\n", playerName(players, winner, imageView, view), winner);

            playerMove.setText(String.format("Winner is player: %s, Figure: %s\n", playerName(players, winner, imageView, view), winner));


            return true;
        }
        return false;
    }

   public void playerMove(Player[] players, Filed filed, Figure currentFigure, TextView playerMove, int x, int y, ImageView imageView, Context context) {

        //TODO how names ferst
        System.out.printf("Player move: %s, figure: %s\nPlease enter move point \n", playerName(players, currentFigure, imageView, context), currentFigure);
        playerMove.setText(String.format("Player move: %s, figure: %s", playerName(players, currentFigure, imageView, context), currentFigure));

        final Point point = setPoints(x, y);
        try {
            moveController.applyFigure(filed, point, currentFigure);
        } catch (final InvalidPointException | AlreadyOccupantException e) {
            System.out.println("Point is invalid");
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private String playerName(Player[] players, Figure input, ImageView imageView, Context context) {
        final Player[] player = new Game(players, null, null).getPlayers();

        if (input == Figure.X) {
            imageView.setClickable(false);
            imageView.setImageDrawable(context.getDrawable(player[0].getPlayerFigure()));
            return player[0].getName();
        }
        if (input == Figure.O) {
            imageView.setImageDrawable(context.getDrawable(player[1].getPlayerFigure()));
            imageView.setClickable(false);
            return player[1].getName();

        }


        return null;
    }

    private Point setPoints(int x, int y) {
        return new Point(x, y);
    }



    private void printLine(final Filed filed,
                           final int x) {


        for (int y = 0; y < filed.getSize(); y++) {
            if (y != 0) {
                System.out.print("|");
            }
            System.out.print(" ");

            final Figure figure;
            try {
                figure = filed.getFigure(new Point(y, x));
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");


        }
        System.out.println();


    }

    private void printSeparator() {
        System.out.println(" " + "~~~~~~~~~");
    }


}
