package com.mredrock.freshmanspecial.CQUPTElegant.Model;

/**
 * Created by Anriku on 2017/8/12.
 */

import java.util.List;

public class Organization {

    private String Status;
    private String Info;
    private String Version;
    private List<OrganizationData> Data;

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

    public List<OrganizationData> getData() {
        return Data;
    }

    public void setData(List<OrganizationData> data) {
        Data = data;
    }

    public class OrganizationData{
        private String name;
        private String resume;
        private List<DepartmentData> department;

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

        public List<DepartmentData> getDepartment() {
            return department;
        }

        public void setDepartment(List<DepartmentData> department) {
            this.department = department;
        }

        public class DepartmentData{
            private String name;
            private String resume;

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
        }
    }

}

