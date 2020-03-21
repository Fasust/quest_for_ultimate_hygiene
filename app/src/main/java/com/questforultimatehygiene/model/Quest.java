package com.questforultimatehygiene.model;

import android.net.Uri;

import com.questforultimatehygiene.R;

/**
 * This class can represent a diverse range of quests.
 * For example: Washing hands, Cleaning home, Open Windows, Do laundry
 * @author Oscheibe
 */
public class Quest {
    private int title = R.string.hello_blank_fragment;
    private int content = R.string.hello_blank_fragment;
    private String mediaPath;
    private Uri mediaUri = null;
    private int experience;

    public Quest(int title, int content, int experience){
        this.title = title;
        this.content = content;
        this.experience = experience;
    }

    public Quest(int title, int content, int experience, String mediaPath){
        this.title = title;
        this.content = content;
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

    public int getContent() {
        return content;
    }

    public int getTitle() {
        return title;
    }
}
