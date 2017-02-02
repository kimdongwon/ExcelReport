package com.dongwon.excel.sheet;

public class CellPoint {
    private final String SPELL = "abcdefghijklmnopqrstuvxyz";
    private int rowNum;
    private int columnNum;

    public CellPoint(int rowNum, Character column) {
        this.rowNum = rowNum - 1;
        this.columnNum = SPELL.indexOf(column);
    }

    public CellPoint(String point) {
        this(Character.getNumericValue(point.charAt(0)), point.charAt(1));
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getColumnNum() {
        return columnNum;
    }
}
