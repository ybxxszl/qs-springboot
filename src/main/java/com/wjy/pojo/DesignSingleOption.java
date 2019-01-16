package com.wjy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "design_single_option")
public class DesignSingleOption {
    @Id
    @Column(name = "design_single_option_id")
    private String designSingleOptionId;

    @Column(name = "design_single_id")
    private String designSingleId;

    @Column(name = "design_single_order")
    private Integer designSingleOrder;

    @Column(name = "design_single_option_content")
    private String designSingleOptionContent;

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
     * @return design_single_order
     */
    public Integer getDesignSingleOrder() {
        return designSingleOrder;
    }

    /**
     * @param designSingleOrder
     */
    public void setDesignSingleOrder(Integer designSingleOrder) {
        this.designSingleOrder = designSingleOrder;
    }

    /**
     * @return design_single_option_content
     */
    public String getDesignSingleOptionContent() {
        return designSingleOptionContent;
    }

    /**
     * @param designSingleOptionContent
     */
    public void setDesignSingleOptionContent(String designSingleOptionContent) {
        this.designSingleOptionContent = designSingleOptionContent;
    }
}