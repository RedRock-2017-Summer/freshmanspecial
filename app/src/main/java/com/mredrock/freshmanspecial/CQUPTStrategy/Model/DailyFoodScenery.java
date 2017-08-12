package com.mredrock.freshmanspecial.CQUPTStrategy.Model;

import java.util.List;

/**
 * Created by Anriku on 2017/8/12.
 */

public class DailyFoodScenery {
    private String Status;
    private String Info;
    private String Version;
    private List<LifeInNearData> Data;

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

    public List<LifeInNearData> getData() {
        return Data;
    }

    public void setData(List<LifeInNearData> data) {
        Data = data;
    }

    public class LifeInNearData{
        private String name;
        private String location;
        private String resume;
        private List<String> url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
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
