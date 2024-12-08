package com.kang.kangtemplate.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.kangtemplate.model.staff.entity.StaffBasicInfo;
import com.kang.kangtemplate.mapper.staff.StaffBasicInfoMapper;
import com.kang.kangtemplate.model.staff.req.StaffBasicInfoReq;
import com.kang.kangtemplate.model.staff.vo.StaffBasicInfoVO;
import com.kang.kangtemplate.service.StaffBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 职员基本信息 ServiceImpl
 * @author: liukang
 * @date: 2024/12/08 13:02:29
 */
@Service
public class StaffBasicInfoServiceImpl implements StaffBasicInfoService {

    @Autowired
    private StaffBasicInfoMapper staffBasicInfoMapper;

    @Override
    public Page<StaffBasicInfoVO> getStaffWithParamsByPage(StaffBasicInfoReq staffBasicInfoReq, Page<StaffBasicInfoVO> page) {
        return staffBasicInfoMapper.getStaffWithParamsByPage(page, staffBasicInfoReq);
    }

    @Override
    public Page<StaffBasicInfo> getStaffByPage(Page<StaffBasicInfoVO> page) {
        Page<StaffBasicInfo> pagination = new Page<>(page.getCurrent(), page.getSize());
        return staffBasicInfoMapper.selectPage(pagination, null);
    }

    @Override
    public List<StaffBasicInfo> getAllStaff() {
        return staffBasicInfoMapper.selectList(null);
    }

    @Override
    public StaffBasicInfo getStaffById(Long id) {
        return staffBasicInfoMapper.selectById(id);
    }

    @Override
    public boolean saveStaff(StaffBasicInfo staff) {
        return staffBasicInfoMapper.insert(staff) > 0;
    }

    @Override
    public boolean updateStaff(StaffBasicInfo staff) {
        return staffBasicInfoMapper.updateById(staff) > 0;
    }

    @Override
    public boolean deleteStaff(Long id) {
        return staffBasicInfoMapper.deleteById(id) > 0;
    }

}
