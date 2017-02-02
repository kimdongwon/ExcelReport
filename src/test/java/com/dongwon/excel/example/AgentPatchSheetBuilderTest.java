package com.dongwon.excel.example;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class AgentPatchSheetBuilderTest {

    @Test
    public void 에이전트_패치_xls_보고서_생성() throws Exception {
        File outputFile = new File("output.xls");
        if (outputFile.exists()) {
            outputFile.delete();
        }
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("AgentPatch.xls");
        Workbook wb = new HSSFWorkbook(inputStream);
        inputStream.close();
        Sheet sheet = wb.getSheetAt(0);

        AgentPatchSheetBuilder builder = new AgentPatchSheetBuilder();
        builder.setData(createSampleData()).build(sheet);

        FileOutputStream fileOut = new FileOutputStream(outputFile);
        wb.write(fileOut);
        fileOut.close();
        assertTrue(outputFile.exists());
    }

    @Test
    public void 에이전트_패치_xlsx_보고서_생성() throws Exception {
        File outputFile = new File("output.xlsx");
        if (outputFile.exists()) {
            outputFile.delete();
        }
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("AgentPatch.xlsx");
        Workbook wb = new XSSFWorkbook(inputStream);
        inputStream.close();
        Sheet sheet = wb.getSheetAt(0);

        AgentPatchSheetBuilder builder = new AgentPatchSheetBuilder();
        builder.setData(createSampleData()).build(sheet);

        FileOutputStream fileOut = new FileOutputStream(outputFile);
        wb.write(fileOut);
        fileOut.close();
        assertTrue(outputFile.exists());
    }

    public List<AgentPatchData> createSampleData() {
        List<AgentPatchData> insertDataList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; ++i) {
            AgentPatchData item = new AgentPatchData("name" + random.nextInt(99990), "computer" + random.nextInt(9999), "dep1", "dep2", "dep3", null, random.nextInt(100), random.nextInt(100));
            insertDataList.add(item);
        }
        return insertDataList;
    }
}