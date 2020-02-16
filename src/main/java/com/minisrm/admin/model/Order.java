package com.minisrm.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Table(name = "srm_order")
public class Order implements Serializable {

    /**
     * 编号id
     */
    @Id
    @Column(name = "id")
    private Long id;


    /**
     * 店铺名称
     */
    @Column(name = "mktName")
    private String mktName;

    /**
     * 商品图片地址
     */
    @Column(name = "goodImgUrl")
    private String goodImgUrl;

    /**
     * 商品订单号
     */
    @Column(name = "goodOrderNum")
    private String goodOrderNum;

    /**
     * 卖家微信/QQ
     */
    @Column(name = "sellerWXQQ")
    private String sellerWXQQ;

    /**
     * 卖家订单类型
     */
    @Column(name = "sellerOrderType")
    private String sellerOrderType;

    /**
     * 员工代码（登录账号）
     */
    @Column(name = "workerName")
    private String workerName;

    /**
     * 工作性质
     */
    @Column(name = "workingType")
    private String workingType;

    /**
     * 返款方式
     */
    @Column(name = "cashBackType")
    private String cashBackType;

    /**
     * 站点
     */
    @Column(name = "website")
    private String website;

    /**
     *
     */
    @Column(name = "ASIN")
    private String ASIN;

    /**
     * 接单金额
     */
    @Column(name = "recPrice")
    private double recPrice;

    /**
     * 下单金额
     */
    @Column(name = "xdPrice")
    private double xdPrice;

    /**
     * 接单佣金
     */
    @Column(name = "recCommission")
    private double recCommission;

    /**
     * 下单截图url
     */
    @Column(name = "xdJtUrl")
    private String xdJtUrl;

    /**
     * 下单支付截图url
     */
    @Column(name = "xdPayedJtUrl")
    private String xdPayedJtUrl;

    /**
     * 下单人账号
     */
    @Column(name = "xdUser")
    private String xdUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @Column(name = "xdDateTime")
    private Date xdDateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @Column(name = "recDateTime")
    private Date recDateTime;

    @Column(name = "xdRequirement")
    private String xdRequirement;

    @Column(name = "signedJtUrl")
    private String signedJtUrl;

    @Column(name = "remark")
    private String remark;

    @Column(name = "status")
    private Long status;

    @Column(name = "flag")
    private Long flag;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @Column(name = "createTime")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @Column(name = "updateTime")
    private Date updateTime;

    @Transient
    private int orderCount;

    @Transient
    private int dayCount;

    // 扩展字段
    /**
     * 评论标题
     */
    @Transient
    private String title;

    /**
     * 评论内容
     */
    @Transient
    private String content;

    /**
     * review图片地址
     */
    @Transient
    private String reviewImgUrl;

    /**
     * review视频地址
     */
    @Transient
    private String reviewVideoUrl;

    /**
     * 评价链接地址
     */
    @Transient
    private String reviewLinkUrl;

    /**
     * 评论截图地址
     */
    @Transient
    private String reviewJtUrl;

    /**
     * 上评人账号
     */
    @Transient
    private String reviewUserId;

    /**
     * 上评人
     */
    @Transient
    private String reviewUserName;

    /**
     * 实际评论日期
     */
    @Transient
    private Date reviewDateTime;

    /**
     * 计划评论日期
     */
    @Transient
    private Date reviewPlanDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMktName() {
        return mktName;
    }

    public void setMktName(String mktName) {
        this.mktName = mktName;
    }

    public String getGoodImgUrl() {
        return goodImgUrl;
    }

    public void setGoodImgUrl(String goodImgUrl) {
        this.goodImgUrl = goodImgUrl;
    }

    public String getGoodOrderNum() {
        return goodOrderNum;
    }

    public void setGoodOrderNum(String goodOrderNum) {
        this.goodOrderNum = goodOrderNum;
    }

    public String getSellerWXQQ() {
        return sellerWXQQ;
    }

    public void setSellerWXQQ(String sellerWXQQ) {
        this.sellerWXQQ = sellerWXQQ;
    }

    public String getSellerOrderType() {
        return sellerOrderType;
    }

    public void setSellerOrderType(String sellerOrderType) {
        this.sellerOrderType = sellerOrderType;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkingType() {
        return workingType;
    }

    public void setWorkingType(String workingType) {
        this.workingType = workingType;
    }

    public String getCashBackType() {
        return cashBackType;
    }

    public void setCashBackType(String cashBackType) {
        this.cashBackType = cashBackType;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getASIN() {
        return ASIN;
    }

    public void setASIN(String ASIN) {
        this.ASIN = ASIN;
    }

    public double getRecPrice() {
        return recPrice;
    }

    public void setRecPrice(double recPrice) {
        this.recPrice = recPrice;
    }

    public double getXdPrice() {
        return xdPrice;
    }

    public void setXdPrice(double xdPrice) {
        this.xdPrice = xdPrice;
    }

    public double getRecCommission() {
        return recCommission;
    }

    public void setRecCommission(double recCommission) {
        this.recCommission = recCommission;
    }

    public String getXdJtUrl() {
        return xdJtUrl;
    }

    public void setXdJtUrl(String xdJtUrl) {
        this.xdJtUrl = xdJtUrl;
    }

    public String getXdPayedJtUrl() {
        return xdPayedJtUrl;
    }

    public void setXdPayedJtUrl(String xdPayedJtUrl) {
        this.xdPayedJtUrl = xdPayedJtUrl;
    }

    public String getXdUser() {
        return xdUser;
    }

    public void setXdUser(String xdUser) {
        this.xdUser = xdUser;
    }

    public Date getXdDateTime() {
        return xdDateTime;
    }

    public void setXdDateTime(Date xdDateTime) {
        this.xdDateTime = xdDateTime;
    }

    public Date getRecDateTime() {
        return recDateTime;
    }

    public void setRecDateTime(Date recDateTime) {
        this.recDateTime = recDateTime;
    }

    public String getXdRequirement() {
        return xdRequirement;
    }

    public void setXdRequirement(String xdRequirement) {
        this.xdRequirement = xdRequirement;
    }

    public String getSignedJtUrl() {
        return signedJtUrl;
    }

    public void setSignedJtUrl(String signedJtUrl) {
        this.signedJtUrl = signedJtUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getFlag() {
        return flag;
    }

    public void setFlag(Long flag) {
        this.flag = flag;
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

    public Date getReviewDateTime() {
        return reviewDateTime;
    }

    public void setReviewDateTime(Date reviewDateTime) {
        this.reviewDateTime = reviewDateTime;
    }

    public Date getReviewPlanDateTime() {
        return reviewPlanDateTime;
    }

    public void setReviewPlanDateTime(Date reviewPlanDateTime) {
        this.reviewPlanDateTime = reviewPlanDateTime;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }
}
