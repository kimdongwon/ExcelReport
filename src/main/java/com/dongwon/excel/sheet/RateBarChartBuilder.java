package com.dongwon.excel.sheet;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RateBarChartBuilder implements ChartBuilder {
    private Map<String, RateBarChartData> valueMap = new HashMap<>();
    private int titleRow = -1;
    private int valueRow = -1;

    public void setData(@Nonnull String title, int... value) {
        valueMap.put(title, new RateBarChartData(title, value));
    }

    @Override
    public void setTitleRow(int titleRow) {
        this.titleRow = titleRow;
    }

    @Override
    public void setValueRow(int valueRow) {
        this.valueRow = valueRow;
    }

    @Override
    public void build(Sheet sheet) {
        if (titleRow == -1 || valueRow == -1) {
            throw new IllegalStateException("not setting title orr value row");
        }
        Row titleRow = sheet.getRow(this.titleRow);
        Row value1Row = sheet.getRow(this.valueRow);
        Row value2Row = sheet.getRow(this.valueRow + 1);
        AtomicInteger columnNum = new AtomicInteger(0);
        valueMap.values().forEach(v -> {
            int nowColumnNum = columnNum.getAndIncrement();
            if (v.value != null && v.value.length == 2) {
                titleRow.getCell(nowColumnNum).setCellValue(v.title);
                value1Row.getCell(nowColumnNum).setCellValue(v.value[0]);
                value2Row.getCell(nowColumnNum).setCellValue(v.value[1]);
            }
        });
    }

    private class RateBarChartData {
        private String title;
        private int[] value;

        RateBarChartData(String title, int[] value) {
            this.title = title;
            this.value = value;
        }
    }
}
