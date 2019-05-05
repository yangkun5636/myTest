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
 * 用户表
 * </p>
 *
 * @author yangkun
 * @since 2019-04-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "SysUser对象", description = "用户表")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "机构ID")
    private Integer orgId;

    @ApiModelProperty(value = "部门编号")
    private Integer deptNo;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "用户编号(工号)")
    private String userNo;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "头像")
    private String photo;

    @ApiModelProperty(value = "微信")
    private String wx;

    @ApiModelProperty(value = "QQ")
    private String qq;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "最后登录IP")
    private String loginIp;

    @ApiModelProperty(value = "最后登录日期")
    private String loginDate;

    @ApiModelProperty(value = "是否可登录")
    private String loginFlag;

    @ApiModelProperty(value = "创建人")
    private Integer createId;

    @ApiModelProperty(value = "创建日期")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private Integer updateId;

    @ApiModelProperty(value = "更新日期")
    private Date updateTime;

    @ApiModelProperty(value = "删除标识0否")
    private String deleteFlag;

    private SysOrg org;
    private List<SysRole> roles;

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
