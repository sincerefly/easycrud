package org.yasking.easycrud.data.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//@Mapper 使用 MapperScan指定扫描目录后无需在每个接口上写 Mapper注解
@Repository
public interface MysqlMapper {

//    @Select("select version()")
//    public String getVersion();

    public String getVersion();
}
