package com.ben.shiro.pojo.bo;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 权限表
 * </p>
 *
 * @author yangkun
 * @since 2019-04-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "SysPermission对象", description = "权限表")
@TableName("s_sys_permission")
public class SysPermission extends Model<SysPermission> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "上级")
    private Integer parent;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "权限编码")
    private String permission;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "链接")
    private Integer href;

    @ApiModelProperty(value = "目标")
    private Integer target;

    @ApiModelProperty(value = "图标")
    private Integer icon;

    @ApiModelProperty(value = "是否展示")
    private String isShow;

    @ApiModelProperty(value = "描述")
    private String comment;

    @ApiModelProperty(value = "状态")
    private String status;

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
