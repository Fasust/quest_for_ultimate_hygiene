package com.questforultimatehygiene.model;
import android.net.Uri;

import java.lang.*;

/**
 * This class can represent a diverse range of quests.
 * For example: Washing hands, Clean home, Open Windows, Do laundry
 * @author Oscheibe
 */
public class Quest {
    private String name;
    private String description;
    private String mediaPath;
    private Uri mediaUri = null;

    public Quest(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Quest(String name, String description, String mediaPath){
        this.name = name;
        this.description = description;
        SetMediaPath(this.mediaPath);
    }

    /**
     * The path to a media file in the raw folder.
     * Example: "android.resource://packageName/VideoName.mp4
     * @param videoPath
     */
    public void SetMediaPath(String videoPath) {
        this.mediaPath = videoPath;
        mediaUri = Uri.parse(videoPath);
    }

    /**
     * The Uri to the media related to the quest.
     * @return MediaUri or Uri.EMPTY
     */
    public Uri GetMediaUri(){
        if(mediaUri == null){
            return Uri.EMPTY;
        }
        else
            return mediaUri;
    }


}
