package com.djandroid.jdroid.materialdesign.ClientLibrary.Parameter.Task;

import java.util.ArrayList;
import java.util.List;
import com.djandroid.jdroid.materialdesign.ClientLibrary.Parameter.*;

/**
 * Created by Jimmy on 2016/10/10.
 */
public class TaskItem {
    private String itemId;
    private String item;
    private Integer score;
    private String remark;
    private String violationLevel;
    private String explanation;
    private String auditStatus;
    private boolean isScore;
    private List<String> picturePathList;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public ViolationLevel getViolationLevel() {
        return ViolationLevel.valueOf(violationLevel);
    }

    public void setViolationLevel(ViolationLevel violationLevel) {
        this.violationLevel = violationLevel.toString();
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public AuditStatus getAuditStatus() {
        return AuditStatus.valueOf(auditStatus);
    }

    public void setAuditStatus(AuditStatus auditStatus) {
        this.auditStatus = auditStatus.toString();
    }

    public List<String> getPicturePathList() {
        return picturePathList;
    }

    public void setPicturePathList(List<String> picturePathList) {
        this.picturePathList = picturePathList;
    }

    public void addPicture(String picture)
    {
        if (this.picturePathList == null) this.picturePathList = new ArrayList<>();
        this.picturePathList.add(picture);
    }

    public void removePicture(String picture)
    {
        this.picturePathList.remove(picture);
    }

    public boolean isScore() {
        return isScore;
    }

    public void setScore(boolean score) {
        isScore = score;
    }

}
