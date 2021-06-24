package com.example.mapper;


import com.example.entity.EnterpriseInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用人单位信息Mapper
 *
 * @author dragon
 * @date 2021/6/24
 */
@Mapper
public interface EnterpriseInfoMapper {

    /**
     * 查询健康证申报 所有符合条件的 用人单位信息
     *
     * @return
     */
    List<EnterpriseInfo> list();

}
