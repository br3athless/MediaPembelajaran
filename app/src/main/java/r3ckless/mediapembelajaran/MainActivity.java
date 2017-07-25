package r3ckless.mediapembelajaran;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Animation alphaAnimate;
    Button btn_Materi, btn_Code, btn_Vid, btn_Visual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.AppBarTitle);

        btn_Materi = (Button) findViewById(R.id.btnMateri);
        btn_Code = (Button) findViewById(R.id.btnCode);
        btn_Vid = (Button) findViewById(R.id.btnVideo);
        btn_Visual = (Button) findViewById(R.id.btnVisual);
        alphaAnimate = AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha);

        //OnClickListener Button Materi
        btn_Materi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaAnimate.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent i = new Intent(MainActivity.this, MateriActivity.class);
                        MainActivity.this.startActivity(i);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                btn_Materi.startAnimation(alphaAnimate);
            }
        });


        //onClickListener Button Source Code
        btn_Code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaAnimate.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent i = new Intent(MainActivity.this, CodeActivity.class);
                        MainActivity.this.startActivity(i);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                btn_Code.startAnimation(alphaAnimate);
            }
        });

        //onClickListener Button Video
        btn_Vid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaAnimate.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent i = new Intent(MainActivity.this, Video.class);
                        MainActivity.this.startActivity(i);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                btn_Vid.startAnimation(alphaAnimate);
            }
        });

        //onClickListener Button Visual
        btn_Visual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaAnimate.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent i = new Intent(MainActivity.this, VisualizeActivity.class);
                        MainActivity.this.startActivity(i);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                btn_Visual.startAnimation(alphaAnimate);
            }
        });

    } //end onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.code, menu);
        return true;
    }
    //set Menu Settings
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_tentang) {
            loadFragment(new AboutDialogFragment());
            return true;
        }else if (id == R.id.action_setting){
            startActivity(new Intent(MainActivity.this, Preferences.class));
        }

        return super.onOptionsItemSelected(item);
    }

    //loadDialogFragment
    private void loadFragment(Fragment fragment) {
// create a FragmentManager
        FragmentManager fm = getFragmentManager();
// show dialog fragment
        AboutDialogFragment Dfragment = new AboutDialogFragment();
        Dfragment.setRetainInstance(true);
        Dfragment.show(fm, "Dfragment");
    }

} //end MainActivity
