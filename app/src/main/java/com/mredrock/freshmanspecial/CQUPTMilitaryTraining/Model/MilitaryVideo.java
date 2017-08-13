package com.mredrock.freshmanspecial.CQUPTMilitaryTraining.Model;

import java.util.List;

/**
 * Created by Anriku on 2017/8/12.
 */

public class MilitaryVideo {

    private String Status;
    private String Info;
    private String Version;
    private List<MilitaryVideoData> Data;

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

    public List<MilitaryVideoData> getData() {
        return Data;
    }

    public void setData(List<MilitaryVideoData> data) {
        Data = data;
    }

    public class MilitaryVideoData{
        private String title;
        private String url;
        private String cover;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }
    }
}
