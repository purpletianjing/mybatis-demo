package org.mybatis.example;

import org.apache.ibatis.type.Alias;

import java.util.Calendar;
import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private int age;
    private int gender;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public static int getMonthsBetweenDates(Date startDate, Date endDate)
    {
        if(startDate.getTime() > endDate.getTime())
        {
            Date temp = startDate;
            startDate = endDate;
            endDate = temp;
        }
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);

        int yearDiff = endCalendar.get(Calendar.YEAR)- startCalendar.get(Calendar.YEAR);
        int monthsBetween = endCalendar.get(Calendar.MONTH)-startCalendar.get(Calendar.MONTH) +12*yearDiff;

        if(endCalendar.get(Calendar.DAY_OF_MONTH) >= startCalendar.get(Calendar.DAY_OF_MONTH))
            monthsBetween = monthsBetween + 1;
        return monthsBetween;
    }

}
