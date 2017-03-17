package com.example.tom_pc.vypocetmzdy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText Vstup_Hruba;
    private TextView VystupCista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Vstup_Hruba = (EditText) findViewById(R.id.editTextHruba);
        VystupCista = (TextView) findViewById(R.id.textViewVysledek);

    }

    public void Kliknuti_na_Vypocti(View view)
    {
        double Hruba = 0;
        double vysledek = 0;

        try {
            Hruba = Double.parseDouble(Vstup_Hruba.getText().toString());

        }   catch (NumberFormatException e){

            Toast myToast = Toast.makeText(
                    getApplication(), getResources().getString(R.string.String_WrongInput), Toast.LENGTH_SHORT
            ); //getResources().getString... volání stringu kvuli prekladům. Když bud mít nastavený telefon v jazyku který je v Stringách, vypíše se jeho jazyk.
            myToast.show();

            VystupCista.setText(String.valueOf(0));
        }

        finally {
            if (Hruba!=0) {
                double zdravotni = Hruba *0.045;
                double socialni = Hruba * 0.065;
                double superhruba = Hruba + (Hruba*0.25) + (Hruba*0.09);
                superhruba = (((int) superhruba+100)/100)*100;
                double danzesuperhrubé = superhruba * 0.15;

                double Odectenislevynapoplatnika = danzesuperhrubé - 2070;

                vysledek = Hruba - zdravotni - socialni - Odectenislevynapoplatnika;

                VystupCista.setText(String.valueOf(vysledek));
            }
        }
    }

}
