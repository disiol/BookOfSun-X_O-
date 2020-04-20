package com.bookofsun.CLI.controlerCLI;

import android.graphics.Point;

import com.bookofsun.CLI.modelCLI.Figure;
import com.bookofsun.CLI.modelCLI.Filed;
import com.bookofsun.CLI.modelCLI.exeptions.InvalidPointException;


/**
 * Author: Olenyk Denis (deoniisii@gmail.com)
 * on 31.07.15.
 */

public class WinnerController {

    public Figure getWinner(final Filed filed) throws InvalidPointException {

        //проверка рядов
        for (int i = 0; i < 3; i++) {
            if (check(filed, new Point(i, 0), p -> new Point(p.x, p.y + 1))) {

                try {
                    return filed.getFigure(new Point(i, 0));
                } catch (InvalidPointException e) {
                    e.printStackTrace();
                }

            }

        }

        //проверка колонок
        for (int i = 0; i < 3; i++) {
            if (check(filed, new Point(0, i), p -> new Point(p.x + 1, p.y))) {

                return filed.getFigure(new Point(0, i));

            }

        }

        // Проверка первой диагонали
        if (check(filed, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1))) {

            return filed.getFigure(new Point(0, 0));

        }

        // Проверка второй диагонали
        if (check(filed, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1))) {

            return filed.getFigure(new Point(1, 1));

        }

        return null;
    }


    private boolean check(final Filed filed,
                          final Point currentPoint,
                          final IPointGenerator pointGenerator) throws InvalidPointException {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);

        currentFigure = filed.getFigure(currentPoint);
        if (currentFigure == null)
            return false;
        nextFigure = filed.getFigure(nextPoint);


        if (currentFigure != nextFigure)
            return false;


        return check(filed, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {

        Point next(final Point point);
    }

}

