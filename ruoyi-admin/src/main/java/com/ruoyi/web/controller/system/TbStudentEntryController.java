package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TbStudentEntry;
import com.ruoyi.system.service.ITbStudentEntryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生录入Controller
 *
 * @author ruoyi
 * @date 2020-05-15
 */
@Controller
@RequestMapping("/system/entry")
public class
TbStudentEntryController extends BaseController
{
    private String prefix = "system/entry";

    @Autowired
    private ITbStudentEntryService tbStudentEntryService;

    @Autowired
    private ISysRoleService sysRoleService;

    @RequiresPermissions("system:entry:view")
    @GetMapping()
    public String entry(ModelMap mmap)
    {
        if (getRole().getRoleId()==1){
            return prefix + "/entry";
        }else {
            return prefix + "/entry-user";
        }

    }

    /**
     * 查询学生录入列表
     */
    @RequiresPermissions("system:entry:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbStudentEntry tbStudentEntry)
    {
        startPage();
        List<TbStudentEntry> list = tbStudentEntryService.selectTbStudentEntryList(tbStudentEntry);
        return getDataTable(list);
    }

    /**
     * 导出学生录入列表
     */
    @RequiresPermissions("system:entry:export")
    @Log(title = "学生录入", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbStudentEntry tbStudentEntry)
    {
        List<TbStudentEntry> list = tbStudentEntryService.selectTbStudentEntryList(tbStudentEntry);
        ExcelUtil<TbStudentEntry> util = new ExcelUtil<TbStudentEntry>(TbStudentEntry.class);
        return util.exportExcel(list, "entry");
    }

    /**
     * 新增学生录入
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生录入
     */
    @RequiresPermissions("system:entry:add")
    @Log(title = "学生录入", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbStudentEntry tbStudentEntry)
    {
        if (getRole().getRoleId()!=1){
            TbStudentEntry tbStudentEntry1=new TbStudentEntry();
            tbStudentEntry1.setUserId(getUser().getUserId());
            List<TbStudentEntry> tbStudentEntryList = tbStudentEntryService.selectTbStudentEntryList(tbStudentEntry1);
            if (tbStudentEntryList.isEmpty()){
                return toAjax(tbStudentEntryService.insertTbStudentEntry(tbStudentEntry));
            }else {
                return AjaxResult.error("您已经录入过信息不能再次录入");
            }
        }
        tbStudentEntry.setUserId(getUser().getUserId());
        return toAjax(tbStudentEntryService.insertTbStudentEntry(tbStudentEntry));

    }

    /**
     * 修改学生录入
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbStudentEntry tbStudentEntry = tbStudentEntryService.selectTbStudentEntryById(id);
        mmap.put("tbStudentEntry", tbStudentEntry);
        return prefix + "/edit";

    }

    /**
     * 修改保存学生录入
     */
    @RequiresPermissions("system:entry:edit")
    @Log(title = "学生录入", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbStudentEntry tbStudentEntry)
    {
        return toAjax(tbStudentEntryService.updateTbStudentEntry(tbStudentEntry));

    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("entry", tbStudentEntryService.selectTbStudentEntryById(id));
        return prefix + "/detail";
    }

    /**
     * 删除学生录入
     */
    @RequiresPermissions("system:entry:remove")
    @Log(title = "学生录入", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbStudentEntryService.deleteTbStudentEntryByIds(ids));
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


    private SysRole getRole(){
        SysUser user = getUser();
        List<SysRole> sysRoleList = sysRoleService.selectRolesByUserId(user.getUserId());
        return sysRoleList.get(0);
    }


}
