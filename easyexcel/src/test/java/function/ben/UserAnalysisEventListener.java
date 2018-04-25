package function.ben;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @TIME 2018/4/23 10:00
 * @User yangkun
 * @DESCRIPTION
 */
public class UserAnalysisEventListener extends AnalysisEventListener<User> {

    Sheet sheet;
    private List<User> datas = new ArrayList<>();
    private ExcelWriter writer;


    @Override
    public void invoke(User user, AnalysisContext context) {
        datas.add(user);
        System.out.println(user);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<User> getDatas() {
        return datas;
    }

    public void setDatas(List<User> datas) {
        this.datas = datas;
    }

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public ExcelWriter getWriter() {
        return writer;
    }

    public void setWriter(ExcelWriter writer) {
        this.writer = writer;
    }
}
