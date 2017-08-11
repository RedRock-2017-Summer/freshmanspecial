package com.mredrock.freshmanspecial.CQUPTStrategy.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Anriku on 2017/8/11.
 */

public class Dormitory{
    private String Status;
    private String Info;
    private String Version;
    private List<DormitoryData> Data;

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

    public List<DormitoryData> getData() {
        return Data;
    }

    public void setData(List<DormitoryData> data) {
        Data = data;
    }

    public class DormitoryData implements Serializable{
        private String name;
        private String resume;
        private List<String> url;

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

        public List<String> getUrl() {
            return url;
        }

        public void setUrl(List<String> url) {
            this.url = url;
        }
    }
}
