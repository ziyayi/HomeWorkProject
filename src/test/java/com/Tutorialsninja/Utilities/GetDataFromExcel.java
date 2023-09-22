package com.Tutorialsninja.Utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetDataFromExcel {
    private Sheet workSheet;
    private Workbook workbook;


    public List<Map<String, String>> getDataList(String pathFile) throws IOException {
        String path = pathFile;

        FileInputStream fileInputStream=new FileInputStream(path);

         workbook= WorkbookFactory.create(fileInputStream);

         workSheet=workbook.getSheetAt(0);

        List<String> columns = getColumnsNames();

        List<Map<String, String>> data = new ArrayList<>();
        for (int i = 1; i < rowCount(); i++) {

            Row row = workSheet.getRow(i);

            Map<String, String> rowMap = new HashMap<String, String>();
            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());
            }
            data.add(rowMap);
        }
        return data;
    }

    public int rowCount() {
        return workSheet.getLastRowNum()+1;
    }
    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();
        for (Cell cell : workSheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }
}
