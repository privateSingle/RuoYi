package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TbReservation;

/**
 * 用户预约Service接口
 * 
 * @author ruoyi
 * @date 2020-05-14
 */
public interface ITbReservationService 
{
    /**
     * 查询用户预约
     * 
     * @param id 用户预约ID
     * @return 用户预约
     */
    public TbReservation selectTbReservationById(Long id);

    /**
     * 查询用户预约列表
     * 
     * @param tbReservation 用户预约
     * @return 用户预约集合
     */
    public List<TbReservation> selectTbReservationList(TbReservation tbReservation);

    /**
     * 新增用户预约
     * 
     * @param tbReservation 用户预约
     * @return 结果
     */
    public int insertTbReservation(TbReservation tbReservation);

    /**
     * 修改用户预约
     * 
     * @param tbReservation 用户预约
     * @return 结果
     */
    public int updateTbReservation(TbReservation tbReservation);

    /**
     * 批量删除用户预约
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbReservationByIds(String ids);

    /**
     * 删除用户预约信息
     * 
     * @param id 用户预约ID
     * @return 结果
     */
    public int deleteTbReservationById(Long id);
}
