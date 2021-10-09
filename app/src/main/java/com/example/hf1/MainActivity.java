package com.example.hf1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView valasztottMuvelet,eredmeny;
    EditText input1,input2;
    int szam1,szam2;
    Button osszead,kivon,szoroz,oszt,egyenlo;
    int operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operation=0;

        input1 = findViewById(R.id.inputField1);
        input2 = findViewById(R.id.inputField2);
        osszead = findViewById(R.id.buttonPlus);
        kivon = findViewById(R.id.buttonMinus);
        szoroz = findViewById(R.id.buttonMultiply);
        oszt = findViewById(R.id.buttonDivide);
        egyenlo = findViewById(R.id.buttonEquals);
        valasztottMuvelet = findViewById(R.id.selectedOperation);
        eredmeny = findViewById(R.id.resultField);

        osszead.setOnClickListener(view -> {
            operation=1;
            valasztottMuvelet.setText("+");
        });

        kivon.setOnClickListener(view -> {
            operation=2;
            valasztottMuvelet.setText("-");
        });

        szoroz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation=3;
                valasztottMuvelet.setText("*");
            }
        });

        oszt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation=4;
                valasztottMuvelet.setText("/");
            }
        });

        egyenlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    szam1 = Integer.parseInt(input1.getText().toString());
                    szam2 = Integer.parseInt(input2.getText().toString());
                } catch (NumberFormatException ex) {
                    Toast.makeText(MainActivity.this, "Uresen hagytal egy vagy tobb mezot!",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Altalanos hiba!",
                            Toast.LENGTH_SHORT).show();
                } finally {
                    switch (operation) {
                    case 1: {
                        try {
                            eredmeny.setText(new Integer(szam1 + szam2).toString());
                        } catch (ArithmeticException ex) {
                            Toast.makeText(MainActivity.this, "Aritmetikai hiba!",
                                    Toast.LENGTH_SHORT).show();
                            break;
                        } finally {
                            break;
                        }
                    }
                    case 2: {
                        try {
                            eredmeny.setText(new Integer(szam1 - szam2).toString());
                        } catch (ArithmeticException ex) {
                            Toast.makeText(MainActivity.this, "Aritmetikai hiba!",
                                    Toast.LENGTH_SHORT).show();
                            break;
                        } finally {
                            break;
                        }
                    }
                    case 3: {
                        try {
                            eredmeny.setText(new Integer(szam1 * szam2).toString());
                        } catch (ArithmeticException ex) {
                            Toast.makeText(MainActivity.this, "Aritmetikai hiba!",
                                    Toast.LENGTH_SHORT).show();
                            break;
                        } finally {
                            break;
                        }
                    }
                    case 4: {
                        try {
                            eredmeny.setText( String.format("%6.06f", (double) (szam1) / szam2) );

                        } catch (ArithmeticException ex) {
                            Toast.makeText(MainActivity.this, "A nevezonek adj meg 0-tol kulombozo szamot!",
                                    Toast.LENGTH_SHORT).show();
                            break;
                        } finally {
                            break;
                        }
                    }
                    default: {

                        Toast.makeText(MainActivity.this, "Nem valasztottal muveletet!",
                                Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }

            }
        });

    }
}