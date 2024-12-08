package com.kang.kangtemplate.controller.staff;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.kangtemplate.common.BaseResponse;
import com.kang.kangtemplate.common.ErrorCodeEnum;
import com.kang.kangtemplate.common.ResultUtils;
import com.kang.kangtemplate.model.staff.entity.StaffBasicInfo;
import com.kang.kangtemplate.model.staff.req.StaffBasicInfoReq;
import com.kang.kangtemplate.model.staff.vo.StaffBasicInfoVO;
import com.kang.kangtemplate.service.StaffBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 职员基本信息 controller
 * @author: liukang
 * @date: 2024/12/08 13:05:04
 */
@RestController
@RequestMapping("/staff")
public class StaffBasicInfoController {

    @Autowired
    private StaffBasicInfoService staffBasicInfoService;

    @GetMapping("/getStaffWithParamsByPage")
    public BaseResponse<Page<StaffBasicInfoVO>> getStaffWithParamsByPage(StaffBasicInfoReq staffBasicInfoReq,
                                                                          Page<StaffBasicInfoVO> page) {
        Page<StaffBasicInfoVO> staffPage = staffBasicInfoService.getStaffWithParamsByPage(staffBasicInfoReq, page);
        return ResultUtils.success(staffPage);
    }

    /**
     * 分页获取员工信息
     */
    @PostMapping("/page")
    public BaseResponse<Page<StaffBasicInfo>> getStaffByPage(@RequestBody Page<StaffBasicInfoVO> page) {
        Page<StaffBasicInfo> staffPage = staffBasicInfoService.getStaffByPage(page);
        return ResultUtils.success(staffPage);
    }

    /**
     * 获取所有员工信息
     */
    @GetMapping("/all")
    public BaseResponse<List<StaffBasicInfo>> getAllStaff() {
        List<StaffBasicInfo> staffList = staffBasicInfoService.getAllStaff();
        return ResultUtils.success(staffList);
    }

    /**
     * 根据 ID 获取员工信息
     */
    @GetMapping("/{id}")
    public BaseResponse<StaffBasicInfo> getStaffById(@PathVariable Long id) {
        StaffBasicInfo staff = staffBasicInfoService.getStaffById(id);
        if (staff == null) {
            return ResultUtils.error(ErrorCodeEnum.NOT_FOUND, "员工信息不存在");
        }
        return ResultUtils.success(staff);
    }

    /**
     * 保存员工信息
     */
    @PostMapping("/save")
    public BaseResponse<Void> saveStaff(@RequestBody StaffBasicInfo staff) {
        boolean result = staffBasicInfoService.saveStaff(staff);
        if (result) {
            return ResultUtils.success(null, "保存成功");
        }
        return ResultUtils.error(ErrorCodeEnum.INTERNAL_SERVER_ERROR, "保存失败");
    }

    /**
     * 更新员工信息
     */
    @PutMapping("/update")
    public BaseResponse<Void> updateStaff(@RequestBody StaffBasicInfo staff) {
        boolean result = staffBasicInfoService.updateStaff(staff);
        if (result) {
            return ResultUtils.success(null, "更新成功");
        }
        return ResultUtils.error(ErrorCodeEnum.INTERNAL_SERVER_ERROR, "更新失败");
    }

    /**
     * 根据 ID 删除员工信息
     */
    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteStaff(@PathVariable Long id) {
        boolean result = staffBasicInfoService.deleteStaff(id);
        if (result) {
            return ResultUtils.success(null, "删除成功");
        }
        return ResultUtils.error(ErrorCodeEnum.INTERNAL_SERVER_ERROR, "删除失败");
    }
}
