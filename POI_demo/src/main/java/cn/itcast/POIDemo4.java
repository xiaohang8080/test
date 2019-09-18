package cn.itcast;

import cn.itcast.domain.cargo.ContractProduct;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Demo class
 * 读取一个Excel中的数据
 * @author lxh
 * @date 19-8-31
 */
public class POIDemo4 {
    public static void main(String[] args) throws IOException {
        //1获取一个工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("D://aaaaaaaaaa//UploadTemplete.xlsx"));
        //2获取一个工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //3获取行,需要遍历
        /*
        * 01.首行为表头,不需要读取(第二行开始,i=1)
        * 02.读取sheet的最后一行索引值sheet.getLastRowNum()
        * 生产厂家	货号	数量	包装单位(PCS/SETS)	装率	箱数	单价	货物描述	要求
         * */
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            ContractProduct product = new ContractProduct();
            XSSFRow row = sheet.getRow(i);
            product.setFactoryName(row.getCell(1).getStringCellValue());//生产厂家
            product.setProductNo(row.getCell(2).getStringCellValue());
            product.setCnumber(((Double) row.getCell(3).getNumericCellValue()).intValue());//数量
            product.setPackingUnit(row.getCell(4).getStringCellValue());//包装单位(PCS/SETS)
            product.setLoadingRate(row.getCell(5).getNumericCellValue()+"");//装率
            product.setBoxNum(((Double)row.getCell(6).getNumericCellValue()).intValue());//箱数
            product.setPrice(row.getCell(7).getNumericCellValue());//单价
            product.setProductDesc(row.getCell(8).getStringCellValue());//货物描述
            product.setProductRequest(row.getCell(9).getStringCellValue());//要求
            System.out.println(product);
        }
        workbook.close();
    }
}
