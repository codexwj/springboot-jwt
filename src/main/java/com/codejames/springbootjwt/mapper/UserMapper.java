package com.codejames.springbootjwt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codejames.springbootjwt.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
