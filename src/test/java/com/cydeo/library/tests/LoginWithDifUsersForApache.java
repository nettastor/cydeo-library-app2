package com.cydeo.library.tests;
import com.cydeo.library.pages.LandingPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
//qa2_url=https://library2.cydeo.com/ - in configuration.properties
public class LoginWithDifUsersForApache {
    LoginPage loginPage=new LoginPage();
    LandingPage landingPage=new LandingPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),2);
    @Before
    public void set_up() throws IOException{
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));}
    @After
    public void tear_down(){
        Driver.closeDriver();}
    @Test
    public void login_different_users_librarians() throws IOException {
        String file_path="Library.xlsx";
        FileInputStream fileInputStream=new FileInputStream(file_path);
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fileInputStream);
        XSSFSheet employees=xssfWorkbook.getSheet("Employees");
        for (int i = 1; i <= employees.getLastRowNum(); i++) {
            String username=employees.getRow(i).getCell(0).toString();
            String password=employees.getRow(i).getCell(1).toString();
            String name=employees.getRow(i).getCell(2).toString();
            loginPage.login(username,password);
            wait.until(ExpectedConditions.visibilityOf(landingPage.userNameLink));
            String actualUserName = landingPage.userNameLink.getText();
            //After installing ExcelEditor plugin (Settings-Plugins-Marketplace-Install)
            //license is required
//            if(name.equals(actualUserName)){
//                System.out.println("Pass");
//                students.getRow(i).getCell(3).setCellValue("Pass");
//            }else{
//                System.out.println("Fail");
//                students.getRow(i).getCell(3).setCellValue("Fail");}
            Assert.assertEquals("For librarian: " + username+ " test failed!",name,actualUserName);
        landingPage.log_out();
          //  FileOutputStream fileOutputStream = new FileOutputStream(file_path);
//      xssfWorkbook.write(fileOutputStream);
//       fileInputStream.close();
//       xssfWorkbook.close();
            //        fileOutputStream.close();
        }}
        @Test
                public void login_different_users_students() throws IOException {
            String file_path="Library.xlsx";
            FileInputStream fileInputStream=new FileInputStream(file_path);
            XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fileInputStream);
            XSSFSheet students=xssfWorkbook.getSheet("Students");
        for (int i = 1; i <=students.getLastRowNum() ; i++) {
            String username=students.getRow(i).getCell(0).toString();
            String password=students.getRow(i).getCell(1).toString();
            String name=students.getRow(i).getCell(2).toString();
            loginPage.login(username,password);
            wait.until(ExpectedConditions.visibilityOf(landingPage.userNameLink));
            String actualUserName = landingPage.userNameLink.getText();
            //After installing ExcelEditor plugin (Settings-Plugins-Marketplace-Install) license is required
//            if(name.equals(actualUserName)){
//                System.out.println("Pass");
//                students.getRow(i).getCell(3).setCellValue("Pass");
//            }else{
//                System.out.println("Fail");
//                students.getRow(i).getCell(3).setCellValue("Fail");}
            Assert.assertEquals("For student: " + username+ " test failed!",name,actualUserName);
        landingPage.log_out();
//    FileOutputStream fileOutputStream = new FileOutputStream(file_path);
//      xssfWorkbook.write(fileOutputStream);
//       fileInputStream.close();
//       xssfWorkbook.close();
            //        fileOutputStream.close();
        }}}