package com.mredrock.freshmanspecial.CQUPTStrategy.Model;

import java.util.List;

/**
 * Created by Anriku on 2017/8/11.
 */

public class Environment {
    private String Status;
    private String Info;
    private String Version;
    private List<EnvironmentData> Data;

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

    public List<EnvironmentData> getData() {
        return Data;
    }

    public void setData(List<EnvironmentData> data) {
        Data = data;
    }

    public class EnvironmentData{
        private String title;
        private String content;
        private List<String> url;

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

        public List<String> getUrl() {
            return url;
        }

        public void setUrl(List<String> url) {
            this.url = url;
        }
    }

}
