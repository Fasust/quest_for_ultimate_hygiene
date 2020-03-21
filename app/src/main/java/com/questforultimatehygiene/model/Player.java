package com.questforultimatehygiene.model;

/**
 * Level Incline relative to total EXP
 *
 * Level   XP      Difference
 * 1       0       -
 * 2       100     100
 * 3       300     200
 * 4       600     300
 * 5       1000    400
 * ...
 */
public class Player {
    static final int EXP_INCLINE = 100; //Amount that the expNeededTillLevelUp increases ever level
    private final OnLevelUp onLevelUp; //called eminently after level up
    private final OnExperienceGain onExperienceGain; //called eminently on OnExperienceGain

    private int exp = 0; //Current exp. Starts at 0 every level
    private int level = 0; //Current level. Goes up when adding exp

    //How many total exp are needed to advance to the next level. Increases every level
    private int expNeededTillLevelUp = 100;

    public Player(OnLevelUp onLevelUp, OnExperienceGain onExperienceGain) {
        this.onLevelUp = onLevelUp;
        this.onExperienceGain = onExperienceGain;
    }

    public void addExperience(int amount){
        if(amount + exp > expNeededTillLevelUp){
            levelUp((exp + amount) - expNeededTillLevelUp);
        }else{
            exp += amount;
        }
        onExperienceGain.onExperienceGain();
    }

    private void levelUp(int accessExp){
        exp = accessExp;
        level++;
        expNeededTillLevelUp += EXP_INCLINE;
        onLevelUp.onLevelUp();
    }

    //Getters ----
    public int getExp() {
        return exp;
    }

    public int getLevel() {
        return level;
    }

    public int getExpNeededTillLevelUp() {
        return expNeededTillLevelUp;
    }
}