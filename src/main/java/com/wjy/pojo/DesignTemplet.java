package com.wjy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "design_templet")
public class DesignTemplet {
    @Id
    @Column(name = "design_templet_id")
    private String designTempletId;

    @Column(name = "design_templet_name")
    private String designTempletName;

    @Column(name = "finish_time")
    private Date finishTime;

    @Column(name = "start_recovery_time")
    private Date startRecoveryTime;

    @Column(name = "end_recovery_time")
    private Date endRecoveryTime;

    private Integer state;

    private String link;

    @Column(name = "author_id")
    private String authorId;

    /**
     * @return design_templet_id
     */
    public String getDesignTempletId() {
        return designTempletId;
    }

    /**
     * @param designTempletId
     */
    public void setDesignTempletId(String designTempletId) {
        this.designTempletId = designTempletId;
    }

    /**
     * @return design_templet_name
     */
    public String getDesignTempletName() {
        return designTempletName;
    }

    /**
     * @param designTempletName
     */
    public void setDesignTempletName(String designTempletName) {
        this.designTempletName = designTempletName;
    }

    /**
     * @return finish_time
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * @param finishTime
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * @return start_recovery_time
     */
    public Date getStartRecoveryTime() {
        return startRecoveryTime;
    }

    /**
     * @param startRecoveryTime
     */
    public void setStartRecoveryTime(Date startRecoveryTime) {
        this.startRecoveryTime = startRecoveryTime;
    }

    /**
     * @return end_recovery_time
     */
    public Date getEndRecoveryTime() {
        return endRecoveryTime;
    }

    /**
     * @param endRecoveryTime
     */
    public void setEndRecoveryTime(Date endRecoveryTime) {
        this.endRecoveryTime = endRecoveryTime;
    }

    /**
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * @return link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return author_id
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}