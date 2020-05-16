package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TbStudentEntry;

/**
 * 学生录入Service接口
 * 
 * @author ruoyi
 * @date 2020-05-15
 */
public interface ITbStudentEntryService 
{
    /**
     * 查询学生录入
     * 
     * @param id 学生录入ID
     * @return 学生录入
     */
    public TbStudentEntry selectTbStudentEntryById(Long id);

    /**
     * 查询学生录入列表
     * 
     * @param tbStudentEntry 学生录入
     * @return 学生录入集合
     */
    public List<TbStudentEntry> selectTbStudentEntryList(TbStudentEntry tbStudentEntry);

    /**
     * 新增学生录入
     * 
     * @param tbStudentEntry 学生录入
     * @return 结果
     */
    public int insertTbStudentEntry(TbStudentEntry tbStudentEntry);

    /**
     * 修改学生录入
     * 
     * @param tbStudentEntry 学生录入
     * @return 结果
     */
    public int updateTbStudentEntry(TbStudentEntry tbStudentEntry);

    /**
     * 批量删除学生录入
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbStudentEntryByIds(String ids);

    /**
     * 删除学生录入信息
     * 
     * @param id 学生录入ID
     * @return 结果
     */
    public int deleteTbStudentEntryById(Long id);
}
