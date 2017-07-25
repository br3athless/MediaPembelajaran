package r3ckless.mediapembelajaran;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.textSize;
import static r3ckless.mediapembelajaran.R.id.lvExp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MateriActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        //set Toolbar ke Activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // get the listview
        expListView = (ExpandableListView) findViewById(lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getApplicationContext(), listDataHeader, listDataChild) {

        };

        // setting list adapter
        expListView.setAdapter(listAdapter);

        //Listener untuk Expandable ListView
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                //Pengantar Algoritma
                if (groupPosition == 0){
                    // Create a switch that switches on the specific child position.
                    switch (childPosition){
                        case 0:
                            // Go to child #0 specific class (1.1 Definisi Algoritma).
                        Intent child0Intent = new Intent(MateriActivity.this, DefinisiAlgo.class);
                        startActivity(child0Intent);
                            break;
                        //1.2
                        case 1:
                            // Go to child #1 specific class (1.2 Sejarah Algoritma).
                        Intent child1Intent = new Intent(MateriActivity.this, SejarahAlgo.class);
                        startActivity(child1Intent);
                            break;
                    }
                }
                //Struktur Dasar Algoritma
                else if (groupPosition == 1){
                    // Create a switch that switches on the specific child position.
                    switch(childPosition){
                        case 0:
                            // Go to child #0 specific class (2.1 Struktur Urut).
                        Intent child0Intent = new Intent(MateriActivity.this, StrukturUrut.class);
                        startActivity(child0Intent);
                            break;
                        //1.2
                        case 1:
                            // Go to child #1 specific class (2.2 Struktur Keputusan).
                        Intent child1Intent = new Intent(MateriActivity.this, StrukturKeputusan.class);
                        startActivity(child1Intent);
                            break;
                        //2.1
                        case 2:
                            // Go to child #2 specific class (2.3 Struktur Perulangan).
                        Intent child2Intent = new Intent(MateriActivity.this, StrukturPerulangan.class);
                        startActivity(child2Intent);
                            break;
                    }
                }
                //Notasi Algoritma
                else if(groupPosition == 2){
                    // Create a switch that switches on the specific child position.
                    switch(childPosition){
                        case 0:
                            // Go to child #0 specific class (3.1 Uraian Deskriptif).

                        Intent child0Intent = new Intent(MateriActivity.this, UraianDeskriptif.class);
                        startActivity(child0Intent);
                            break;
                        //1.2
                        case 1:
                            // Go to child #1 specific class (3.2 Flowchart).
                        Intent child1Intent = new Intent(MateriActivity.this, Flowchart.class);
                        startActivity(child1Intent);
                            break;
                        //2.1
                        case 2:
                            // Go to child #2 specific class (3.3 Pseudocode).
                        Intent child2Intent = new Intent(MateriActivity.this, Pseudocode.class);
                        startActivity(child2Intent);
                            break;
                    }
                }
                //Tipe Data dan Operator
                else if (groupPosition == 3 ){
                    // Create a switch that switches on the specific child position.
                    switch(childPosition) {
                        //1.1
                        case 0:
                            // Go to child #0 specific class (4.1 Tipe Data).

                        Intent child0Intent = new Intent(MateriActivity.this, TipeData.class);
                        startActivity(child0Intent);
                            break;
                        //1.2
                        case 1:
                            // Go to child #1 specific class (4.2 Operator).
                        Intent child1Intent = new Intent(MateriActivity.this, Operator.class);
                        startActivity(child1Intent);
                            break;
                        }
                }
                //Prosedur
                else if (groupPosition == 4) {
                    // Create a switch that switches on the specific child position.
                    switch (childPosition) {
                        //5.1
                        case 0:
                            // Go to child #0 specific class (5.1 Tentang Prosedur).
                        Intent child0Intent = new Intent(MateriActivity.this, TtgProsedur.class);
                        startActivity(child0Intent);
                            break;
                        //5.2
                        case 1:
                            // Go to child #1 specific class (5.2 Penggunaan Prosedur).
                        Intent child1Intent = new Intent(MateriActivity.this, PenggunaanProsedur.class);
                        startActivity(child1Intent);
                            break;
                    }
                }
                //Fungsi
                else if(groupPosition == 5){
                    // Create a switch that switches on the specific child position.
                    switch(childPosition) {
                        //6.1
                        case 0:
                            // Go to child #0 specific class (6.1 Definisi Fungsi).

                        Intent child0Intent = new Intent(MateriActivity.this, DefinisiFungsi.class);
                        startActivity(child0Intent);
                            break;
                        //6.2
                        case 1:
                            // Go to child #1 specific class (6.2 Penggunaan Fungsi).
                        Intent child1Intent = new Intent(MateriActivity.this, PenggunaanFungsi.class);
                        startActivity(child1Intent);
                            break;
                    }
                }
                return false;
            }
        });

    }

    /*
         * Preparing the list data
         */
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding header data
        listDataHeader.add("1. Pengantar Algoritma");
        listDataHeader.add("2. Struktur Dasar Algoritma");
        listDataHeader.add("3. Notasi Algoritma");
        listDataHeader.add("4. Tipe Data dan Operator");
        listDataHeader.add("5. Prosedur");
        listDataHeader.add("6. Fungsi");

        // Adding child data
        List<String> pengantarAlgoritma = new ArrayList<>();
        pengantarAlgoritma.add("1.1 Definisi Algoritma");
        pengantarAlgoritma.add("1.2 Sejarah Algoritma");

        List<String> strukDas = new ArrayList<>();
        strukDas.add("2.1 Struktur Urut");
        strukDas.add("2.2 Struktur Keputusan");
        strukDas.add("2.3 Struktur Perulangan");

        List<String> notasiAlgo  = new ArrayList<>();
        notasiAlgo.add("3.1 Uraian Deskriptif");
        notasiAlgo.add("3.2 Flowchart");
        notasiAlgo.add("3.3 Pseudocode");

        List<String> typeOperator = new ArrayList<>();
        typeOperator.add("4.1 Tipe Data");
        typeOperator.add("4.2 Operator");

        List<String> prosedur = new ArrayList<>();
        prosedur.add("5.1 Tentang Prosedur");
        prosedur.add("5.2 Penggunan Prosedur");

        List<String> fungsi = new ArrayList<>();
        fungsi.add("6.1 Definisi Fungsi");
        fungsi.add("6.2 Penggunaan Fungsi");

        //input data header dan child
        listDataChild.put(listDataHeader.get(0), pengantarAlgoritma); // Header,Child data
        listDataChild.put(listDataHeader.get(1), strukDas);
        listDataChild.put(listDataHeader.get(2), notasiAlgo);
        listDataChild.put(listDataHeader.get(3), typeOperator);
        listDataChild.put(listDataHeader.get(4), prosedur);
        listDataChild.put(listDataHeader.get(5), fungsi);

    }

    //set Menu Settings
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.code, menu);
//        return true;
//    }
//    //set Menu Settings
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_tentang) {
//            loadFragment(new AboutDialogFragment());
//            return true;
//        }else if (id == R.id.action_setting){
//            startActivity(new Intent(MateriActivity.this, Preferences.class));
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    //set back button
    @Override
    public void onBackPressed() {
       onNavigateUp();
    }

//    //loadDialogFragment
//    private void loadFragment(Fragment fragment) {
//// create a FragmentManager
//        FragmentManager fm = getFragmentManager();
//// show dialog fragment
//        AboutDialogFragment Dfragment = new AboutDialogFragment();
//        Dfragment.setRetainInstance(true);
//        Dfragment.show(fm, "Dfragment");
//    }

}
