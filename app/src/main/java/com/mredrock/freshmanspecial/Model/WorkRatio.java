package com.mredrock.freshmanspecial.Model;

import java.util.List;

/**
 * Created by Anriku on 2017/8/9.
 */

public class WorkRatio {
    private String Status;
    private String Info;
    private String Version;
    private List<WorkData> Data;

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

    public List<WorkData> getData() {
        return Data;
    }

    public void setData(List<WorkData> data) {
        Data = data;
    }

    public class WorkData{

        private String college;
        private String ratio;

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public String getRatio() {
            return ratio;
        }

        public void setRatio(String ratio) {
            this.ratio = ratio;
        }
    }
}
