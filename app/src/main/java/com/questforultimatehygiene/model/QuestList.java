package com.questforultimatehygiene.model;

/**
 * Singleton for a list of Quests. Access via getInstance()
 * Quests so far: GeheInsBad, HaendeWaschen, ObstWaschen
 */
public class QuestList {
    private static QuestList questList_instance = null;

    private Quest geheInsBad;
    private TimedQuest haendeWaschen;
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
        geheInsBad = new Quest("Gehe ins Bad", "", 50);
        int timeBetweenActions = 5; // in seconds
        haendeWaschen = new TimedQuest("Hände Waschen", "", 50, timeBetweenActions);
        obstWaschen = new Quest("Obst Waschen", "", 100);
    }

    public Quest GetGeheInsBad(){
        if(questList_instance == null)
            return null;
        return geheInsBad;
    }

    public TimedQuest GetHaendeWaschen(){
        if(questList_instance == null)
            return null;
        return haendeWaschen;
    }

    public Quest GetObstWaschen(){
        if(questList_instance == null)
            return null;
        return obstWaschen;
    }

}
