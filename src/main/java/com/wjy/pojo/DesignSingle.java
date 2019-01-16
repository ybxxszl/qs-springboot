package com.wjy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "design_single")
public class DesignSingle {
    @Id
    @Column(name = "design_single_id")
    private String designSingleId;

    @Column(name = "design_single_content")
    private String designSingleContent;

    /**
     * @return design_single_id
     */
    public String getDesignSingleId() {
        return designSingleId;
    }

    /**
     * @param designSingleId
     */
    public void setDesignSingleId(String designSingleId) {
        this.designSingleId = designSingleId;
    }

    /**
     * @return design_single_content
     */
    public String getDesignSingleContent() {
        return designSingleContent;
    }

    /**
     * @param designSingleContent
     */
    public void setDesignSingleContent(String designSingleContent) {
        this.designSingleContent = designSingleContent;
    }
}