package org.yejh.shop.entity;

import java.util.Date;

/**
 * @author Ye Jiahao
 * @create 2019-05-06
 * @since 4.0
 */
public class CourseBean {
    private String name;
    private String nameZhCN;
    private String description;
    private Date createTime;
    private Date updateTime;

    public CourseBean() {
    }

    public CourseBean(String name, String nameZhCN, Date createTime) {
        this.name = name;
        this.nameZhCN = nameZhCN;
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZhCN() {
        return nameZhCN;
    }

    public void setNameZhCN(String nameZhCN) {
        this.nameZhCN = nameZhCN;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CourseBean{" +
                "name='" + name + '\'' +
                ", nameZhCN='" + nameZhCN + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
