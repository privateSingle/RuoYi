package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户预约对象 tb_reservation
 * 
 * @author ruoyi
 * @date 2020-05-14
 */
public class TbReservation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 年龄 */
    @Excel(name = "年龄")
    private Integer age;

    /** 学校名称 */
    @Excel(name = "学校名称")
    private String schoolName;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String className;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 接待时间 */
    @Excel(name = "接待时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receptionTime;

    /** 是否通过 1.是 0.否 */
    @Excel(name = "是否通过 1.是 0.否")
    private Integer isPassed;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAge(Integer age) 
    {
        this.age = age;
    }

    public Integer getAge() 
    {
        return age;
    }
    public void setSchoolName(String schoolName) 
    {
        this.schoolName = schoolName;
    }

    public String getSchoolName() 
    {
        return schoolName;
    }
    public void setClassName(String className) 
    {
        this.className = className;
    }

    public String getClassName() 
    {
        return className;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setReceptionTime(Date receptionTime) 
    {
        this.receptionTime = receptionTime;
    }

    public Date getReceptionTime() 
    {
        return receptionTime;
    }
    public void setIsPassed(Integer isPassed) 
    {
        this.isPassed = isPassed;
    }

    public Integer getIsPassed() 
    {
        return isPassed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("name", getName())
            .append("age", getAge())
            .append("schoolName", getSchoolName())
            .append("className", getClassName())
            .append("phone", getPhone())
            .append("receptionTime", getReceptionTime())
            .append("isPassed", getIsPassed())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
