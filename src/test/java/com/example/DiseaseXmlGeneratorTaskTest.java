package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileNotFoundException;

/**
 * @author dragon
 * @date 2021/6/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiseaseXmlGeneratorTaskTest {

    @Resource
    private DiseaseXmlGeneratorTask task;


    @Test
    public void testGenerateEnterpriseInfo() throws FileNotFoundException {
        task.generateEnterpriseInfoXml();
    }
}
