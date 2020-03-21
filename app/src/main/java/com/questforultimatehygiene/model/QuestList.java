package com.questforultimatehygiene.model;

import com.questforultimatehygiene.R;

/**
 * Singleton for a list of Quests. Access via getInstance()
 * Quests so far: GeheInsBad, HaendeWaschen, ObstWaschen
 */
public class QuestList {
    private static QuestList questList_instance = null;

    int basicExperiencePoints = 51;
    private TimedQuest handwashing;
    private Quest groceryShopping;
    private Quest sneezing;
    private  Quest welcomeHome;

    /**
     * Is called when the first instance of the QuestList is called
     */
    private QuestList() {
        InitiateQuestList();
    }

    public static QuestList getInstance(){
     if(questList_instance == null)
         questList_instance = new QuestList();
     return questList_instance;
    }

    private void InitiateQuestList(){
        // public Quest(String name, String description, int experience, String mediaPath){
        /*
        int geheInsBadName = R.string.hello_blank_fragment;
        int geheInsBadDescription = R.string.hello_blank_fragment;
        geheInsBad = new Quest(geheInsBadName, geheInsBadDescription, 51);
        int obstWaschenName = 0;
        int obstWaschenDescription = 0;
        obstWaschen = new Quest(obstWaschenName, obstWaschenDescription, 101);
        */
        int timeBetweenActions = 5; // in seconds
        int handwashingTitle = R.string.quest_handwashing_title;
        int handwashingContent = R.string.quest_handwashing_content;
        handwashing = new TimedQuest(handwashingTitle, handwashingContent, basicExperiencePoints, timeBetweenActions);

        int groceryShoppingTitle = R.string.quest_grocery_shopping_title;
        int groceryShoppingContent = R.string.quest_grocery_shopping_content;
        groceryShopping = new Quest(groceryShoppingTitle, groceryShoppingContent, basicExperiencePoints);

        int sneezingTitle = R.string.quest_sneezing_title;
        int sneezingContent = R.string.quest_sneezing_content;
        sneezing = new Quest(sneezingTitle, sneezingContent, basicExperiencePoints);

        int welcomeHomeTitle = R.string.quest_welcome_home_title;
        int welcomeHomeContent = R.string.quest_welcome_home_content;
        welcomeHome = new Quest(welcomeHomeTitle, welcomeHomeContent, basicExperiencePoints);

    }

    public TimedQuest GetHandwashing(){
        if(questList_instance == null)
            return null;
        return handwashing;
    }

    public Quest GetSneezing(){
        if(questList_instance == null)
            return null;
        return sneezing;
    }

    public Quest GetWelcomeHome(){
        if(questList_instance == null)
            return null;
        return welcomeHome;
    }


    public Quest GetGroceryShopping(){
        if(questList_instance == null)
            return null;
        return groceryShopping;
    }


}
