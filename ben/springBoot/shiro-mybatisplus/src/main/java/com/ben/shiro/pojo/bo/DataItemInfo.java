package com.ben.shiro.pojo.bo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author yangkun
 * @since 2019-04-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "DataItemInfo对象", description = "")
public class DataItemInfo extends Model<DataItemInfo> {

    private static final long serialVersionUID = 1L;

    private String classCode;

    private String className;

    private String code;

    private String name;

    private String param;

    private String flag;

    private Integer createId;

    private Date createTime;

    private Date updateTime;

    private String updateId;

    private String deleteFlag;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
