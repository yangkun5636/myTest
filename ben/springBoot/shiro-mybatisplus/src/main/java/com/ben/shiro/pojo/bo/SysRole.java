package com.ben.shiro.pojo.bo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author yangkun
 * @since 2019-04-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "SysRole对象", description = "角色信息表")
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "机构ID")
    private Integer orgId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色编码")
    private String roleCode;

    @ApiModelProperty(value = "角色类型")
    private String roleType;

    @ApiModelProperty(value = "数据范围")
    private String dataScope;

    @ApiModelProperty(value = "状态")
    private String status;

    private Integer createId;

    private Date createTime;

    private Integer updateId;

    private Date updateTime;

    private String deleteFlag;

    private List<SysPermission> permissions;

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
