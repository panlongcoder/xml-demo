package com.example.mapper;

import com.example.entity.ExamConclusion;
import com.example.entity.ExamItemResult;
import com.example.entity.HealthExamRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dragon
 * @date 2021/6/25
 */
public interface HealthExamRecordMapper {

    List<HealthExamRecord> list();

    List<ExamConclusion> listExamConclusion(@Param("tjh000") String tjh000);

    List<ExamItemResult> listExamItemResult(@Param("tjh000") String tjh000);
}
