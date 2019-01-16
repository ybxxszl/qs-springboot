package com.wjy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "checkbox_answer_count")
public class CheckboxAnswerCount {
    @Id
    @Column(name = "checkbox_answer_count_id")
    private String checkboxAnswerCountId;

    @Column(name = "checkbox_answer_count")
    private Integer checkboxAnswerCount;

    @Column(name = "design_checkbox_option_id")
    private String designCheckboxOptionId;

    /**
     * @return checkbox_answer_count_id
     */
    public String getCheckboxAnswerCountId() {
        return checkboxAnswerCountId;
    }

    /**
     * @param checkboxAnswerCountId
     */
    public void setCheckboxAnswerCountId(String checkboxAnswerCountId) {
        this.checkboxAnswerCountId = checkboxAnswerCountId;
    }

    /**
     * @return checkbox_answer_count
     */
    public Integer getCheckboxAnswerCount() {
        return checkboxAnswerCount;
    }

    /**
     * @param checkboxAnswerCount
     */
    public void setCheckboxAnswerCount(Integer checkboxAnswerCount) {
        this.checkboxAnswerCount = checkboxAnswerCount;
    }

    /**
     * @return design_checkbox_option_id
     */
    public String getDesignCheckboxOptionId() {
        return designCheckboxOptionId;
    }

    /**
     * @param designCheckboxOptionId
     */
    public void setDesignCheckboxOptionId(String designCheckboxOptionId) {
        this.designCheckboxOptionId = designCheckboxOptionId;
    }
}