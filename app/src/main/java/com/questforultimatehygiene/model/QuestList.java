package com.questforultimatehygiene.model;

import com.questforultimatehygiene.R;

/**
 * Singleton for a list of Quests. Access via getInstance()
 * Quests so far: GeheInsBad, HaendeWaschen, ObstWaschen
 */
public class QuestList {
    private static QuestList questList_instance = null;

    private Quest geheInsBad;
    private TimedQuest handwashing;
    private Quest obstWaschen;

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
        int geheInsBadName = 0;
        int geheInsBadDescription = 0;
        geheInsBad = new Quest(geheInsBadName, geheInsBadDescription, 51);

        int timeBetweenActions = 5; // in seconds
        int handwashingName = R.string.quest_handwashing_title;
        int handwashingDescription = R.string.quest_handwashing_content;
        handwashing = new TimedQuest(handwashingName, handwashingDescription, 51, timeBetweenActions);

        int obstWaschenName = 0;
        int obstWaschenDescription = 0;
        obstWaschen = new Quest(obstWaschenName, obstWaschenDescription, 101);
    }

    public Quest GetGeheInsBad(){
        if(questList_instance == null)
            return null;
        return geheInsBad;
    }

    public TimedQuest GetHandwashing(){
        if(questList_instance == null)
            return null;
        return handwashing;
    }

    public Quest GetObstWaschen(){
        if(questList_instance == null)
            return null;
        return obstWaschen;
    }

}
