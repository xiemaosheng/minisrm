package com.minisrm.admin.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "srm_order_review")
public class OrderReview implements Serializable {

    /**
     * 编号id
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 订单编号id
     */
    @Column(name = "orderId")
    private Long orderId;

    /**
     * 评论标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 评论内容
     */
    @Column(name = "content")
    private String content;

    /**
     * review图片地址
     */
    @Column(name = "reviewImgUrl")
    private String reviewImgUrl;

    /**
     * review视频地址
     */
    @Column(name = "reviewVideoUrl")
    private String reviewVideoUrl;

    /**
     * 评价链接地址
     */
    @Column(name = "reviewLinkUrl")
    private String reviewLinkUrl;

    /**
     * 评论截图地址
     */
    @Column(name = "reviewJtUrl")
    private String reviewJtUrl;

    /**
     * 上评人账号
     */
    @Column(name = "reviewUserId")
    private String reviewUserId;

    /**
     * 上评人
     */
    @Column(name = "reviewUserName")
    private String reviewUserName;

    /**
     * 实际评论日期
     */
    @Column(name = "reviewDateTime")
    private String reviewDateTime;

    /**
     * 计划评论日期
     */
    @Column(name = "reviewPlanDateTime")
    private String reviewPlanDateTime;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "updateTime")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReviewImgUrl() {
        return reviewImgUrl;
    }

    public void setReviewImgUrl(String reviewImgUrl) {
        this.reviewImgUrl = reviewImgUrl;
    }

    public String getReviewVideoUrl() {
        return reviewVideoUrl;
    }

    public void setReviewVideoUrl(String reviewVideoUrl) {
        this.reviewVideoUrl = reviewVideoUrl;
    }

    public String getReviewLinkUrl() {
        return reviewLinkUrl;
    }

    public void setReviewLinkUrl(String reviewLinkUrl) {
        this.reviewLinkUrl = reviewLinkUrl;
    }

    public String getReviewJtUrl() {
        return reviewJtUrl;
    }

    public void setReviewJtUrl(String reviewJtUrl) {
        this.reviewJtUrl = reviewJtUrl;
    }

    public String getReviewUserId() {
        return reviewUserId;
    }

    public void setReviewUserId(String reviewUserId) {
        this.reviewUserId = reviewUserId;
    }

    public String getReviewUserName() {
        return reviewUserName;
    }

    public void setReviewUserName(String reviewUserName) {
        this.reviewUserName = reviewUserName;
    }

    public String getReviewDateTime() {
        return reviewDateTime;
    }

    public void setReviewDateTime(String reviewDateTime) {
        this.reviewDateTime = reviewDateTime;
    }

    public String getReviewPlanDateTime() {
        return reviewPlanDateTime;
    }

    public void setReviewPlanDateTime(String reviewPlanDateTime) {
        this.reviewPlanDateTime = reviewPlanDateTime;
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
}
