package cn.ben.test.vo;

import java.util.Date;

public class OfferScript {
    private Long offerScriptId;

    private String offerScriptName;

    private String offerScriptDesc;

    private String offerScriptType;

    private Long offerId;

    private Long orgId;

    private String statusCd;

    private Long createStaff;

    private Long updateStaff;

    private Date statusDate;

    private Date createDate;

    private Date updateDate;

    private String remark;

    public Long getOfferScriptId() {
        return offerScriptId;
    }

    public void setOfferScriptId(Long offerScriptId) {
        this.offerScriptId = offerScriptId;
    }

    public String getOfferScriptName() {
        return offerScriptName;
    }

    public void setOfferScriptName(String offerScriptName) {
        this.offerScriptName = offerScriptName;
    }

    public String getOfferScriptDesc() {
        return offerScriptDesc;
    }

    public void setOfferScriptDesc(String offerScriptDesc) {
        this.offerScriptDesc = offerScriptDesc;
    }

    public String getOfferScriptType() {
        return offerScriptType;
    }

    public void setOfferScriptType(String offerScriptType) {
        this.offerScriptType = offerScriptType;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public Long getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(Long createStaff) {
        this.createStaff = createStaff;
    }

    public Long getUpdateStaff() {
        return updateStaff;
    }

    public void setUpdateStaff(Long updateStaff) {
        this.updateStaff = updateStaff;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}