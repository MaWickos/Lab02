package pollub.ism.lab02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/* Dodane importy */
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/* Dodane importy */
public class MainActivity extends AppCompatActivity {

    /* Uchywty widokow */
    private TextView poleTekstowe = null;
    private EditText poleEdycyjne = null;
    private Button  przycisk1 = null,
                    przycisk2 = null,
                    przycisk3 = null;

    /* Zmienne -liczniki wywołań metod cyklu */
    private int licznikCreate = 0,
                licznikStart = 0,
                licznikResume = 0,
                licznikPause = 0,
                licznikStop = 0,
                licznikRestart = 0,
                licznikDestroy = 0;

    private static String   KEY_CREATE = "Wartosc licznika create",
                            KEY_START = "Wartosc licznika start",
                            KEY_RESUME = "Wartosc licznika resume",
                            KEY_PAUSE = "Wartosc licznika pause",
                            KEY_STOP = "Wartosc licznika stop",
                            KEY_RESTART = "Wartosc licznika restart",
                            KEY_DESTROY = "Wartosc licznika destroy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Dodane */
        poleTekstowe = (TextView) findViewById(R.id.textView2);
        poleEdycyjne = (EditText) findViewById(R.id.editText);
        przycisk1 = (Button) findViewById(R.id.button1);
        przycisk2 = (Button) findViewById(R.id.button2);
        przycisk3 = (Button) findViewById(R.id.button3);

        poleEdycyjne.setEnabled(false);
        przycisk2.setText(getResources().getString(R.string.odblokuj));

        /* Uzupełnie metody cyklu życia */
        powiedzCoWykonujesz("onCreate");

        /* Inkrementacja licznika */
        licznikCreate++;
    }

    /* Kod dodany - szkielet metody cyklu zycia */
    @Override
    protected void onStart(){
        super.onStart();

        /* Uzupełnie metody cyklu życia */
        powiedzCoWykonujesz("onStart");

        /* Inkrementacja licznika */
        licznikStart++;
    }

    @Override
    protected void onResume(){
        super.onResume();

        /* Uzupełnie metody cyklu życia */
        powiedzCoWykonujesz("onResume");

        /* Inkrementacja licznika */
        licznikRestart++;
    }

    @Override
    protected void onPause(){
        super.onPause();

        /* Uzupełnie metody cyklu życia */
        powiedzCoWykonujesz("onPause");

        /* Inkrementacja licznika */
        licznikPause++;
    }

    @Override
    protected void onStop(){
        super.onStop();

        /* Uzupełnie metody cyklu życia */
        powiedzCoWykonujesz("onStop");

        /* Inkrementacja licznika */
        licznikStop++;
    }

    @Override
    protected void onRestart(){
        super.onRestart();

        /* Uzupełnie metody cyklu życia */
        powiedzCoWykonujesz("onRestart");

        /* Inkrementacja licznika */
        licznikRestart++;
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        /* Uzupełnie metody cyklu życia */
        powiedzCoWykonujesz("onDestroy");

        /* Inkrementacja licznika */
        licznikDestroy++;
    }

    /* Funkcja do modyfikacji napisów w widokach textView2 */
    private void powiedzCoWykonujesz(String info){
        poleTekstowe.setText(info);
        poleEdycyjne.append(info + "\n");
    }

    /* Funkcja do usuwania tekstu z widoku */
    public void wyczyscPoleEdycyjne(View view){
        poleEdycyjne.setText("");
    }

    /* Funkcja odblokowująca/blokująca możliwośc edycji w editText */
    public void zablokujOdblokujPoleEdycyjne(View view){

        poleEdycyjne.setEnabled(!poleEdycyjne.isEnabled());
        if(poleEdycyjne.isEnabled()){
            przycisk2.setText(getResources().getString(R.string.zablokuj));
        } else {
            przycisk2.setText(getResources().getString(R.string.odblokuj));
        }
    }

    /* Funkcja wyświetlająca informacje o wartosci zmiennych */
    public void wyswietlZmienne(View view){
        String info = "create = " + licznikCreate
                + ", start = " + licznikStart
                + ", resume = " + licznikResume
                + "\npause = " + licznikStop
                + ", restart = " + licznikRestart
                + ", destroy = " + licznikDestroy;

        poleEdycyjne.append(info + "\n");
    }


    /* Funkcja do zachowania wartosc w trakcie przechodzenia pomiedzy aktywnosciami */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){

        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CREATE, licznikCreate);
        outState.putInt(KEY_START, licznikStart);
        outState.putInt(KEY_RESUME, licznikResume);
        outState.putInt(KEY_PAUSE, licznikPause);
        outState.putInt(KEY_STOP, licznikStop);
        outState.putInt(KEY_RESTART, licznikRestart);
        outState.putInt(KEY_DESTROY, licznikDestroy);
    }

    /* Funkcja do przywrocenia wartosci zmiennych */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){

        super.onRestoreInstanceState(savedInstanceState);
        licznikCreate = savedInstanceState.getInt(KEY_CREATE, 0);
        licznikStart = savedInstanceState.getInt(KEY_START, 0);
        licznikResume = savedInstanceState.getInt(KEY_RESUME, 0);
        licznikPause = savedInstanceState.getInt(KEY_PAUSE, 0);
        licznikStop = savedInstanceState.getInt(KEY_STOP, 0);
        licznikRestart = savedInstanceState.getInt(KEY_RESTART, 0);
        licznikDestroy = savedInstanceState.getInt(KEY_DESTROY, 0);
    }
}