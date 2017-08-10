package com.mredrock.freshmanspecial.Model;

import java.util.List;

public class SexRatio {
        private String Status;
        private String Info;
        private String Version;
        private List<SexData> Data;


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

        public List<SexData> getData() {
            return Data;
        }

        public void setData(List<SexData> data) {
            Data = data;
        }
        

        public class SexData {
            private String college;
            private String MenRatio;
            private String WomenRatio;


            public String getCollege() {
                return college;
            }

            public void setCollege(String college) {
                this.college = college;
            }

            public String getMenRatio() {
                return MenRatio;
            }

            public void setMenRatio(String menRatio) {
                MenRatio = menRatio;
            }

            public String getWomenRatio() {
                return WomenRatio;
            }

            public void setWomenRatio(String womenRatio) {
                WomenRatio = womenRatio;
            }
        }
    }