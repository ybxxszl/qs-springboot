package com.wjy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "single_answer_count")
public class SingleAnswerCount {
    @Id
    @Column(name = "single_answer_count_id")
    private String singleAnswerCountId;

    @Column(name = "single_answer_count")
    private Integer singleAnswerCount;

    @Column(name = "design_single_option_id")
    private String designSingleOptionId;

    /**
     * @return single_answer_count_id
     */
    public String getSingleAnswerCountId() {
        return singleAnswerCountId;
    }

    /**
     * @param singleAnswerCountId
     */
    public void setSingleAnswerCountId(String singleAnswerCountId) {
        this.singleAnswerCountId = singleAnswerCountId;
    }

    /**
     * @return single_answer_count
     */
    public Integer getSingleAnswerCount() {
        return singleAnswerCount;
    }

    /**
     * @param singleAnswerCount
     */
    public void setSingleAnswerCount(Integer singleAnswerCount) {
        this.singleAnswerCount = singleAnswerCount;
    }

    /**
     * @return design_single_option_id
     */
    public String getDesignSingleOptionId() {
        return designSingleOptionId;
    }

    /**
     * @param designSingleOptionId
     */
    public void setDesignSingleOptionId(String designSingleOptionId) {
        this.designSingleOptionId = designSingleOptionId;
    }
}