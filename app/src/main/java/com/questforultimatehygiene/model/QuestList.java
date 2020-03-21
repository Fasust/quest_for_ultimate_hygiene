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
        int geheInsBadName = 0;
        int geheInsBadDescription = 0;
        geheInsBad = new Quest(geheInsBadName, geheInsBadDescription, 51);

        int timeBetweenActions = 5; // in seconds
        int haendeWaschenName = 0;
        int haendeWaschenDescription = 0;
        haendeWaschen = new TimedQuest(haendeWaschenName, haendeWaschenDescription, 50, timeBetweenActions);

        int obstWaschenName = 0;
        int obstWaschenDescription = 0;
        obstWaschen = new Quest(obstWaschenName, obstWaschenDescription, 100);
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
