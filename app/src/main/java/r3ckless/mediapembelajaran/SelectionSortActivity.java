package r3ckless.mediapembelajaran;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectionSortActivity extends AppCompatActivity {

    private TextView[] txtnum;
    private int[]numbers = {9,5,2,1,15};
    private Handler handler = new Handler();
    int loop=0, n;
    Button btn_sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_sort);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btn_sort = (Button) findViewById(R.id.ssort);

        txtnum = new TextView[5];
        txtnum[0]= (TextView) findViewById(R.id.txtNum1);
        txtnum[1]= (TextView) findViewById(R.id.txtNum2);
        txtnum[2]= (TextView) findViewById(R.id.txtNum3);
        txtnum[3]= (TextView) findViewById(R.id.txtNum4);
        txtnum[4]= (TextView) findViewById(R.id.txtNum5);

        for (int i=0;i<numbers.length;i++){
            txtnum[i].setText(String.valueOf(numbers[i]));
        }
        btn_sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ssort();
            }
        });
    }

    public void ssort(){
        animate(0);
    }

    public void animate(final int m){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(Integer.valueOf((txtnum[m]).getText().toString())>Integer.valueOf((txtnum[n]).getText().toString())){
                    String temp = txtnum[m].getText().toString();
                    txtnum[m].setText(txtnum[n].getText().toString());
                    txtnum[n].setText(temp);
                }
                txtnum[m].setBackgroundResource(R.drawable.circle_blue);
                txtnum[n].setBackgroundResource(R.drawable.circle_blue);

                int i = m+1;
                if (i<numbers.length-1){
                    animate(i);
                }
            }
        },2000);
        txtnum[m].setBackgroundResource(R.drawable.circle_red);
        n = findMin(m+1);
        txtnum[n].setBackgroundResource(R.drawable.circle_red);
    }

    int findMin(int v){
        int min = v;
        for (int k = v+1; k<numbers.length; k++){
            if (Integer.valueOf(txtnum[k].getText().toString())<Integer.valueOf(txtnum[min].getText().toString())){
                min=k;
            }
        }
        return min;
    }
}
