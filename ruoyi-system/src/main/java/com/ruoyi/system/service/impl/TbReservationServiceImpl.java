package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbReservationMapper;
import com.ruoyi.system.domain.TbReservation;
import com.ruoyi.system.service.ITbReservationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户预约Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-14
 */
@Service
public class TbReservationServiceImpl implements ITbReservationService 
{
    @Autowired
    private TbReservationMapper tbReservationMapper;

    /**
     * 查询用户预约
     * 
     * @param id 用户预约ID
     * @return 用户预约
     */
    @Override
    public TbReservation selectTbReservationById(Long id)
    {
        return tbReservationMapper.selectTbReservationById(id);
    }

    /**
     * 查询用户预约列表
     * 
     * @param tbReservation 用户预约
     * @return 用户预约
     */
    @Override
    public List<TbReservation> selectTbReservationList(TbReservation tbReservation)
    {
        return tbReservationMapper.selectTbReservationList(tbReservation);
    }

    /**
     * 新增用户预约
     * 
     * @param tbReservation 用户预约
     * @return 结果
     */
    @Override
    public int insertTbReservation(TbReservation tbReservation)
    {
        tbReservation.setCreateTime(DateUtils.getNowDate());
        return tbReservationMapper.insertTbReservation(tbReservation);
    }

    /**
     * 修改用户预约
     * 
     * @param tbReservation 用户预约
     * @return 结果
     */
    @Override
    public int updateTbReservation(TbReservation tbReservation)
    {
        tbReservation.setUpdateTime(DateUtils.getNowDate());
        return tbReservationMapper.updateTbReservation(tbReservation);
    }

    /**
     * 删除用户预约对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbReservationByIds(String ids)
    {
        return tbReservationMapper.deleteTbReservationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户预约信息
     * 
     * @param id 用户预约ID
     * @return 结果
     */
    @Override
    public int deleteTbReservationById(Long id)
    {
        return tbReservationMapper.deleteTbReservationById(id);
    }
}
