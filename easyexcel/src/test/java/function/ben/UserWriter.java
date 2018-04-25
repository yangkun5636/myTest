package function.ben;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @TIME 2018/4/23 9:16
 * @User yangkun
 * @DESCRIPTION
 */
public class UserWriter {

    @Test
    public void writeUser() throws Exception {
        File file = new File("C:/Users/yangkun/Desktop/easyExcel/user.xlsx");
        ExcelWriter writer = new ExcelWriter(new FileOutputStream(file), ExcelTypeEnum.XLSX);
        Sheet sheet = new Sheet(1, 1, User.class);
        sheet.setSheetName("user1");
        Sheet sheet2 = new Sheet(2, 1, User.class);
        sheet2.setSheetName("user2");
        writer.write(getUserList(), sheet);
        writer.write(getUserList(), sheet2);
        writer.finish();
    }

    public List<User> getUserList() {
        List<User> list = new ArrayList<>();
        list.add(new User("name1", 16, new Date("2018/09/09")));
        list.add(new User("name2", 22, null));
        list.add(new User("name3", 33, new Date("2018/03/03")));
        list.add(new User("name4", 44, new Date("2018/04/04")));
        list.add(new User("name5", 55, new Date("2017/05/05")));
        list.add(new User("name6", 66, null));
        return list;
    }
}
