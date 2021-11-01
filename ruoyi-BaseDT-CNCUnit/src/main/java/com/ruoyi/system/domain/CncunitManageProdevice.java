package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 工艺设备数据对象 cncunit_manage_prodevice
 * 
 * @author ruoyi
 * @date 2021-10-31
 */
public class CncunitManageProdevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工艺设备ID */
    private String manageProdevId;

    /** 工艺设备名称 */
    @Excel(name = "工艺设备名称")
    private String manageProdevName;

    /** 所属车间ID */
    @Excel(name = "所属车间ID")
    private String manageProdevWkshopid;

    /** 数量 */
    @Excel(name = "数量")
    private Integer manageProdevNumber;

    /** 删除标志 */
    @Excel(name = "删除标志")
    private Integer manageProdevDelflag;

    /** 备注 */
    @Excel(name = "备注")
    private String manageProdevRemark;

    public void setManageProdevId(String manageProdevId) 
    {
        this.manageProdevId = manageProdevId;
    }

    public String getManageProdevId() 
    {
        return manageProdevId;
    }
    public void setManageProdevName(String manageProdevName) 
    {
        this.manageProdevName = manageProdevName;
    }

    public String getManageProdevName() 
    {
        return manageProdevName;
    }
    public void setManageProdevWkshopid(String manageProdevWkshopid) 
    {
        this.manageProdevWkshopid = manageProdevWkshopid;
    }

    public String getManageProdevWkshopid() 
    {
        return manageProdevWkshopid;
    }
    public void setManageProdevNumber(Integer manageProdevNumber) 
    {
        this.manageProdevNumber = manageProdevNumber;
    }

    public Integer getManageProdevNumber() 
    {
        return manageProdevNumber;
    }
    public void setManageProdevDelflag(Integer manageProdevDelflag) 
    {
        this.manageProdevDelflag = manageProdevDelflag;
    }

    public Integer getManageProdevDelflag() 
    {
        return manageProdevDelflag;
    }
    public void setManageProdevRemark(String manageProdevRemark) 
    {
        this.manageProdevRemark = manageProdevRemark;
    }

    public String getManageProdevRemark() 
    {
        return manageProdevRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("manageProdevId", getManageProdevId())
            .append("manageProdevName", getManageProdevName())
            .append("manageProdevWkshopid", getManageProdevWkshopid())
            .append("manageProdevNumber", getManageProdevNumber())
            .append("manageProdevDelflag", getManageProdevDelflag())
            .append("manageProdevRemark", getManageProdevRemark())
            .toString();
    }
}
