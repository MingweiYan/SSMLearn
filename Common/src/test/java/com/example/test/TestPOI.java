package com.example.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class TestPOI {

    @Ignore
    @Test
    public void importExcel() throws IOException {
        //在内存中创建一个Excel文件
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作表，指定工作表名称
        XSSFSheet sheet = workbook.createSheet("尚硅谷");

        //创建行，0表示第一行
        XSSFRow row = sheet.createRow(0);
        //创建单元格，0表示第一个单元格
        row.createCell(0).setCellValue("编号");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("年龄");

        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("1");
        row1.createCell(1).setCellValue("小明");
        row1.createCell(2).setCellValue("10");

        XSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("2");
        row2.createCell(1).setCellValue("小王");
        row2.createCell(2).setCellValue("20");

        //通过输出流将workbook对象下载到磁盘
        FileOutputStream out = new FileOutputStream("D:\\atguigu.xlsx");
        workbook.write(out);
        out.flush();//刷新
        out.close();//关闭
        workbook.close();
    }
    @Ignore
    @Test
    public void readExcel() throws IOException {
        // 先创建流 防止报错
        FileInputStream fileInputStream = new FileInputStream("D:\\atguigu.xlsx");
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        //获取工作表，既可以根据工作表的顺序获取，也可以根据工作表的名称获取
        XSSFSheet sheet = workbook.getSheetAt(0);
        //遍历工作表获得行对象
        for (Row row : sheet) {
            //遍历行对象获取单元格对象
            for (Cell cell : row) {
                //获得单元格中的值
                String value = cell.getStringCellValue(); //注意：数字类型,需要修改excel单元格的类型，否则报错。
                System.out.println(value);// new String(value.getBytes("UTF-8"),"GBK"));

            }
        }
        workbook.close();
    }

    @After
    public void delete_file(){
        {
            try{
                File file = new File("D:\\atguigu.xlsx");
                if(file.delete()){
                    System.out.println(file.getName() + " 文件已被删除！");
                }else{
                    System.out.println("文件删除失败！");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
