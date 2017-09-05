package r3ckless.mediapembelajaran;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class InsertionSortActivity extends AppCompatActivity {

    private TextView[] txtnum;
    private int[]numbers = {8,5,4,1,15};
    private Handler handler = new Handler();
    int loop=0, n;
    Button btn_sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion_sort);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btn_sort = (Button) findViewById(R.id.insort);

        txtnum = new TextView[5];
        txtnum[0]= (TextView) findViewById(R.id.txtNum1);
        txtnum[1]= (TextView) findViewById(R.id.txtNum2);
        txtnum[2]= (TextView) findViewById(R.id.txtNum3);
        txtnum[3]= (TextView) findViewById(R.id.txtNum4);
        txtnum[4]= (TextView) findViewById(R.id.txtNum5);

        //inisialisasi angka di array kedalam text
        for (int i=0;i<numbers.length;i++){
            txtnum[i].setText(String.valueOf(numbers[i]));
        }

        //button mulai sorting
        btn_sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //proses pengerjaan insertion sort
                btn_sort.setEnabled(false);

                Timer buttonTimer = new Timer();
                buttonTimer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                btn_sort.setEnabled(true);
                            }
                        });
                    }
                }, 8000);
                insort();
            }
        });
    }

    //pemanggilan animasi dari insertionSort
    public void insort(){
        animate(1);
    }

    //proses pembuatan animasi dari insertion sort
    public void animate(final int m){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(m!=n){
                    String temp = txtnum[m].getText().toString();
                    for (int k=m;k>n;k--){
                        txtnum[k].setText(txtnum[k-1].getText().toString());
                    }
                    txtnum[n].setText(temp);
                }
                txtnum[m].setBackgroundResource(R.drawable.circle_blue);
                txtnum[n].setBackgroundResource(R.drawable.circle_blue);

                int i = m+1;
                if (i<numbers.length){
                    animate(i);
                }
            }
        },2000);
        txtnum[m].setBackgroundResource(R.drawable.circle_red);
        n = findMin(m);
        txtnum[n].setBackgroundResource(R.drawable.circle_red);
    }

    //proses pencarian indeks terkecil
    int findMin(int v){
        int min = v;
        for (int k = 0; k<=min; k++){
            if (Integer.valueOf(txtnum[k].getText().toString())>Integer.valueOf(txtnum[min].getText().toString())){
                min=k;
            }
        }
        return min;
    }
}
