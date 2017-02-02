package com.dongwon.excel.sheet;

import org.apache.poi.ss.usermodel.Sheet;

import javax.annotation.Nonnull;

public interface ChartBuilder extends SheetBuilder {
    void setData(@Nonnull String title, int...value);
    void setTitleRow(int titleRow);
    void setValueRow(int valueRow);
    void build(Sheet sheet);
}
