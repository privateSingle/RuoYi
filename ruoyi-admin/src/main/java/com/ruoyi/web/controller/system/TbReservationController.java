package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.web.controller.vo.TbReservationVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TbReservation;
import com.ruoyi.system.service.ITbReservationService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户预约Controller
 *
 * @author ruoyi
 * @date 2020-05-14
 */
@Controller
@RequestMapping("/system/reservation")
public class TbReservationController extends BaseController
{
    private String prefix = "system/reservation";

    @Autowired
    private ITbReservationService tbReservationService;

    @Autowired
    private ISysRoleService sysRoleService;

    @RequiresPermissions("system:reservation:view")
    @GetMapping()
    public String reservation() {

        SysUser user = getUser();
        List<SysRole> sysRoleList = sysRoleService.selectRolesByUserId(user.getUserId());
        if (sysRoleList.get(0).getRoleId()==1){
            return prefix + "/reservation-admin";
        }else {
            return prefix + "/reservation";
        }

    }

    /**
     * 查询用户预约列表
     */
    @RequiresPermissions("system:reservation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbReservation tbReservation)
    {
        startPage();
        SysUser user = getUser();
        //查询是否是管理员
        List<SysRole> sysRoleList = sysRoleService.selectRolesByUserId(user.getUserId());
        //判断是否是管理员
        Boolean isAdmin=false;
        for (SysRole sysRole : sysRoleList) {

            if (sysRole.getRoleId()==1){
                isAdmin=true;
                break;
            }
        }
        if (isAdmin){
            //管理员数据
            List<TbReservation> list = tbReservationService.selectTbReservationList(tbReservation);
            List<TbReservationVo> collect = list.stream().map(res -> {
                TbReservationVo tbReservationVo = new TbReservationVo();
                tbReservationVo.setId(res.getId());
                tbReservationVo.setUserId(res.getUserId());
                tbReservationVo.setName(res.getName());
                tbReservationVo.setAge(res.getAge());
                tbReservationVo.setSchoolName(res.getSchoolName());
                tbReservationVo.setClassName(res.getClassName());
                tbReservationVo.setPhone(res.getPhone());
                tbReservationVo.setReceptionTime(res.getReceptionTime());
                if (res.getIsPassed() == 1) {
                    tbReservationVo.setIsPassed("是");
                } else if (res.getIsPassed() == 0) {
                    tbReservationVo.setIsPassed("否");
                }
                return tbReservationVo;


            }).collect(Collectors.toList());
            return getDataTable(collect);
        }else {
            //用户数据
            tbReservation.setUserId(user.getUserId());
            List<TbReservation> list = tbReservationService.selectTbReservationList(tbReservation);
            List<TbReservationVo> collect = list.stream().map(res -> {
                TbReservationVo tbReservationVo = new TbReservationVo();
                tbReservationVo.setId(res.getId());
                tbReservationVo.setUserId(res.getUserId());
                tbReservationVo.setName(res.getName());
                tbReservationVo.setAge(res.getAge());
                tbReservationVo.setSchoolName(res.getSchoolName());
                tbReservationVo.setClassName(res.getClassName());
                tbReservationVo.setPhone(res.getPhone());
                tbReservationVo.setReceptionTime(res.getReceptionTime());
                if (res.getIsPassed() == 1) {
                    tbReservationVo.setIsPassed("是");
                } else if (res.getIsPassed() == 0) {
                    tbReservationVo.setIsPassed("否");
                }
                return tbReservationVo;


            }).collect(Collectors.toList());
            return getDataTable(collect);
        }

    }

    /**
     * 导出用户预约列表
     */
    @RequiresPermissions("system:reservation:export")
    @Log(title = "用户预约", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbReservation tbReservation)
    {
        List<TbReservation> list = tbReservationService.selectTbReservationList(tbReservation);
        ExcelUtil<TbReservation> util = new ExcelUtil<TbReservation>(TbReservation.class);
        return util.exportExcel(list, "reservation");
    }

    /**
     * 新增用户预约
     */
    @GetMapping("/add")
    public String add()
    {

        SysUser user = getUser();
        List<SysRole> sysRoleList = sysRoleService.selectRolesByUserId(user.getUserId());
        if (sysRoleList.get(0).getRoleId()==1){
            return prefix + "/add-admin";
        }else {
            return prefix + "/add";
        }



    }

    /**
     * 新增保存用户预约
     */
    @RequiresPermissions("system:reservation:add")
    @Log(title = "用户预约", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbReservation tbReservation)
    {
        SysUser user = getUser();
        tbReservation.setIsPassed(0);
        tbReservation.setUserId(user.getUserId());
        tbReservation.setReceptionTime(null);
        return toAjax(tbReservationService.insertTbReservation(tbReservation));
    }

    /**
     * 修改用户预约
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbReservation tbReservation = tbReservationService.selectTbReservationById(id);
        mmap.put("tbReservation", tbReservation);
        SysUser user = getUser();
        List<SysRole> sysRoleList = sysRoleService.selectRolesByUserId(user.getUserId());
        if (sysRoleList.get(0).getRoleId()==1){
            return prefix + "/edit-admin";
        }else {
            return prefix + "/edit";
        }


    }

    /**
     * 修改保存用户预约
     */
    @RequiresPermissions("system:reservation:edit")
    @Log(title = "用户预约", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbReservation tbReservation)
    {
        return toAjax(tbReservationService.updateTbReservation(tbReservation));
    }

    /**
     * 删除用户预约
     */
    @RequiresPermissions("system:reservation:remove")
    @Log(title = "用户预约", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbReservationService.deleteTbReservationByIds(ids));
    }


    /**
     * 获取登录用户
     * @return
     */
    private SysUser getUser(){
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser =(SysUser) subject.getPrincipal();
        return sysUser;
    }
}
