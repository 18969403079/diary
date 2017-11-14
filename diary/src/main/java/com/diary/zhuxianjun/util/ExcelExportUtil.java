package com.diary.zhuxianjun.util;

import org.apache.poi.hssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 使用方法：
 *  1.创建一个Excel对象
 *  2.设定Sheet名字与数量
 *  3.
 * Created by BigPigMan on 2017/10/19 0019.
 */
public class ExcelExportUtil {

    /**
     * 创建一个excel对象
     * @return
     */
    public static HSSFWorkbook getExcel(){
        return new HSSFWorkbook();
    }


    /**
     * 传入字符串数组，使数组中每个字符串成为对应的cell中的值
     * @param sheet 要操作的sheet
     * @param rowNo 要操作的行号
     * @param values 要导出的数据
     * @param style 表格样式
     */
    public static void setCellValue(HSSFSheet sheet, int rowNo, List<String> values, HSSFCellStyle style){
        HSSFRow row = sheet.createRow(rowNo);
        for (int i = 0; i < values.size(); i++) {
            String value = values.get(i);
            if (value != null) {
                HSSFCell cell = row.createCell(i);
                cell.setCellValue(values.get(i));
                if (style != null) {
                    cell.setCellStyle(style);
                }
            }
        }
    }

    /**
     * 传入字符串数组，使数组中每个字符串成为对应的cell中的值
     * @param sheet 要操作的sheet
     * @param rowNo 要操作的行号
     * @param values 表格样式
     */
    public static void setCellValue(HSSFSheet sheet, int rowNo, List<String> values) {
        setCellValue(sheet, rowNo, values, null);
    }

    public static void main(String[] args) {
        int a = Calendar.SUNDAY;
        System.out.println("a = " + a);
    }

    /**
     * 保存Excel文件到指定的目录中
     * @param filePath
     */
    public static void saveExcelFile(HSSFWorkbook excel, String filePath ,String fileName) throws Exception {
        String allPath = filePath + fileName;
        FileOutputStream fout = new FileOutputStream(allPath);
        excel.write(fout);
        fout.close();
    }

    /**
     * 保存Excel文件，并弹出下载框可供选择下载路径
     * @param excel 要导出的Excel对象
     * @param defaultFileName 默认文件名
     * @param response
     * @throws Exception
     */
    public static  void saveExcelFile(HSSFWorkbook excel, String defaultFileName, HttpServletResponse response) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        excel.write(os);
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String((defaultFileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
    }

}
