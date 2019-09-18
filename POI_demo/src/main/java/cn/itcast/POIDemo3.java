package cn.itcast;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

/**
 * Demo class
 *
 * @author lxh
 * @date 19-8-30
 */

//读取一个excel并且向里面随便写一句话
public class POIDemo3 {
    /*
    XSSFWorkbook  工作簿		一个Excel文件
    XSSFSheet	  工作表		Excel中的工作表
    XSSFRow		  行			每个工作表的行
    XSSFCell	  单元格		每个行中的单元格
    XSSFCellStyle 单元格样式
    */
    public static void main(String[] args) throws Exception {
        //    1.读取一个全新的工作簿
        XSSFWorkbook workbook = new XSSFWorkbook("D://aaaaaaaaaa//demo.xlsx");
        //    2.获取一个工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //    3.获取第一行
        XSSFRow row = sheet.getRow(0);
        //    4.获取第一个单元格
        XSSFCell cell = row.getCell(0);
        //    5.读取单元格内容
        String stringCellValue = cell.getStringCellValue();
        //    6.把excel输出到内存
        System.out.println(stringCellValue);
        //    7.关闭流
        workbook.close();
    }
}
