package function.ben;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @TIME 2018/4/23 9:57
 * @User yangkun
 * @DESCRIPTION
 */
public class UserReader {

    @Test
    public void readUser() throws Exception {
        File file = new File("C:/Users/yangkun/Desktop/easyExcel/user.xlsx");
        InputStream inputStream = new FileInputStream(file);

        UserAnalysisEventListener listener = new UserAnalysisEventListener();

        ExcelReader reader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);

        Sheet sheet = new Sheet(1, 1,User.class);
        Sheet sheet2 = new Sheet(2, 1,User.class);
        reader.read(sheet);
        reader.read(sheet2);
        listener.getDatas();
    }
}
