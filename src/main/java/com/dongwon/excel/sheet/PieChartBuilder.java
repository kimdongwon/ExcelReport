package com.dongwon.excel.sheet;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PieChartBuilder implements ChartBuilder {
    private Map<String, PieChartData> valueMap = new HashMap<>();
    private int titleRow = -1;
    private int valueRow = -1;

    @Override
    public void setData(@Nonnull String title, int... value) {
        valueMap.put(title, new PieChartData(title, value[0]));
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
        Row valueRow = sheet.getRow(this.valueRow);
        AtomicInteger columnNum = new AtomicInteger(0);
        valueMap.values().forEach(v -> {
            int nowColumnNum = columnNum.getAndIncrement();
            if (v.value > 0) {
                titleRow.getCell(nowColumnNum).setCellValue(v.title);
                valueRow.getCell(nowColumnNum).setCellValue(v.value);
            }
        });
    }

    private class PieChartData {
        private String title;
        private int value;

        PieChartData(String title, int value) {
            this.title = title;
            this.value = value;
        }
    }
}
