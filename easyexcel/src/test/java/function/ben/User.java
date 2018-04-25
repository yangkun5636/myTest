package function.ben;

import com.alibaba.excel.annotation.ExcelColumnNum;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

/**
 * @TIME 2018/4/23 9:15
 * @User yangkun
 * @DESCRIPTION
 */
public class User extends BaseRowModel {

    @ExcelProperty(index = 0, value = "姓名")
//    @ExcelColumnNum(0)
    private String name;
    @ExcelProperty(index = 1, value = "年龄")
//    @ExcelColumnNum(1)
    private int age;
    @ExcelProperty(index = 2, value = "生日", format = "yyyy-MM-dd")
//    @ExcelColumnNum(2)
    private Date birth;

    public User(String name, int age, Date birth) {
        this.name = name;
        this.age = age;
        this.birth = birth;
    }

    public User() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "user:[name=" + name + ",age=" + age + ",birth=" + birth + "]";
    }
}
