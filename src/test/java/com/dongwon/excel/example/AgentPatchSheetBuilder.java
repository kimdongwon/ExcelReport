package com.dongwon.excel.example;

import com.dongwon.excel.ExcelUtils;
import com.dongwon.excel.sheet.CellPoint;
import com.dongwon.excel.sheet.PieChartBuilder;
import com.dongwon.excel.sheet.SheetBuilder;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;
import java.util.stream.IntStream;

public class AgentPatchSheetBuilder implements SheetBuilder {
    private final CellPoint reportPeriodCellPoint = new CellPoint(4, 'A');
    private final CellPoint printDateCellPoint = new CellPoint(4, 'F');
    private final CellPoint targetAgentCellPoint = new CellPoint(10, 'A');
    private final CellPoint targetPatchCountCellPoint = new CellPoint(11, 'A');
    private final PieChartBuilder pieChartBuilder = new PieChartBuilder();
    private final int TABLE_TEMPLATE_ROW = 25;
    private List<AgentPatchData> data;

    public AgentPatchSheetBuilder setData(List<AgentPatchData> data) {
        this.data = data;
        return this;
    }

    @Override
    public void build(Sheet sheet) {
        IntStream.range(1, data.size())
                .forEach(v -> {
                    int now = TABLE_TEMPLATE_ROW + v;
                    ExcelUtils.copyRow(sheet, TABLE_TEMPLATE_ROW, now);
                });

        int applyCount = data.stream().mapToInt(AgentPatchData::getApplyCount).sum();
        int notApplyCount = data.stream().mapToInt(AgentPatchData::getNotApplyCount).sum();
        IntStream.range(0, data.size())
                .forEach(v -> {
                    int now = TABLE_TEMPLATE_ROW + v;
                    Row nowRow = sheet.getRow(now);
                    AgentPatchData item = data.get(v);
                    nowRow.getCell(0).setCellValue(item.getName());
                    nowRow.getCell(1).setCellValue(item.getComputer());
                    nowRow.getCell(2).setCellValue(item.getDep1());
                    nowRow.getCell(3).setCellValue(item.getDep2());
                    nowRow.getCell(4).setCellValue(item.getDep3());
                    nowRow.getCell(5).setCellValue(item.getDep4());
                    nowRow.getCell(6).setCellValue(item.getApplyCount());
                    nowRow.getCell(7).setCellValue(item.getNotApplyCount());
                });

        pieChartBuilder.setTitleRow(16);
        pieChartBuilder.setValueRow(17);
        pieChartBuilder.setData("적용", applyCount);
        pieChartBuilder.setData("미적용", notApplyCount);
        pieChartBuilder.build(sheet);
    }
}
