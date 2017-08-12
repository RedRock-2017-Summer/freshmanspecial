package com.mredrock.freshmanspecial.CQUPTElegant.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Anriku on 2017/8/12.
 */

public class ExcellenceStu {
    private String Status;
    private String Info;
    private String Version;
    private List<ExcellenceStuData> Data;

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

    public List<ExcellenceStuData> getData() {
        return Data;
    }

    public void setData(List<ExcellenceStuData> data) {
        Data = data;
    }

    public class ExcellenceStuData implements Serializable{
        private String name;
        private String resume;
        private String url;
        private String motto;

        public String getMotto() {
            return motto;
        }

        public void setMotto(String motto) {
            this.motto = motto;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getResume() {
            return resume;
        }

        public void setResume(String resume) {
            this.resume = resume;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
