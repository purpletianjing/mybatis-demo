package com.mybatis.test;

import org.apache.ibatis.annotations.Param;
import org.mybatis.example.User;

import java.util.List;

public interface IUserMapper {
    List<User> selectUser();

    //    int insertUser(User user);
    List<User> selectUserByIdAndNameList(@Param("idList")List<Integer> idList, @Param("nameList") List<String> nameList);
    List<User> selectUserByIdAndNameList2(List<Integer> idList, List<String> nameList);

    List<User> selectLikeIfElse(@Param("name") String name, @Param("age") int age, @Param("gender") int gender);

    List<User> selectUserByNameAndAgeList(@Param("users") List<User> users);
}
