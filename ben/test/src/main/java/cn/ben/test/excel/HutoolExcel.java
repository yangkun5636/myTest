package cn.ben.test.excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @TIME 2018/6/19 14:23
 * @User yangkun
 * @DESCRIPTION
 */
public class HutoolExcel {
    public void read() {
        File file = new File("C:/Users/yangkun/Downloads/export.xlsx");
        ExcelReader reader = ExcelUtil.getReader(file);
        reader.setHeaderAlias(getReadHeadAlias());
        List<BillExcelModel> read = reader.read(0, 0, 3, BillExcelModel.class);
        read.forEach(b -> System.out.println(b));
        ExcelWriter writer = ExcelUtil.getWriter();
        writer.write(new ArrayList<>());
        writer = new ExcelWriter();
        Workbook workbook = writer.getWorkbook();
    }

    private Map<String, String> getReadHeadAlias() {
        Map<String, String> alias = new HashMap<>();
        alias.put("理赔号", "caseNumber");
        alias.put("被保险人", "insurePersonName");
        alias.put("给付责任", "dutyName");
        alias.put("立案时间", "createDt");
        alias.put("结算时间", "settleDate");
        return alias;
    }
}
