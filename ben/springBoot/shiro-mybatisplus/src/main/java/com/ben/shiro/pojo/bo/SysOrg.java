package com.ben.shiro.pojo.bo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 机构信息表
 * </p>
 *
 * @author yangkun
 * @since 2019-04-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "SysOrg对象", description = "机构信息表")
public class SysOrg extends Model<SysOrg> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "机构名称")
    private String orgName;

    @ApiModelProperty(value = "机构编码")
    private String orgCode;

    @ApiModelProperty(value = "机构类型")
    private String type;

    @ApiModelProperty(value = "机构状态")
    private String status;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "保险公司安全码")
    private String securityKey;

    private Integer createId;

    private Date createTime;

    private Integer updateId;

    private Date updateTime;

    private String deleteFlag;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
