package com.yash.api.rough;

import com.yash.api.utility.ExcelReader;

public class ValidateExcelReader {

    public static void main(String[] arge)
    {
        int rows,cols;
        String cellData;
        String userDir = System.getProperty("user.dir");
        ExcelReader excel = new ExcelReader(userDir + "/src/test/resources/testdata/testdata.xlsx");

        rows = excel.getRowCount("Sheet1")+1;
        cols = excel.getColumnCount("Sheet1");
        System.out.println("Rows: "+rows+" and columns: "+cols);
//        cellData = excel.getCellValue("Sheet1",1,1);
        for(int i=1;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                cellData = String.valueOf(excel.getCellData("Sheet1",i,j));
                System.out.println("Cell Data at i: "+i+" and j: "+j+" is: "+cellData);
            }
        }

    }

}
