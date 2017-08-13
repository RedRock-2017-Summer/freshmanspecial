package com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Model;

import java.util.List;

/**
 * Created by Anriku on 2017/8/12.
 */

public class MilitaryPhoto {
    private String Status;
    private String Info;
    private String Version;
    private MilitaryPhotoData Data;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public MilitaryPhotoData getData() {
        return Data;
    }

    public void setData(MilitaryPhotoData data) {
        Data = data;
    }

    public class MilitaryPhotoData {

        private List<String> title;
        private List<String> url;

        public List<String> getTitle() {
            return title;
        }

        public void setTitle(List<String> title) {
            this.title = title;
        }

        public List<String> getUrl() {
            return url;
        }

        public void setUrl(List<String> url) {
            this.url = url;
        }
    }
}
