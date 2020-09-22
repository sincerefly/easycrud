package org.yasking.easycrud.data.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface PgMapper {
    @Select("select version()")
    public String getVersion();
}
