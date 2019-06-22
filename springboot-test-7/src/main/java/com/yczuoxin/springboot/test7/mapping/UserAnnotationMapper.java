package com.yczuoxin.springboot.test7.mapping;

import com.yczuoxin.springboot.test7.entry.User;
import org.apache.ibatis.annotations.Select;

public interface UserAnnotationMapper {
    @Select({"select * from user where id = #{}"})
    User selectById();
}
