package com.kang.kangtemplate.model.staff.req;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @description: 职员基本信息 REQ
 * @author: liukang
 * @date: 2024/12/08 15:12:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffBasicInfoReq {
    private Long staffNo;               // 员工编号

    private String staffName;           // 姓名

    private String gender;              // 性别

    private String phone;               // 联系电话

    private String email;               // 邮箱地址

    private LocalDate hireDate;         // 入职日期

    private String position;            // 职位

    private String department;          // 部门

    private BigDecimal baseSalary;      // 基本工资

    private Boolean isActive;           // 是否在职
}
