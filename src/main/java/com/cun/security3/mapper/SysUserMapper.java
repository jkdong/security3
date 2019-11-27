package com.cun.security3.mapper;

import com.cun.security3.bean.SelfUserDetails;
import org.apache.ibatis.annotations.*;

import java.util.Map;

/**
 * mapper的具体表达式
 */
public interface SysUserMapper {


    /**
     * 查询用户名是否存在，若存在，不允许注册
     * @param userName
     * @return
     */
    Map findUserByName(@Param("userName") String userName);

    /**
     * 注册  插入一条user记录
     * @param user
     * @return
     */
    @Insert("insert into user values(#{id},#{username},#{password})")
    //加入该注解可以保存对象后，查看对象插入id
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void regist(SelfUserDetails user);

}
