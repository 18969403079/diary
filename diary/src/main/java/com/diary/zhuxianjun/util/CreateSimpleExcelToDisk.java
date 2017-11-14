package com.diary.zhuxianjun.util;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CreateSimpleExcelToDisk
{  
    /** 
     * @功能：手工构建一个简单格式的Excel 
     */  
    private static List<Student> getStudent() throws Exception  
    {  
        List list = new ArrayList();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Student user1 = new Student(1, "张三", 16, df.parse("1997-03-12"));
        Student user2 = new Student(2, "李四", 17, df.parse("1996-08-12"));  
        Student user3 = new Student(3, "王五", 26, df.parse("1985-11-12"));  
        list.add(user1);  
        list.add(user2);  
        list.add(user3);  

        return list;
    }


    public static void setRowAttribute(HSSFCell cell, HSSFCellStyle style, List<String> titles){

    }

    public static void main(String[] args) throws Exception
    {  
        // 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("学生表一");
        HSSFSheet sheet2 = wb.createSheet("学生表二");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow(10);
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFCell cell = row.createCell(0);
        cell.setCellValue(Calendar.getInstance());
        cell.setCellValue("学号");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);  
        cell = row.createCell(2);
        cell.setCellValue("年龄");  
        cell.setCellStyle(style);  
        cell = row.createCell(3);
        cell.setCellValue("生日");  
        cell.setCellStyle(style);  
  
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
        List list = CreateSimpleExcelToDisk.getStudent();  
  
        for (int i = 0; i < list.size(); i++)  
        {  
            row = sheet.createRow((int) i + 1);  
            Student stu = (Student) list.get(i);  
            // 第四步，创建单元格，并设置值  
            row.createCell(0).setCellValue((double) stu.getId());
            row.createCell(1).setCellValue(stu.getName());
            row.createCell(2).setCellValue("0.00000");
            cell = row.createCell(3);
            cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu
                    .getBirth()).toString());
        }  
        // 第六步，将文件存到指定位置  
        try  
        {
            FileOutputStream fout = new FileOutputStream("E:/students6.xls");
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
    }  
}  