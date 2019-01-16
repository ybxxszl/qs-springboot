package com.wjy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "queue_task")
public class QueueTask {
    /**
     * 队列ID
     */
    @Id
    @Column(name = "queue_id")
    private String queueId;

    /**
     * 队列名称
     */
    @Column(name = "queue_name")
    private String queueName;

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
     * 执行顺序索引
     */
    @Column(name = "task_index")
    private Integer taskIndex;

    /**
     * 任务状态: 1 等待中 2 执行中 3 已完成 4 已取消
     */
    @Column(name = "task_state")
    private Integer taskState;

    /**
     * 获取队列ID
     *
     * @return queue_id - 队列ID
     */
    public String getQueueId() {
        return queueId;
    }

    /**
     * 设置队列ID
     *
     * @param queueId 队列ID
     */
    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    /**
     * 获取队列名称
     *
     * @return queue_name - 队列名称
     */
    public String getQueueName() {
        return queueName;
    }

    /**
     * 设置队列名称
     *
     * @param queueName 队列名称
     */
    public void setQueueName(String queueName) {
        this.queueName = queueName;
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
     * 获取执行顺序索引
     *
     * @return task_index - 执行顺序索引
     */
    public Integer getTaskIndex() {
        return taskIndex;
    }

    /**
     * 设置执行顺序索引
     *
     * @param taskIndex 执行顺序索引
     */
    public void setTaskIndex(Integer taskIndex) {
        this.taskIndex = taskIndex;
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