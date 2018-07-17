package cn.ben.test.excel;

import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @TIME 2018/6/19 13:49
 * @User yangkun
 * @DESCRIPTION
 */
public class ExcelListener extends AnalysisEventListener<BillExcelModel> {
    @Override
    public void invoke(BillExcelModel object, AnalysisContext context) {
        int sheetNo = context.getCurrentSheet().getSheetNo();
        Integer currentRowNum = context.getCurrentRowNum();
        System.out.println("sheetNo:" + sheetNo + ",currentRowNum:" + currentRowNum);
        System.out.println("invoke");
        System.out.println(object);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        List<BillExcelModel> list = new ArrayList<>();
        Object result = context.getCurrentRowAnalysisResult();

        System.out.println("doAfterAllAnalysed");
    }
}
