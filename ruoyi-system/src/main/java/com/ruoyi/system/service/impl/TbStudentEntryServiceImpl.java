package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbStudentEntryMapper;
import com.ruoyi.system.domain.TbStudentEntry;
import com.ruoyi.system.service.ITbStudentEntryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生录入Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-15
 */
@Service
public class TbStudentEntryServiceImpl implements ITbStudentEntryService 
{
    @Autowired
    private TbStudentEntryMapper tbStudentEntryMapper;

    /**
     * 查询学生录入
     * 
     * @param id 学生录入ID
     * @return 学生录入
     */
    @Override
    public TbStudentEntry selectTbStudentEntryById(Long id)
    {
        return tbStudentEntryMapper.selectTbStudentEntryById(id);
    }

    /**
     * 查询学生录入列表
     * 
     * @param tbStudentEntry 学生录入
     * @return 学生录入
     */
    @Override
    public List<TbStudentEntry> selectTbStudentEntryList(TbStudentEntry tbStudentEntry)
    {
        return tbStudentEntryMapper.selectTbStudentEntryList(tbStudentEntry);
    }

    /**
     * 新增学生录入
     * 
     * @param tbStudentEntry 学生录入
     * @return 结果
     */
    @Override
    public int insertTbStudentEntry(TbStudentEntry tbStudentEntry)
    {
        return tbStudentEntryMapper.insertTbStudentEntry(tbStudentEntry);
    }

    /**
     * 修改学生录入
     * 
     * @param tbStudentEntry 学生录入
     * @return 结果
     */
    @Override
    public int updateTbStudentEntry(TbStudentEntry tbStudentEntry)
    {
        return tbStudentEntryMapper.updateTbStudentEntry(tbStudentEntry);
    }

    /**
     * 删除学生录入对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbStudentEntryByIds(String ids)
    {
        return tbStudentEntryMapper.deleteTbStudentEntryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生录入信息
     * 
     * @param id 学生录入ID
     * @return 结果
     */
    @Override
    public int deleteTbStudentEntryById(Long id)
    {
        return tbStudentEntryMapper.deleteTbStudentEntryById(id);
    }
}
