package com.kang.kangtemplate.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.kangtemplate.model.staff.entity.StaffBasicInfo;
import com.kang.kangtemplate.model.staff.req.StaffBasicInfoReq;
import com.kang.kangtemplate.model.staff.vo.StaffBasicInfoVO;

import java.util.List;

/**
 * @description: 职员基本信息 Service
 * @author: liukang
 * @date: 2024/12/08 13:01:47
 */
public interface StaffBasicInfoService {

    Page<StaffBasicInfoVO>  getStaffWithParamsByPage(StaffBasicInfoReq staffBasicInfoReq,
                                                      Page<StaffBasicInfoVO> page);

    Page<StaffBasicInfo> getStaffByPage(Page<StaffBasicInfoVO> page);

    List<StaffBasicInfo> getAllStaff();

    StaffBasicInfo getStaffById(Long id);

    boolean saveStaff(StaffBasicInfo staffBasicInfo);

    boolean updateStaff(StaffBasicInfo staffBasicInfo);

    boolean deleteStaff(Long id);

}
