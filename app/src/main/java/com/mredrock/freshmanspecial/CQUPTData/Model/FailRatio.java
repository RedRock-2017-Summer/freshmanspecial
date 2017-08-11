package com.mredrock.freshmanspecial.CQUPTData.Model;

import java.util.List;

/**
 * Created by Anriku on 2017/8/9.
 */

public class FailRatio {
    private String Status;
    private String Info;
    private String Version;
    private List<FailData> Data;

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

    public List<FailData> getData() {
        return Data;
    }

    public void setData(List<FailData> data) {
        Data = data;
    }

    public class FailData{
        private String course;
        private String major;
        private String college;
        private String ratio;

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

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
