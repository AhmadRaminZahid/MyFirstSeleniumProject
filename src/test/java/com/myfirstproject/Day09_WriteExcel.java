package com.myfirstproject;

import Utilities.TestBase;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day09_WriteExcel {
    @Test
    public void writeExcelTest(){
//        Store the path of the file as string and open the file
        String path = "resources/Capitals.xlsx";
//        Open the workbook
        try {
            FileInputStream fis= new FileInputStream(path);
            System.out.println("File size: " + fis.available());
            Workbook workbook= WorkbookFactory.create(fis);

//        Open the first worksheet
           Sheet sheet1= workbook.getSheetAt(0); //index starts from 0
           //Sheet sheet1= workbook.getSheet("sheet1");// use the title of the sheet as well

//        Go to the first row
            Row row1 = sheet1.getRow(0);// returns first row
//
//        Create a cell on the 3rd column (2nd index) on the first row
            Cell r1c3= row1.createCell(2);
//        Write "POPULATION" on that cell
            r1c3.setCellValue("POPULATION");
//        Create a cell on the 2nd row 3rd cell(index2), and write 150000
//        Create a cell on the 3rd row 3rd cell(index2), and write 250000
//        Create a cell on the 4th row 3rd cell(index2), and write 54000
           // Write and save the workbook
            //without following 4 steps ,we cannot send and write anything in excel
            FileOutputStream fos = new FileOutputStream(path);
            workbook.write(fos);
//        Close the file
            fos.close();
            fis.close();
//        Close the workbook
            workbook.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
