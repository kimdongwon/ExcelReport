package com.dongwon.excel.chart;

import org.apache.poi.ss.usermodel.Sheet;

import javax.annotation.Nonnull;

public interface ChartBuilder {
    void setData(@Nonnull String title, int...value);
    void setTitleRow(int titleRow);
    void setValueRow(int valueRow);
    void build(Sheet sheet);
}
