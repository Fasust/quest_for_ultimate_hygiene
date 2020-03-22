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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.questforultimatehygiene.model.OnExperienceGain;
import com.questforultimatehygiene.model.OnLevelUp;
import com.questforultimatehygiene.model.Player;


public class MainActivity extends FragmentActivity implements View.OnClickListener {
    static final String LEVEL_INTENT_ID = "LEVEL_INTENT_ID";
    static final String EXP_INTENT_ID = "EXP_INTENT_ID";
    static final String EXP_NEEDED_INTENT_ID = "EXP_NEEDED_INTENT_ID";

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
        setUpLeaderBoardButton();
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
        shareButton.setOnClickListener(this);
    }

    private void setUpLeaderBoardButton(){
        final ImageView pointView = findViewById(R.id.points_image_button);
        pointView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Leaderboard.class);

                myIntent.putExtra(LEVEL_INTENT_ID, player.getLevel());
                myIntent.putExtra(EXP_INTENT_ID, player.getExp());
                myIntent.putExtra(EXP_NEEDED_INTENT_ID, player.getExpNeededTillLevelUp());

                MainActivity.this.startActivity(myIntent);
            }
        });
    }

    public void onClick(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Wow! Schon "+ player.getLevel() +" Sauberkeits Punkte bei 'Quest for Ultimate Hygiene'");
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
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
                levelCounterView.setText( "" + player.getLevel());
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
