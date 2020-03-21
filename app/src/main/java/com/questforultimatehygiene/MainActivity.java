package com.questforultimatehygiene;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.questforultimatehygiene.model.OnExperienceGain;
import com.questforultimatehygiene.model.OnLevelUp;
import com.questforultimatehygiene.model.Player;

public class MainActivity extends FragmentActivity {
    static public Player player;

    public ViewPager viewPager;
    public ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
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
                showLevelUpPopUp();
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

    private void showLevelUpPopUp() {
        ViewGroup viewGroup = findViewById(android.R.id.content);

        View dialogView = LayoutInflater.from(this).inflate(R.layout.popup_level_up, viewGroup, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(dialogView);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
