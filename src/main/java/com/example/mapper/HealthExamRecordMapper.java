package com.example.mapper;

import com.example.entity.ExamConclusion;
import com.example.entity.ExamItemResult;
import com.example.entity.HealthExamRecord;

import java.util.List;

/**
 * @author dragon
 * @date 2021/6/25
 */
public interface HealthExamRecordMapper {

    List<HealthExamRecord> list();


    List<ExamConclusion> listExamConclusion();

    List<ExamItemResult> listExamItemResult();
}
