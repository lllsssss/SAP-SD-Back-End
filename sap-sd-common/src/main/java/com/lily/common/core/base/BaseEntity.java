package com.lily.common.core.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity基类
 *
 * @author valarchie
 */
//Lombok 提供的一个注解，用于自动生成类的 equals()和 hashCode()方法,true：生成的 equals()和 hashCode()会包含父类的字段。会比较父类
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseEntity<T extends Model<?>> extends Model<T> {

    @ApiModelProperty("创建者ID")//在Swagger UI中为该字段添加描述，说明 creatorId字段表示“创建者ID”。
    @TableField(value = "creator_id", fill = FieldFill.INSERT)//定义数据库字段映射和自动填充策略
    private Long creatorId;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("更新者ID")
    @TableField(value = "updater_id", fill = FieldFill.UPDATE, updateStrategy = FieldStrategy.NOT_NULL)
    private Long updaterId;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * deleted字段请在数据库中 设置为tinyInt   并且非null   默认值为0
     */
    @ApiModelProperty("删除标志（0代表存在 1代表删除）")
    @TableField("deleted")
    @TableLogic//关键注解：启用MyBatis-Plus的逻辑删除功能
    private Boolean deleted;
    //MyBatis-Plus会自动在所有查询SQL中追加 WHERE deleted=0：
    //调用 deleteById()实际执行的是更新：UPDATE user SET deleted=1 WHERE id=1;



}
