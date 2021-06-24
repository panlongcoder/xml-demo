package com.example.service;

import com.example.entity.HospitalXmlFile;
import com.example.mapper.HospitalXmlFileMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 职业病xml服务类
 *
 * @author dragon
 * @date 2021/6/24
 */
@Service
public class HospitalXmlFileService {

    @Resource
    private HospitalXmlFileMapper mapper;

    /**
     * 保存xml
     *
     * @param xmlFile xml文件对象
     * @return
     */
    public int save(HospitalXmlFile xmlFile) {
        return mapper.insert(xmlFile);
    }


    public HospitalXmlFile get(String hospitalCode, Integer type) {
        return mapper.selectOne(hospitalCode, type);
    }


    public int update(String hospitalCode, Integer type, String content) {
        return mapper.update(hospitalCode, type, content);

    }

}
