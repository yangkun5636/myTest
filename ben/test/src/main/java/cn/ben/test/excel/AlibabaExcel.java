package cn.ben.test.excel;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @TIME 2018/6/19 13:32
 * @User yangkun
 * @DESCRIPTION
 */
public class AlibabaExcel {

    public void read() throws FileNotFoundException {
        File file = new File("C:/Users/yangkun/Downloads/export.xlsx");
        ExcelReader reader = new ExcelReader(new FileInputStream(file), ExcelTypeEnum.XLSX, BillExcelModel.class, new ExcelListener(), true);
        reader.read(new Sheet(1,1,BillExcelModel.class));
    }
}
