package com.example.mynumberguessinggame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
<<<<<<< HEAD
=======
import android.os.Process;
>>>>>>> 078faac (Fix the bugs of editText(component) & userAttempts(variable). Seem to be working fine now.)
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Random;


public class GameActivity extends AppCompatActivity {

    private TextView textViewLast, textViewRight, textViewHint;
<<<<<<< HEAD
    private Button buttonConfirm;
=======
>>>>>>> 078faac (Fix the bugs of editText(component) & userAttempts(variable). Seem to be working fine now.)
    private EditText editTextGuess;

    boolean twoDigits, threeDigits, fourDigits;

<<<<<<< HEAD
    Random r = new Random();
    int random;
    int remainingRight = 10;

    ArrayList<Integer> guessesList = new ArrayList<Integer>();
=======
    int random;
    Random r = new Random();
    int remainingRight = 10;

    ArrayList<Integer> guessesList = new ArrayList<>();
>>>>>>> 078faac (Fix the bugs of editText(component) & userAttempts(variable). Seem to be working fine now.)
    int userAttempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textViewLast = findViewById(R.id.textViewLast);
        textViewRight = findViewById(R.id.textViewRight);
        textViewHint = findViewById(R.id.textViewHint);

<<<<<<< HEAD
        buttonConfirm = findViewById(R.id.buttonConfirm);

        editTextGuess = findViewById(R.id.editTextGuess);

        twoDigits = getIntent().getBooleanExtra("twoDigits", false);
        threeDigits = getIntent().getBooleanExtra("threeDigits", false);
        fourDigits = getIntent().getBooleanExtra("fourDigits", false);
=======
        Button buttonConfirm = findViewById(R.id.buttonConfirm);

        editTextGuess = findViewById(R.id.editTextGuess);

        twoDigits = getIntent().getBooleanExtra("two", false);
        threeDigits = getIntent().getBooleanExtra("three", false);
        fourDigits = getIntent().getBooleanExtra("four", false);
>>>>>>> 078faac (Fix the bugs of editText(component) & userAttempts(variable). Seem to be working fine now.)

        if (twoDigits) {
            random = r.nextInt(90) + 10;
        } else if (threeDigits) {
            random = r.nextInt(900) + 100;
        } else if (fourDigits) {
            random = r.nextInt(9000) + 1000;
        }
<<<<<<< HEAD

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess = editTextGuess.getText().toString();

                if(guess.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                    builder.setTitle("Number Guessing Game");
                    builder.setCancelable(false);
                    builder.setMessage("Congratulations. My guess was " + random + "\n \n You know my number in " + userAttempts + " attempts \n \nYour guesses: " + guessesList + "\n\n Would you like to play again?");
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(GameActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                           moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
                        }
                    });
                    builder.create().show();
                }
                else {
                    textViewLast.setVisibility(View.VISIBLE);
                    textViewRight.setVisibility(View.VISIBLE);
                    textViewHint.setVisibility(View.VISIBLE);

                    userAttempts++;
                    remainingRight--;

                    textViewLast.setText("Your last guess: " + guess);
                    textViewRight.setText("Your remaining right: " + remainingRight);

                    int userGuess = Integer.parseInt(guess);
                    guessesList.add(userGuess);

                    if (random == userGuess) {
                        textViewHint.setText("Your guess is right");
                    }
                    if (random < userGuess) {
                        textViewHint.setText("Decrease your guess");
                    }
                    if (random > userGuess) {
                        textViewHint.setText("Increase your guess");
                    }

                    if(remainingRight == 0) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                        builder.setTitle("Number Guessing Game");
                        builder.setCancelable(false);
                        builder.setMessage("Sorry your right to guess is over. " + "\n\n My guess was " + random + " attempts \n \nYour guesses: " + guessesList + "\n\n Would you like to play again?");
=======
         // Random Guessing Number Game
        buttonConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                String guess = editTextGuess.getText().toString();
                if (guess.isEmpty()) {
                    Toast.makeText(GameActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                } else {
                    int userGuess = Integer.parseInt(guess);
                    guessesList.add(userGuess);
                    userAttempts++;
                    remainingRight--;
                    if (userGuess == random) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                        builder.setTitle("Number Guessing Game!");
                        builder.setCancelable(false);
                        builder.setMessage(" Congratulations. My guess was " + random + ". \n\n You know my number in " + userAttempts + " attempt/s. \n\n Your guesses: " + guessesList + "\n\n Would you like to play again?");
>>>>>>> 078faac (Fix the bugs of editText(component) & userAttempts(variable). Seem to be working fine now.)
                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                moveTaskToBack(true);
<<<<<<< HEAD
                                android.os.Process.killProcess(android.os.Process.myPid());
=======
                                Process.killProcess(Process.myPid());
>>>>>>> 078faac (Fix the bugs of editText(component) & userAttempts(variable). Seem to be working fine now.)
                                System.exit(1);
                            }
                        });
                        builder.create().show();
<<<<<<< HEAD
                    }
                    editTextGuess.setText("");
=======
                    } else {
                        textViewLast.setVisibility(View.VISIBLE);
                        textViewRight.setVisibility(View.VISIBLE);
                        textViewHint.setVisibility(View.VISIBLE);

                        textViewLast.setText("Your last guess: " + guess);
                        textViewRight.setText("Your remaining right: " + remainingRight);

                        if (random == userGuess) {
                            textViewHint.setText("Your guess is right!");
                        } else if (random < userGuess) {
                            textViewHint.setText("Decrease your guess");
                        } else {
                            textViewHint.setText("Increase your guess");
                        }
                        if (remainingRight == 0) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                            builder.setTitle("Number Guessing Game");
                            builder.setCancelable(false);
                            builder.setMessage(" Sorry, your right to guess is over. \n\n My guess was " + random + ". \n\n Your guesses: " + guessesList+ "\n\n Would you like to play again?");
                            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(GameActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    moveTaskToBack(true);
                                    Process.killProcess(Process.myPid());
                                    System.exit(1);
                                }
                            });
                            builder.create().show();
                        }
                        editTextGuess.setText("");
                    }
>>>>>>> 078faac (Fix the bugs of editText(component) & userAttempts(variable). Seem to be working fine now.)
                }
            }
        });

    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 078faac (Fix the bugs of editText(component) & userAttempts(variable). Seem to be working fine now.)
