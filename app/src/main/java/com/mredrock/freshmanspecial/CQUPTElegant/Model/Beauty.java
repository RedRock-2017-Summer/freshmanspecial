package com.mredrock.freshmanspecial.CQUPTElegant.Model;

import java.util.List;

/**
 * Created by Anriku on 2017/8/12.
 */

public class Beauty {
    private String Status;
    private String Info;
    private String Version;
    private List<BeautyData> Data;

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

    public List<BeautyData> getData() {
        return Data;
    }

    public void setData(List<BeautyData> data) {
        Data = data;
    }

    public class BeautyData {
        private String title;
        private String content;
        private String url;


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
