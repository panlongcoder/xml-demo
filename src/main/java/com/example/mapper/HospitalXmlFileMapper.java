package com.example.mapper;


import com.example.entity.HospitalXmlFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author dragon
 * @date 2021/6/24
 */
@Mapper
public interface HospitalXmlFileMapper {


    int insert(HospitalXmlFile xml);

    HospitalXmlFile selectOne(@Param("hospitalCode") String hospitalCode, @Param("type") Integer type);

    int update(@Param("hospitalCode") String hospitalCode, @Param("type") Integer type, @Param("content") String content);
}
