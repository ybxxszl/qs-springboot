package com.wjy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "design_checkbox_option")
public class DesignCheckboxOption {
    @Id
    @Column(name = "design_checkbox_option_id")
    private String designCheckboxOptionId;

    @Column(name = "design_checkbox_id")
    private String designCheckboxId;

    @Column(name = "design_checkbox_order")
    private Integer designCheckboxOrder;

    @Column(name = "design_checkbox_option_content")
    private String designCheckboxOptionContent;

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
     * @return design_checkbox_order
     */
    public Integer getDesignCheckboxOrder() {
        return designCheckboxOrder;
    }

    /**
     * @param designCheckboxOrder
     */
    public void setDesignCheckboxOrder(Integer designCheckboxOrder) {
        this.designCheckboxOrder = designCheckboxOrder;
    }

    /**
     * @return design_checkbox_option_content
     */
    public String getDesignCheckboxOptionContent() {
        return designCheckboxOptionContent;
    }

    /**
     * @param designCheckboxOptionContent
     */
    public void setDesignCheckboxOptionContent(String designCheckboxOptionContent) {
        this.designCheckboxOptionContent = designCheckboxOptionContent;
    }
}