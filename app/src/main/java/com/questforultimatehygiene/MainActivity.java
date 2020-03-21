package com.questforultimatehygiene;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ProgressBar;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.questforultimatehygiene.model.OnExperienceGain;
import com.questforultimatehygiene.model.OnLevelUp;
import com.questforultimatehygiene.model.Player;


public class MainActivity extends FragmentActivity {
    static public Player player;

    //Needed for Fragment View
    public ViewPager viewPager;
    public ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set up Fragment View
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setUpPagerAdapter();
        setUpShareButton();
        setUpExpDisplay();
    }

    private void setUpPagerAdapter(){
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void setUpShareButton(){
        final ImageButton shareButton = findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Wow! Schon "+ player.getLevel() +" Sauberkeits Punkte bei 'Quest for Ultimate Hygiene'");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
    }

    private void setUpExpDisplay(){
        //Load UI elements
        final TextView levelCounterView = findViewById(R.id.level_counter_view);
        final ProgressBar expBar = findViewById(R.id.exp_bar);

        //Set up subscribers to the player
        player = new Player(new OnLevelUp(){
            @Override
            public void onLevelUp(){
                //Behaviour when leveling up
                int currentLevel = Integer.parseInt( levelCounterView.getText().toString());
                currentLevel++;
                levelCounterView.setText( "" + currentLevel );
                showLevelUpPopUp();
            }
        }, new OnExperienceGain(){
            @Override
            public void onExperienceGain(){
                //Behaviour when gaining exp
                expBar.setProgress(player.getExp());
                expBar.setMax(player.getExpNeededTillLevelUp());
            }
        });
    }



    private void showLevelUpPopUp() {
        ViewGroup viewGroup = findViewById(android.R.id.content);

        View dialogView = LayoutInflater.from(this).inflate(R.layout.popup_level_up, viewGroup, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setView(dialogView);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    //For Fragment View -----
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
}
