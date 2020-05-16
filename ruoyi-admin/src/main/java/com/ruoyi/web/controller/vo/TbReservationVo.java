package com.ruoyi.web.controller.vo;

import com.ruoyi.common.annotation.Excel;

import java.util.Date;

/**
 * @author: dalele
 * @date: 2020/5/15 15:40
 * @description:
 */
public class TbReservationVo {
    /** id */
    private Long id;

    /** 用户id */

    private Long userId;

    /** 姓名 */

    private String name;

    /** 年龄 */

    private Integer age;

    /** 学校名称 */

    private String schoolName;

    /** 班级名称 */

    private String className;

    /** 手机号 */

    private String phone;

    /** 接待时间 */

    private Date receptionTime;

    /** 是否通过 1.是 0.否 */

    private String isPassed;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getReceptionTime() {
        return receptionTime;
    }

    public void setReceptionTime(Date receptionTime) {
        this.receptionTime = receptionTime;
    }

    public String getIsPassed() {
        return isPassed;
    }

    public void setIsPassed(String isPassed) {
        this.isPassed = isPassed;
    }


    
}
