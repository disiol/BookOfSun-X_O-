package com.bookofsun;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bookofsun.CLI.modelCLI.Figure;
import com.bookofsun.CLI.modelCLI.Filed;
import com.bookofsun.CLI.modelCLI.Game;
import com.bookofsun.CLI.modelCLI.Player;
import com.bookofsun.CLI.modelCLI.exeptions.InvalidPointException;
import com.bookofsun.CLI.viewCLI.AnterNamesOfPlaers;
import com.bookofsun.CLI.viewCLI.ConsoleView;

import static com.bookofsun.CLI.viewCLI.AnterNamesOfPlaers.PLAYER_TO_NAME;
import static com.bookofsun.CLI.viewCLI.AnterNamesOfPlaers.PLAYER_WANE_NAME;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView buttonExit, buttonNewGame;
    private TextView playerMove;
    private ImageView imageView2,
            imageView3,
            imageView4,
            imageView5,
            imageView6,
            imageView7,
            imageView8,
            imageView9,
            imageView10;


    private String plaeyr1Name;
    private String plaeyr2Name;

    public static final int FILED_SIZE = 3;
    public static final String NAME = "XO";
    private int[] arayCordinats = {0, 1, 2};
    private ConsoleView consoleView;
    private Game gameXO;
    private Player[] players;
    private boolean move = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerMove = findViewById(R.id.player_move_textView);

        imageView2 = findViewById(R.id.imageView2);
        imageView2.setOnClickListener(this);

        imageView3 = findViewById(R.id.imageView3);
        imageView3.setOnClickListener(this);

        imageView3 = findViewById(R.id.imageView3);
        imageView3.setOnClickListener(this);

        imageView4 = findViewById(R.id.imageView4);
        imageView4.setOnClickListener(this);

        imageView5 = findViewById(R.id.imageView5);
        imageView5.setOnClickListener(this);

        imageView6 = findViewById(R.id.imageView6);
        imageView6.setOnClickListener(this);


        imageView7 = findViewById(R.id.imageView7);
        imageView7.setOnClickListener(this);

        imageView8 = findViewById(R.id.imageView8);
        imageView8.setOnClickListener(this);

        imageView9 = findViewById(R.id.imageView9);
        imageView9.setOnClickListener(this);

        imageView10 = findViewById(R.id.imageView10);
        imageView10.setOnClickListener(this);

        buttonExit = findViewById(R.id.exit_button);
        buttonExit.setOnClickListener(this);

        buttonNewGame = findViewById(R.id.new_game_button);
        buttonNewGame.setOnClickListener(this);


        Intent intent = getIntent();
        plaeyr1Name = intent.getStringExtra(PLAYER_WANE_NAME);
        plaeyr2Name = intent.getStringExtra(PLAYER_TO_NAME);

        setXOCLI(plaeyr1Name, plaeyr2Name);


    }


    public void setXOCLI(String plaeyr1Name, String plaeyr2Name) {

        final String name1 = plaeyr1Name;
        final String name2 = plaeyr2Name;


        players = new Player[2];
        players[0] = new Player(name1, Figure.X, R.drawable.player_wan_figure);
        players[1] = new Player(name2, Figure.O, R.drawable.player_too_figure);


        gameXO = new Game(players, new Filed(FILED_SIZE), NAME);
        consoleView = new ConsoleView();

        playerMove.setText(String.format("Player move: %s, figure: %s", players[0].getName(), players[0].getFigure()));



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView2:
                setMove(0, 0, imageView2, this.getApplicationContext());
                break;
            case R.id.imageView3:
                setMove(1, 0, imageView3, this.getApplicationContext());
                break;
            case R.id.imageView4:
                setMove(2, 0, imageView4, this.getApplicationContext());
                break;
            case R.id.imageView5:
                setMove(0, 1, imageView5, this.getApplicationContext());
                break;
            case R.id.imageView6:
                setMove(1, 1, imageView6, this.getApplicationContext());
                break;
            case R.id.imageView7:
                setMove(2, 1, imageView7, this.getApplicationContext());
                break;
            case R.id.imageView8:
                setMove(0, 2, imageView8, this.getApplicationContext());
                break;
            case R.id.imageView9:
                setMove(1, 2, imageView9, this.getApplicationContext());
                break;

            case R.id.imageView10:
                setMove(2, 2, imageView10, this.getApplicationContext());
                break;
            case R.id.exit_button:
                finish();
                break;
            case R.id.new_game_button:
                Intent intent = new Intent(this, AnterNamesOfPlaers.class);
                startActivity(intent);
                finish();
                break;


        }
    }

    void setMove(int x, int y, ImageView imageView, Context applicationContext)  {
        if (this.move) {
            this.move = consoleView.move(gameXO, players, playerMove, arayCordinats[x], arayCordinats[y], imageView, applicationContext);
            consoleView.show(gameXO);
        }
    }
}
