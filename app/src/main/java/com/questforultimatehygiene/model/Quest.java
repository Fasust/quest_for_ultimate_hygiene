package com.questforultimatehygiene.model;
import android.net.Uri;

import java.lang.*;

/**
 * This class can represent a diverse range of quests.
 * For example: Washing hands, Cleaning home, Open Windows, Do laundry
 * @author Oscheibe
 */
public class Quest {
    private String name;
    private String description;
    private String mediaPath;
    private Uri mediaUri = null;
    private int experience;

    public Quest(String name, String description, int experience){
        this.name = name;
        this.description = description;
        this.experience = experience;
    }

    public Quest(String name, String description, int experience, String mediaPath){
        this.name = name;
        this.description = description;
        this.experience = experience;
        setMediaPath(this.mediaPath);
    }

    /**
     * The path to a media file in the raw folder.
     * Example: "android.resource://packageName/VideoName.mp4
     * @param videoPath
     */
    public void setMediaPath(String videoPath) {
        this.mediaPath = videoPath;
        mediaUri = Uri.parse(videoPath);
    }

    /**
     * The Uri to the media related to the quest.
     * @return MediaUri or Uri.EMPTY
     */
    public Uri getMediaUri(){
        if(mediaUri == null){
            return Uri.EMPTY;
        }
        else
            return mediaUri;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }
}
