package r3ckless.mediapembelajaran;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by r3ckless on 5/17/2017.
 */

public class PascalFragment extends Fragment {

    //inisialisasi ListView dan Data Item ListView
    ListView lvItem;
    String[] contohcode = new String[]{
            "Hello World",
            "Mencari Bilangan Genap",
            "Konversi waktu ke detik" ,
            "Penjumlahan deret",
            //"Under Construction",
    };
    Intent i;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_pascal, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Bahasa Pascal");

       //set DataListView ke Adapter
        lvItem = (ListView) view.findViewById(R.id.ListViewPascal);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.list_item, R.id.listItem, contohcode);

        //set data di dalam listview
        lvItem.setAdapter(adapter);


        //set onclicklistener pada ItemList
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //memanggil set on Item ClickListener untuk Listview, jadi jika salah satu item list view diklik akan
                //akan bereaksi menampilkan toast atau aksi lainya.
                //Step 4
                switch (position){
                    case 0:
                         i = new Intent(getActivity(), HelloWorldPascal.class);
                        PascalFragment.this.startActivity(i);
                        //Toast.makeText(getActivity(), "Memilih : 1", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        i = new Intent(getActivity(), BilanganGenapPas.class);
                        PascalFragment.this.startActivity(i);
                        //Toast.makeText(getActivity(), "Memilih : 2", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        i = new Intent(getActivity(), KonversiDetikPas.class);
                        PascalFragment.this.startActivity(i);
                        //Toast.makeText(getActivity(), "Memilih : 3", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        i = new Intent(getActivity(), JumlahDeretPas.class);
                        PascalFragment.this.startActivity(i);
                        //Toast.makeText(getActivity(), "Memilih : 4", Toast.LENGTH_LONG).show();
                        break;
//                    case 4:
//                        Toast.makeText(getActivity(), "Memilih : 5", Toast.LENGTH_LONG).show();
//                        break;
                }
            }
        });

    }
}
