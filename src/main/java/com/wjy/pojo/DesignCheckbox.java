package com.wjy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "design_checkbox")
public class DesignCheckbox {
    @Id
    @Column(name = "design_checkbox_id")
    private String designCheckboxId;

    @Column(name = "design_checkbox_content")
    private String designCheckboxContent;

    /**
     * @return design_checkbox_id
     */
    public String getDesignCheckboxId() {
        return designCheckboxId;
    }

    /**
     * @param designCheckboxId
     */
    public void setDesignCheckboxId(String designCheckboxId) {
        this.designCheckboxId = designCheckboxId;
    }

    /**
     * @return design_checkbox_content
     */
    public String getDesignCheckboxContent() {
        return designCheckboxContent;
    }

    /**
     * @param designCheckboxContent
     */
    public void setDesignCheckboxContent(String designCheckboxContent) {
        this.designCheckboxContent = designCheckboxContent;
    }
}