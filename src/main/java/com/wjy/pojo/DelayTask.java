package com.wjy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "delay_task")
public class DelayTask {
    /**
     * 延时ID
     */
    @Id
    @Column(name = "delay_id")
    private String delayId;

    /**
     * 延时名称
     */
    @Column(name = "delay_name")
    private String delayName;

    /**
     * 任务ID
     */
    @Column(name = "task_id")
    private String taskId;

    /**
     * 任务数据
     */
    @Column(name = "task_data")
    private String taskData;

    /**
     * 分数
     */
    @Column(name = "task_score")
    private String taskScore;

    /**
     * 任务状态: 1 等待中 2 执行中 3 已完成 4 已取消
     */
    @Column(name = "task_state")
    private Integer taskState;

    /**
     * 获取延时ID
     *
     * @return delay_id - 延时ID
     */
    public String getDelayId() {
        return delayId;
    }

    /**
     * 设置延时ID
     *
     * @param delayId 延时ID
     */
    public void setDelayId(String delayId) {
        this.delayId = delayId;
    }

    /**
     * 获取延时名称
     *
     * @return delay_name - 延时名称
     */
    public String getDelayName() {
        return delayName;
    }

    /**
     * 设置延时名称
     *
     * @param delayName 延时名称
     */
    public void setDelayName(String delayName) {
        this.delayName = delayName;
    }

    /**
     * 获取任务ID
     *
     * @return task_id - 任务ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置任务ID
     *
     * @param taskId 任务ID
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * 获取任务数据
     *
     * @return task_data - 任务数据
     */
    public String getTaskData() {
        return taskData;
    }

    /**
     * 设置任务数据
     *
     * @param taskData 任务数据
     */
    public void setTaskData(String taskData) {
        this.taskData = taskData;
    }

    /**
     * 获取分数
     *
     * @return task_score - 分数
     */
    public String getTaskScore() {
        return taskScore;
    }

    /**
     * 设置分数
     *
     * @param taskScore 分数
     */
    public void setTaskScore(String taskScore) {
        this.taskScore = taskScore;
    }

    /**
     * 获取任务状态: 1 等待中 2 执行中 3 已完成 4 已取消
     *
     * @return task_state - 任务状态: 1 等待中 2 执行中 3 已完成 4 已取消
     */
    public Integer getTaskState() {
        return taskState;
    }

    /**
     * 设置任务状态: 1 等待中 2 执行中 3 已完成 4 已取消
     *
     * @param taskState 任务状态: 1 等待中 2 执行中 3 已完成 4 已取消
     */
    public void setTaskState(Integer taskState) {
        this.taskState = taskState;
    }
}