package com.huohua.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 */
@ApiModel(value = "com-huohua-domain-User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`user`")
public class User implements Serializable {
    /**
     * ID
     */
    @TableId(value = "user_id", type = IdType.INPUT)
    @ApiModelProperty(value = "ID")
    private String userId;

    /**
     * 用户昵称
     */
    @TableField(value = "nick_name")
    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    /**
     * 真实姓名
     */
    @TableField(value = "real_name")
    @ApiModelProperty(value = "真实姓名")
    private String realName;

    /**
     * 用户邮箱
     */
    @TableField(value = "user_mail")
    @ApiModelProperty(value = "用户邮箱")
    private String userMail;

    /**
     * 登录密码
     */
    @TableField(value = "login_password")
    @ApiModelProperty(value = "登录密码")
    private String loginPassword;

    /**
     * 支付密码
     */
    @TableField(value = "pay_password")
    @ApiModelProperty(value = "支付密码")
    private String payPassword;

    /**
     * 手机号码
     */
    @TableField(value = "user_mobile")
    @ApiModelProperty(value = "手机号码")
    private String userMobile;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time")
    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    /**
     * 注册时间
     */
    @TableField(value = "user_regtime")
    @ApiModelProperty(value = "注册时间")
    private Date userRegtime;

    /**
     * 注册IP
     */
    @TableField(value = "user_regip")
    @ApiModelProperty(value = "注册IP")
    private String userRegip;

    /**
     * 最后登录时间
     */
    @TableField(value = "user_lasttime")
    @ApiModelProperty(value = "最后登录时间")
    private Date userLasttime;

    /**
     * 最后登录IP
     */
    @TableField(value = "user_lastip")
    @ApiModelProperty(value = "最后登录IP")
    private String userLastip;

    /**
     * 备注
     */
    @TableField(value = "user_memo")
    @ApiModelProperty(value = "备注")
    private String userMemo;

    /**
     * M(男) or F(女)
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "M(男) or F(女)")
    private String sex;

    /**
     * 例如：2009-11-27
     */
    @TableField(value = "birth_date")
    @ApiModelProperty(value = "例如：2009-11-27")
    private String birthDate;

    /**
     * 头像图片路径
     */
    @TableField(value = "pic")
    @ApiModelProperty(value = "头像图片路径")
    private String pic;

    /**
     * 状态 1 正常 0 无效
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "状态 1 正常 0 无效")
    private Integer status;

    /**
     * 用户积分
     */
    @TableField(value = "score")
    @ApiModelProperty(value = "用户积分")
    private Integer score;

}