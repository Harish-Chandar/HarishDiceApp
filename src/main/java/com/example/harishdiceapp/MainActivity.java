package com.example.harishdiceapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int p1wins = 0;
    private int p2wins = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void click(View v) {
        int die1 = (int)(Math.random()*6+1);
        int die2 = (int)(Math.random()*6+1);

        ImageView d1 = findViewById(R.id.die1);
        ImageView d2 = findViewById(R.id.die2);
        ImageView[] dviews = {d1,d2};

        CharSequence toastText = "";
        int duration = Toast.LENGTH_SHORT;

        if (die1 > die2) {
            p1wins ++;
            ((TextView) findViewById(R.id.p1)).setText("# of wins: " + p1wins);
            toastText = "Player 1 Wins!";
            Toast.makeText(this, toastText, duration).show();
        } else if (die2 > die1) {
            p2wins ++;
            ((TextView) findViewById(R.id.p2)).setText("# of wins: " + p2wins);
            toastText = "Player 2 Wins!";
            Toast.makeText(this, toastText, duration).show();
        } else {
            toastText = "Tied!";
            Toast.makeText(this, toastText, duration).show();
        }

        for (ImageView d : dviews) {
            int dnum = 1;
            if (d == d1) { dnum = die1; } else if (d == d2) { dnum = die2; }
            if (dnum == 1) {
                d.setImageResource(R.drawable.one);
            } else if (dnum == 2) {
                d.setImageResource(R.drawable.two);
            } else if (dnum == 3) {
                d.setImageResource(R.drawable.three);
            } else if (dnum == 4) {
                d.setImageResource(R.drawable.four);
            } else if (dnum == 5) {
                d.setImageResource(R.drawable.five);
            } else if (dnum == 6) {
                d.setImageResource(R.drawable.six);
            }
        }

        if (p1wins > p2wins) {
            ((TextView) findViewById(R.id.winner)).setText("Winner: Player 1!");
        } else if (p2wins > p1wins) {
            ((TextView) findViewById(R.id.winner)).setText("Winner: Player 2!");
        } else {
            ((TextView) findViewById(R.id.winner)).setText("Winner: Tied!");
        }
    }
}