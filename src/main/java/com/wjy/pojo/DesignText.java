package com.wjy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "design_text")
public class DesignText {
    @Id
    @Column(name = "design_text_id")
    private String designTextId;

    @Column(name = "design_text_content")
    private String designTextContent;

    /**
     * @return design_text_id
     */
    public String getDesignTextId() {
        return designTextId;
    }

    /**
     * @param designTextId
     */
    public void setDesignTextId(String designTextId) {
        this.designTextId = designTextId;
    }

    /**
     * @return design_text_content
     */
    public String getDesignTextContent() {
        return designTextContent;
    }

    /**
     * @param designTextContent
     */
    public void setDesignTextContent(String designTextContent) {
        this.designTextContent = designTextContent;
    }
}