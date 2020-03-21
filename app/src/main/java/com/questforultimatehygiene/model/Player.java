package com.questforultimatehygiene.model;

/**
 * Level   XP      Difference
 * 1       0       -
 * 2       100     100
 * 3       300     200
 * 4       600     300
 * 5       1000    400
 * ...
 */
public class Player {
    static final int EXP_INCLINE = 100;
    private final OnLevelUp onLevelUp;
    
    private int exp = 0;
    private int level = 0;
    private int expNeededTillLevelUp = 100;

    public Player(OnLevelUp onLevelUp) {
        this.onLevelUp = onLevelUp;
    }

    public void addExperience(int amount){
        if(amount + exp > expNeededTillLevelUp){
            levelUp((exp + amount) - expNeededTillLevelUp);
        }else{
            exp += amount;
        }
    }
    private void levelUp(int accessExp){
        exp = accessExp;
        level++;
        expNeededTillLevelUp = expNeededTillLevelUp + EXP_INCLINE;
        onLevelUp.onLevelUp();
    }

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