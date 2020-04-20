package com.bookofsun.CLI.controlerCLI;

import android.graphics.Point;

import com.bookofsun.CLI.modelCLI.Figure;
import com.bookofsun.CLI.modelCLI.Filed;
import com.bookofsun.CLI.modelCLI.exeptions.InvalidPointException;


/**
 * Author: Olenyk Denis (deoniisii@gmail.com)
 * on 04.08.15.
 */

public class CurrentMoveController {

    public Figure currentMove(final Filed filed) throws InvalidPointException {
        int countFigure = 0;
        for (int x = 0; x < filed.getSize(); x++) {
            countFigure += currentFiguresInTheRow(filed, x);
        }

        if (countFigure == filed.getSize() * filed.getSize()) {
            return null;
        }

        if (countFigure % 2 == 0) {
            return Figure.X;
        }

        return Figure.O;


    }

    private int currentFiguresInTheRow(final Filed filed, final int row) throws InvalidPointException {
        int countFigure = 0;

        for (int x = 0; x < filed.getSize(); x++) {
            if (filed.getFigure(new Point(x, row)) != null) {
                countFigure++;

            }

        }
        return countFigure;

    }


}
