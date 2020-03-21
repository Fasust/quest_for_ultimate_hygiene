package com.questforultimatehygiene;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.questforultimatehygiene.model.OnExperienceGain;
import com.questforultimatehygiene.model.OnLevelUp;
import com.questforultimatehygiene.model.Player;


public class MainActivity extends FragmentActivity implements View.OnClickListener {
    static public Player player;

    public ViewPager viewPager;
    public ViewPagerAdapter viewPagerAdapter;
    public ImageButton imageButton2;
    public TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        imageButton2 = (ImageButton)findViewById(R.id.imageButton2);
        textView2 = (TextView)findViewById(R.id.textView2);
        imageButton2.setOnClickListener(this);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        setPagerAdapter();

        final ProgressBar expBar = findViewById(R.id.progressBar3);
        final TextView levelCounterView = findViewById(R.id.level_counter);

        player = new Player(new OnLevelUp(){
            @Override
            public void onLevelUp(){
                int currentLevel = Integer.parseInt( levelCounterView.getText().toString());
                currentLevel++;
                levelCounterView.setText( "" + currentLevel );
            }
        }, new OnExperienceGain(){
            @Override
            public void onExperienceGain(){
                expBar.setProgress(player.getExp());
                expBar.setMax(player.getExpNeededTillLevelUp());
            }
        });
    }

    private void setPagerAdapter(){
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String points = textView2.getText().toString();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Wow! Schon "+points+" Klopapierrollen bei 'Quest for Ultimate Hygiene'");
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}
