package com.cydeo.library.tests;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    String path="Library.xlsx";
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    @Test
    public void excel_write() throws IOException {

        FileInputStream fileInputStream=new FileInputStream(path);
        workbook=new XSSFWorkbook(fileInputStream);
        sheet= workbook.getSheet("Employees");
        XSSFCell salaryCell=sheet.getRow(0).createCell(3);
        salaryCell.setCellValue("Salary");
        XSSFCell salary1=sheet.getRow(0).createCell(3);
        salary1.setCellValue(200000);
        XSSFCell salary2=sheet.getRow(1).createCell(3);
        salary2.setCellValue(300000);
        XSSFCell salary3=sheet.getRow(2).createCell(3);
        salary3.setCellValue(400000);
        XSSFCell salary4=sheet.getRow(3).createCell(3);
        salary4.setCellValue(500000);
        XSSFCell salary5=sheet.getRow(4).createCell(3);
        salary5.setCellValue(600000);
        for (int s = 0; s <sheet.getLastRowNum() ; s++) {
         if(   sheet.getRow(s).getCell(0).toString().equals("Mary")){
    sheet.getRow(s).getCell(1).setCellValue("Johns");}}
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();
    }
}
//It will work with Excel Write plugin