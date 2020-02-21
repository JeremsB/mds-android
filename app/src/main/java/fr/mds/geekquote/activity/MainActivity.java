package fr.mds.geekquote.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import fr.mds.geekquote.R;
import fr.mds.geekquote.model.Quote;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "GeekQuoteTAG";

    private Button bt_main_add;
    private EditText et_main_quote;
    private ListView lv_main_list;

    private List<Quote> quotes = new ArrayList<Quote>();
    private ArrayAdapter<Quote> quoteArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_main_add = findViewById(R.id.bt_main_add);
        et_main_quote = findViewById(R.id.et_main_quote);

        quoteArrayAdapter = new ArrayAdapter<Quote>(this,
                R.layout.list_item,
                quotes
        );

        lv_main_list = (ListView) findViewById(R.id.listView);
        lv_main_list.setAdapter(quoteArrayAdapter);

        lv_main_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClicked" + position);

                Intent intent = new Intent(MainActivity.this, DetailQuoteActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });

        bt_main_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = et_main_quote.getText().toString();
                addQuote(content);
                et_main_quote.getText().clear();
                Log.d(TAG, "Button Clicked");
            }
        });

        for(int i = 0; i< 10; i++) {
            quotes.add(new Quote("Quoter number " + (i+1)));
        }
    }

    protected void addQuote(String strQuote) {
        Quote quote = new Quote(strQuote);
        quotes.add(quote);

        quoteArrayAdapter.notifyDataSetChanged();
    }
}
