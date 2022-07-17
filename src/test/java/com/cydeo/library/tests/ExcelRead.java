package com.cydeo.library.tests;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelRead {
    @Test
            public void read_from_excel_file() throws IOException {
        String path="Library.xlsx";
        File file=new File(path);
        FileInputStream fileInputStream=new FileInputStream(file);
        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet1=workbook.getSheet("Emloyees");
        XSSFSheet xssfSheet2=workbook.getSheet("Students");
        System.out.println(xssfSheet1.getRow(1).getCell(0));
        System.out.println(xssfSheet2.getRow(1).getCell(0));
int used_rows_employees=xssfSheet1.getPhysicalNumberOfRows();
        System.out.println(used_rows_employees);
        int used_rows_students=xssfSheet2.getPhysicalNumberOfRows();
        System.out.println(used_rows_students);
        int last_used_raw_employees=xssfSheet1.getLastRowNum();
        System.out.println(last_used_raw_employees);
        int last_used_raw_students=xssfSheet2.getLastRowNum();
        System.out.println(last_used_raw_students);
        for (int i = 0; i < last_used_raw_employees; i++) {
            if(xssfSheet1.getRow(i).getCell(0).toString().equals("librarian13@library")){
                System.out.println(xssfSheet1.getRow(i).getCell(0));
            }
        }

    }

}
