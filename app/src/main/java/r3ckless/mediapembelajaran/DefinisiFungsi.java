package r3ckless.mediapembelajaran;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class DefinisiFungsi extends AppCompatActivity {

//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return false;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definisi_fungsi);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //pemanggilan nilai ukuran font dari Shared Preference
        TextView myTextView = (TextView) findViewById(R.id.contentViewDefFungsi);
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("fSize", Context.MODE_PRIVATE);
        float myTsize = sharedPref.getFloat("fSize", -1);
        myTextView.setTextSize(TypedValue.COMPLEX_UNIT_PT,myTsize);

        FloatingActionButton myFabNext = (FloatingActionButton) findViewById(R.id.fabNext_AboutFunc);
        myFabNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(DefinisiFungsi.this, PenggunaanFungsi.class);
                DefinisiFungsi.this.startActivity(i);
            }
        });

        FloatingActionButton myFabPrev = (FloatingActionButton) findViewById(R.id.fabPrev_AboutFunc);
        myFabPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(DefinisiFungsi.this, PenggunaanProsedur.class);
                DefinisiFungsi.this.startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mysearch, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
//        SearchView mySearch = (SearchView) findViewById(R.id.action_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                highlightString(newText);
                return false;
            }

        });
        return true;
    }

    private void highlightString(String input) {
        //Get the text from text view and create a spannable string
        TextView myTextView = (TextView) findViewById(R.id.contentViewDefFungsi);
        SpannableString spannableString = new SpannableString(myTextView.getText());

        //Get the previous spans and remove them
        ForegroundColorSpan[] foregroundSpans = spannableString.getSpans(0, spannableString.length(), ForegroundColorSpan.class);

        for (ForegroundColorSpan span: foregroundSpans) {
            spannableString.removeSpan(span);
        }

        //Search for all occurrences of the keyword in the string
        int indexOfKeyword = spannableString.toString().indexOf(input);

        while (indexOfKeyword > 0) {
            //Create a background color span on the keyword
            spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), indexOfKeyword, indexOfKeyword + input.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            //Get the next index of the keyword
            indexOfKeyword = spannableString.toString().indexOf(input, indexOfKeyword + input.length());
        }

        //Set the final text on TextView
        myTextView.setText(spannableString);
    }
}
