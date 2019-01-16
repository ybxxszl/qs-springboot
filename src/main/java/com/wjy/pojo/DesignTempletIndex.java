package com.wjy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "design_templet_index")
public class DesignTempletIndex {
    @Id
    @Column(name = "design_templet_index_id")
    private String designTempletIndexId;

    @Column(name = "design_templet_index_sign")
    private Integer designTempletIndexSign;

    @Column(name = "design_templet_index_order")
    private Integer designTempletIndexOrder;

    @Column(name = "design_exercise_id")
    private String designExerciseId;

    @Column(name = "design_templet_id")
    private String designTempletId;

    /**
     * @return design_templet_index_id
     */
    public String getDesignTempletIndexId() {
        return designTempletIndexId;
    }

    /**
     * @param designTempletIndexId
     */
    public void setDesignTempletIndexId(String designTempletIndexId) {
        this.designTempletIndexId = designTempletIndexId;
    }

    /**
     * @return design_templet_index_sign
     */
    public Integer getDesignTempletIndexSign() {
        return designTempletIndexSign;
    }

    /**
     * @param designTempletIndexSign
     */
    public void setDesignTempletIndexSign(Integer designTempletIndexSign) {
        this.designTempletIndexSign = designTempletIndexSign;
    }

    /**
     * @return design_templet_index_order
     */
    public Integer getDesignTempletIndexOrder() {
        return designTempletIndexOrder;
    }

    /**
     * @param designTempletIndexOrder
     */
    public void setDesignTempletIndexOrder(Integer designTempletIndexOrder) {
        this.designTempletIndexOrder = designTempletIndexOrder;
    }

    /**
     * @return design_exercise_id
     */
    public String getDesignExerciseId() {
        return designExerciseId;
    }

    /**
     * @param designExerciseId
     */
    public void setDesignExerciseId(String designExerciseId) {
        this.designExerciseId = designExerciseId;
    }

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
}