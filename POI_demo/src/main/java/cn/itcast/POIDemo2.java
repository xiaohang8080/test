package cn.itcast;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;

/**
 * Demo class
 *
 * @author lxh
 * @date 19-8-30
 */

//创建一个excel并且向里面随便写一句话
public class POIDemo2 {
    /*
    HSSFWorkbook  工作簿		一个Excel文件
    HSSFSheet	  工作表		Excel中的工作表
    HSSFRow		  行			每个工作表的行
    HSSFCell	  单元格		每个行中的单元格
    HSSFCellStyle 单元格样式
    */
    public static void main(String[] args) throws Exception {
        //    1.创建一个全新的工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //    2.创建一个工作表
        HSSFSheet sheet = workbook.createSheet("测试");
        //        设置列宽
        sheet.setColumnWidth(0,17*256); // 单位 1代表一个字母的256分之一
        //    3.创建第一行
        HSSFRow row = sheet.createRow(0);
        //    4.创建第一个单元格
        HSSFCell cell = row.createCell(0);
        //    5.向单元格中输入一句话
        cell.setCellValue("这是我第一次玩POI");
        //    6.把excel输出到磁盘上
        workbook.write(new FileOutputStream("D://aaaaaaaaaa//demo2.xls"));
        //    7.关闭流
        workbook.close();
    }
}
