package org.yejh.shop.dao.mapping;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.yejh.shop.entity.CourseBean;

import java.util.List;

/**
 * @author Ye Jiahao
 * @create 2019-05-06
 * @since 4.0
 */
public interface CourseMapper {
    @Select("SELECT cname, cname_zh_CN, cdescription, create_time, update_time FROM course_info")
    @Results({
            @Result(property = "name", column = "cname"),
            @Result(property = "nameZhCN", column = "cname_zh_CN"),
            @Result(property = "description", column = "cdescription"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    List<CourseBean> listCourse();

    @Select("SELECT COUNT(*) FROM course_info")
    long countCourse();
}
