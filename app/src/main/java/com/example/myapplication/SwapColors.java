package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.Random;
public class SwapColors extends AppCompatActivity {
    TextView scoreTv;
    int[] COLOR = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,};
    Button[][] btn = new Button[5][5];
    Random rand = new Random();
    int score = 0;
    int[][] tiles = new int[5][5];
    private Button selectedButton = null;
    //@SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap_colors);
        scoreTv = findViewById(R.id.scoreView);
        scoreTv.setText(getString(R.string.score) + " " + score);
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                String res = "btn" + row + col;
                int resId = getResources().getIdentifier(res, "id", this.getPackageName());
                btn[row][col] = findViewById(resId);
            }
        }
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                final int x = i;
                final int y = j;
                System.out.println(i + " " + j);
                btn[i][j].setOnClickListener(view -> handleButtonClick(x, y));
            }
        }
        Button reset = findViewById(R.id.btnReset);
        reset.setOnClickListener(view -> {
            do {
                randomize();
                randomColor();
            } while (checker());
            score = 0;
            scoreTv.setText(getString(R.string.score) + " " + score);
            selectedButton = null;
        });
        do {
            randomize();
            randomColor();
        } while (checker());
    }
    private void randomColor(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                int tileVal = tiles[i][j];
                int color = COLOR[tileVal];
                btn[i][j].setBackgroundColor(color);
            }
        }
    }
    private void randomize(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                tiles[i][j] = rand.nextInt(4);
            }
        }
    }
    //@SuppressLint("SetTextI18n")
    private void handleButtonClick(int row, int col) {
        if (selectedButton == null) {
            selectedButton = btn[row][col];
            return;
        }
        Button curr = btn[row][col];
        if (isAdjacent(selectedButton, curr)) {
            swapColors(selectedButton, curr);
            while(checker()){
                score++;
                scoreTv.setText(getString(R.string.score) + " " + score);
            }
        }
        selectedButton = null;
    }
    private boolean isAdjacent(Button btn1, Button btn2){
        int row1 = getButtonRow(btn1);
        int col1 = getButtonColumn(btn1);
        int row2 = getButtonRow(btn2);
        int col2 = getButtonColumn(btn2);
        return (Math.abs(row1 - row2) == 1 && col1 == col2) || (row1 == row2 && Math.abs(col1 - col2) == 1);
    }
    private int getButtonRow(Button button) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (btn[i][j] == button) {
                    return i;
                }
            }
        }
        return -1;
    }
    private int getButtonColumn(Button button) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (btn[i][j] == button) {
                    return j;
                }
            }
        }
        return -1;
    }
    private void swapColors(Button button1, Button button2) {
        int r1 = getButtonRow(button1);
        int c1 = getButtonColumn(button1);
        int r2 = getButtonRow(button2);
        int c2 = getButtonColumn(button2);
        int temp = tiles[r1][c1];
        tiles[r1][c1] = tiles[r2][c2];
        tiles[r2][c2] = temp;
        int color1 = COLOR[tiles[r1][c1]];
        int color2 = COLOR[tiles[r2][c2]];
        button1.setBackgroundColor(color1);
        button2.setBackgroundColor(color2);
    }
    private boolean checker(){
        boolean foundMatch = false;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(i > 0 && i < 4){
                    if(tiles[i - 1][j] == tiles[i][j] && tiles[i][j] == tiles[i+1][j]) {
                        int rem = 1;
                        int rem2 = 1;
                        if((i == 2)){
                            if(tiles[i-2][j] == tiles[i][j]){
                                rem++;
                            }
                            if(tiles[i][j] == tiles[i+2][j]){
                                rem2++;
                            }
                        }
                        for(int k = i-rem; k <= i + rem2; k++){
                            tiles[k][j] = rand.nextInt(4);
                            int tileVal = tiles[k][j];
                            int color = COLOR[tileVal];
                            btn[k][j].setBackgroundColor(color);
                        }
                        foundMatch = true;
                    }
                }
                if(j > 0 && j < 4){
                    if(tiles[i][j - 1] == tiles[i][j] && tiles[i][j] == tiles[i][j+1]){
                        int rem = 1;
                        int rem2 = 1;
                        if((j == 2)){
                            if(tiles[i][j-2] == tiles[i][j]){
                                rem++;
                            }
                            if(tiles[i][j] == tiles[i][j+2]){
                                rem2++;
                            }
                        }
                        for(int k = j-rem; k <= j + rem2; k++){
                            tiles[i][k] = rand.nextInt(4);
                            int tileVal = tiles[i][k];
                            int color = COLOR[tileVal];
                            btn[i][k].setBackgroundColor(color);
                        }
                        foundMatch = true;
                    }
                }
            }
        }
        return foundMatch;
    }

}