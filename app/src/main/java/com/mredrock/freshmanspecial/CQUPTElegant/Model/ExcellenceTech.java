package com.mredrock.freshmanspecial.CQUPTElegant.Model;

import java.util.List;

/**
 * Created by Anriku on 2017/8/12.
 */

public class ExcellenceTech {
    private String Status;
    private String Info;
    private String Version;
    private List<ExcellenceTechData> Data;

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

    public List<ExcellenceTechData> getData() {
        return Data;
    }

    public void setData(List<ExcellenceTechData> data) {
        Data = data;
    }

    public class ExcellenceTechData{
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
