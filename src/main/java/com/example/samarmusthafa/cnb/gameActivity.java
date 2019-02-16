package com.example.samarmusthafa.cnb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.StringBufferInputStream;

public class gameActivity extends AppCompatActivity {
    private static int a=1;
    public static StringBuffer guess1=new StringBuffer();
    public static StringBuffer guess2=new StringBuffer();
    public static StringBuffer guessof1=new StringBuffer();
    public static StringBuffer guessof2=new StringBuffer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        final TextView infoView = (TextView)findViewById(R.id.infoView);
        infoView.setText("Enter your number, Player 1");
        final TextView editView = (TextView)findViewById(R.id.editView);
        final TextView bcView=(TextView)findViewById(R.id.bcView);
        guess1.replace(0, guess1.length(),"");
        guess2.replace(0, guess1.length(),"");
        guessof2.replace(0, guess1.length(),"");
        guessof1.replace(0, guess1.length(),"");

        Button passButton = (Button)findViewById(R.id.passButton);
        for(int i=0;i<40;i++){
            int k=0;
            passButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int bull=0,cow=0;
                    int[] g1=new int[4];
                    int[] g2=new int[4];
                    if (a == 1) {
                        guess1.replace(0, guess1.length(),editView.getText().toString());
                        editView.setText("....");
                        infoView.setText("Enter your number, Player 2");
                    } else if (a == 2) {
                        guess2.replace(0, guess2.length(),editView.getText().toString());
                        editView.setText("....");
                        infoView.setText("Enter your guess, Player 1");
                    } else {
                        if (a % 2 == 1) {
                            guessof1.replace(0, guessof1.length(),editView.getText().toString());
                            editView.setText("....");
                            infoView.setText("Enter your guess, Player 2");
                            for(int j=0;j<4;j++){
                                if(guess2.charAt(j)==guessof1.charAt(j)){
                                    bull=bull+1;
                                    g1[j]=4;
                                }
                                else{
                                    g1[j]=j;
                                }
                            }
                            guessof1.append("b");
                            for(int j=0;j<4;j++){
                                for(int t=0;t<4;t++){
                                    if(guessof1.charAt(g1[j])==guess2.charAt(t)){
                                        cow+=1;
                                    }
                                }
                            }
                            guessof1.setLength(guessof1.length()-1);
                            bcView.setText("BULLS: "+bull+"\nCOWS: "+cow);
                            bull=0;
                            cow=0;
                        } else {
                            guessof2.replace(0, guessof2.length(),editView.getText().toString());
                            editView.setText("....");
                            infoView.setText("Enter your guess, Player 1");
                            for(int j=0;j<4;j++){
                                if(guess1.charAt(j)==guessof2.charAt(j)){
                                    bull=bull+1;
                                    g2[j]=4;
                                }
                                else{
                                    g2[j]=j;
                                }
                            }
                            guessof2.append("b");
                            for(int j=0;j<4;j++){
                                for(int t=0;t<4;t++){
                                    if(guessof2.charAt(g2[j])==guess1.charAt(t)){
                                        cow+=1;
                                    }
                                }
                            }
                            guessof2.setLength(guessof2.length()-1);
                            bcView.setText("BULLS: "+bull+"\nCOWS: "+cow);
                        }
                        if (guessof1.toString().equals(guess2.toString())==true) {
                            infoView.setText("Good Job, Player 1! You've guessed it!");
                            int k = 1;
                        } else if (guessof2.toString().equals(guess1.toString())==true) {
                            infoView.setText("Good Job, Player 2! You've guessed it!");
                            int k = 1;
                        }
                    }
                    a += 1;
                }
            });
            if(k==1){
                break;
            }
        }
    }
}
