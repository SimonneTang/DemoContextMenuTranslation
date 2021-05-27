package sg.edu.rp.c346.id20025732.democontextmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText, TvTranslatedText2;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedtext);
        TvTranslatedText2 = findViewById(R.id.textViewTranslatedtext2);
        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(TvTranslatedText2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "English");
        menu.add(0, 1, 1, "Italian");

        if (v == tvTranslatedText) {
            wordClicked = "Hello";
        } else if (v == TvTranslatedText2) {
            wordClicked = "Bye";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("Hello")) {
            if (item.getItemId() == 0) {
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText.setText("Hello");

                return true;
            } else if (item.getItemId() == 1) {
                Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText.setText("Ciao");

                return true;
            }
        }


        if (wordClicked.equalsIgnoreCase("Bye")) {
            if (item.getItemId() == 0) {
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                TvTranslatedText2.setText("Bye");

                return true;
            } else if (item.getItemId() == 1) {
                Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                TvTranslatedText2.setText("Addio");

                return true;
            }

        }


        return super.onContextItemSelected(item);
    }
}