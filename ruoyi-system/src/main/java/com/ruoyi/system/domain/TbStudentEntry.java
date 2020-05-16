package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生录入对象 tb_student_entry
 * 
 * @author ruoyi
 * @date 2020-05-15
 */
public class TbStudentEntry extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 考生号 */
    @Excel(name = "考生号")
    private String num;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** qq */
    @Excel(name = "qq")
    private String qq;

    /** 成绩 */
    @Excel(name = "成绩")
    private String grade;

    /** 问题分类 */
    @Excel(name = "问题分类")
    private String questionClass;

    /** 咨询 */
    @Excel(name = "咨询")
    private String advisory;

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
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setNum(String num) 
    {
        this.num = num;
    }

    public String getNum() 
    {
        return num;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setQq(String qq) 
    {
        this.qq = qq;
    }

    public String getQq() 
    {
        return qq;
    }
    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
    }
    public void setQuestionClass(String questionClass) 
    {
        this.questionClass = questionClass;
    }

    public String getQuestionClass() 
    {
        return questionClass;
    }
    public void setAdvisory(String advisory) 
    {
        this.advisory = advisory;
    }

    public String getAdvisory() 
    {
        return advisory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("province", getProvince())
            .append("num", getNum())
            .append("phone", getPhone())
            .append("qq", getQq())
            .append("grade", getGrade())
            .append("questionClass", getQuestionClass())
            .append("advisory", getAdvisory())
            .append("remark", getRemark())
            .toString();
    }
}
