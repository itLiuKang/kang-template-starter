package com.kang.kangtemplate.mapper.staff;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.kangtemplate.model.staff.entity.StaffBasicInfo;
import com.kang.kangtemplate.model.staff.req.StaffBasicInfoReq;
import com.kang.kangtemplate.model.staff.vo.StaffBasicInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description: 职员基本信息 Mapper
 * @author: liukang
 * @date: 2024/12/08 13:01:05
 */
@Mapper
public interface StaffBasicInfoMapper extends BaseMapper<StaffBasicInfo> {

    Page<StaffBasicInfoVO> getStaffWithParamsByPage(Page<StaffBasicInfoVO> page,
                                                     @Param("param") StaffBasicInfoReq staffBasicInfoReq);
}
