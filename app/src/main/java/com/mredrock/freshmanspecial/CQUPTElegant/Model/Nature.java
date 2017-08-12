package com.mredrock.freshmanspecial.CQUPTElegant.Model;

import java.util.List;

/**
 * Created by Anriku on 2017/8/12.
 */

public class Nature {
    private String Status;
    private String Info;
    private String Version;
    private List<NatureData> Data;

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

    public List<NatureData> getData() {
        return Data;
    }

    public void setData(List<NatureData> data) {
        Data = data;
    }

    public class NatureData{
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
