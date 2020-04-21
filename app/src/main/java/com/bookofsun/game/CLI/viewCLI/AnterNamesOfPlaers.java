package com.bookofsun.game.CLI.viewCLI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.bookofsun.game.GameActivity;
import com.bookofsun.R;

public class AnterNamesOfPlaers extends AppCompatActivity implements View.OnClickListener {

    public static final String PLAYER_WANE_NAME = "playerWaneName";
    public static final String PLAYER_TO_NAME = "playerToName";
    private EditText playerWaneName, playerToName;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anter_names_of_plaers);
//TODO emti text ceak
        playerWaneName = findViewById(R.id.first_player_name);
        playerToName = findViewById(R.id.second_player_name);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(PLAYER_WANE_NAME, playerWaneName.getText().toString());
        intent.putExtra(PLAYER_TO_NAME, playerToName.getText().toString());
        startActivity(intent);
        finish();
    }
}
