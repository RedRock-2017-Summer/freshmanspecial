package com.mredrock.freshmanspecial.CQUPTStrategy.Model;

import java.util.List;

/**
 * Created by Anriku on 2017/8/10.
 */

public class QQGroup {

    private String Status;
    private String Info;
    private String Version;
    private List<GroupData> Data;

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

    public List<GroupData> getData() {
        return Data;
    }

    public void setData(List<GroupData> data) {
        Data = data;
    }

    public class GroupData{

        private String GroupName;
        private String Number;

        public String getGroupName() {
            return GroupName;
        }

        public void setGroupName(String groupName) {
            GroupName = groupName;
        }

        public String getNumber() {
            return Number;
        }

        public void setNumber(String number) {
            Number = number;
        }
    }

}
