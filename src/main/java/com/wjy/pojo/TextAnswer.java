package com.wjy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "text_answer")
public class TextAnswer {
    @Id
    @Column(name = "text_answer_id")
    private String textAnswerId;

    @Column(name = "design_text_id")
    private String designTextId;

    @Column(name = "text_answer_content")
    private String textAnswerContent;

    /**
     * @return text_answer_id
     */
    public String getTextAnswerId() {
        return textAnswerId;
    }

    /**
     * @param textAnswerId
     */
    public void setTextAnswerId(String textAnswerId) {
        this.textAnswerId = textAnswerId;
    }

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
     * @return text_answer_content
     */
    public String getTextAnswerContent() {
        return textAnswerContent;
    }

    /**
     * @param textAnswerContent
     */
    public void setTextAnswerContent(String textAnswerContent) {
        this.textAnswerContent = textAnswerContent;
    }
}