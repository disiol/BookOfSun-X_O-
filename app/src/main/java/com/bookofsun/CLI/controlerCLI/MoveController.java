package com.bookofsun.CLI.controlerCLI;

import android.graphics.Point;

import com.bookofsun.CLI.modelCLI.Figure;
import com.bookofsun.CLI.modelCLI.Filed;
import com.bookofsun.CLI.modelCLI.exeptions.AlreadyOccupantException;
import com.bookofsun.CLI.modelCLI.exeptions.InvalidPointException;


/**
 * Author: Olenyk Denis (deoniisii@gmail.com)
 * on 31.07.15.
 */

public class MoveController {


    public void applyFigure(Filed filed,
                            Point point,
                            Figure figure) throws InvalidPointException,
            AlreadyOccupantException {

        if (filed.getFigure(point) != null) {
            throw new AlreadyOccupantException();
        }

        filed.setFigure(point, figure);


    }
}
