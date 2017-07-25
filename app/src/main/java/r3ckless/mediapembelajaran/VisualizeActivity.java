package r3ckless.mediapembelajaran;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class VisualizeActivity extends AppCompatActivity {
    //inisialisasi ListView dan Data Item ListView
    ListView lvItem;
    String[] listAnimated = new String[]{
            "Visualisasi Bubble Sort",
            "Visualisasi Selection Sort",
            "Visualisasi Insertion Sort"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualize);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //set DataListView ke Adapter
        lvItem = (ListView) findViewById(R.id.lvSort);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.listItem, listAnimated);

        //set data di dalam listview
        lvItem.setAdapter(adapter);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch(position){
                    case 0:
                        Intent pos0Intent = new Intent(VisualizeActivity.this, BubbleSortActivity.class);
                        startActivity(pos0Intent);
                        break;
                    case 1:
                        Intent pos1Intent = new Intent(VisualizeActivity.this, SelectionSortActivity.class);
                        startActivity(pos1Intent);
                        break;
                    case 2:
                        Intent pos2Intent = new Intent(VisualizeActivity.this, InsertionSortActivity.class);
                        startActivity(pos2Intent);
                        break;
                }
            }
        });

    }

    //set back button
    @Override
    public void onBackPressed() {
        onNavigateUp();
    }

}
