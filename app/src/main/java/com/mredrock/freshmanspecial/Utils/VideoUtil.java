package com.mredrock.freshmanspecial.Utils;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

/**
 * Created by Anriku on 2017/8/12.
 */

public class VideoUtil {
    public static byte[] getVideoThumbnail(String url){
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(url,new HashMap());
        bitmap = retriever.getFrameAtTime();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (bitmap != null){
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos);
        }
        return baos.toByteArray();
    }
}
