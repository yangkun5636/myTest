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
 * 数据字典
 * </p>
 *
 * @author yangkun
 * @since 2019-04-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "DataDict对象", description = "数据字典")
@TableName("b_data_dict")
public class DataDict extends Model<DataDict> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "上级字典id")
    private Integer parent;

    @ApiModelProperty(value = "字典编码")
    private String code;

    @ApiModelProperty(value = "字典名称")
    private String name;

    @ApiModelProperty(value = "状态")
    private String status;

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


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
