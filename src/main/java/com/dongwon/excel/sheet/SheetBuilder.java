package com.dongwon.excel.sheet;

import com.dongwon.excel.type.ExcelType;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface SheetBuilder {
    void build(Sheet sheet);
}
