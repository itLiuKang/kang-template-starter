package com.kang.kangtemplate.model.staff.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @description: 职员基本信息表
 * @author: liukang
 * @date: 2024/12/08 12:58:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("STAFF_BASIC_INFO")
public class StaffBasicInfo {
    @TableId("STAFF_NO")
    private Long staffNo;               // 员工编号

    @TableField("STAFF_NAME")
    private String staffName;           // 姓名

    @TableField("GENDER")
    private String gender;              // 性别

    @TableField("PHONE")
    private String phone;               // 联系电话

    @TableField("EMAIL")
    private String email;               // 邮箱地址

    @TableField("HIRE_DATE")
    private LocalDate hireDate;         // 入职日期

    @TableField("POSITION")
    private String position;            // 职位

    @TableField("DEPARTMENT")
    private String department;          // 部门

    @TableField("BASE_SALARY")
    private BigDecimal baseSalary;      // 基本工资

    @TableField("IS_ACTIVE")
    private Boolean isActive;           // 是否在职

}