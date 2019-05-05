package com.ben.shiro.pojo.bo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 角色权限表
 * </p>
 *
 * @author yangkun
 * @since 2019-04-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "SysRolePermission对象", description = "角色权限表")
public class SysRolePermission extends Model<SysRolePermission> {

    private static final long serialVersionUID = 1L;

    private Integer roleId;

    @ApiModelProperty(value = "角色编码")
    private String roleCode;

    private Integer permissionId;

    @ApiModelProperty(value = "权限编码")
    private Integer permissionCode;

    private SysRole role;
    private SysPermission permission;

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

}
