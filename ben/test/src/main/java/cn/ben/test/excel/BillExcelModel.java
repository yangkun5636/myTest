package cn.ben.test.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BillExcelModel extends BaseRowModel {
    //理赔号
    @ExcelProperty(value = "理赔号", index = 0)
    private String caseNumber;
    //被保险人
    @ExcelProperty(value = "被保险人", index = 1)
    private String insurePersonName;
    //给付责任
    @ExcelProperty(value = "给付责任", index = 2)
    private String dutyName;
    //立案时间
    @ExcelProperty(value = "立案时间", index = 3, format = "yyyy-MM-dd")
    private Date createDt;
    //结算时间
    @ExcelProperty(value = "结算时间", index = 4, format = "yyyy-MM-dd")
    private Date settleDate;
    //索赔金额
    @ExcelProperty(value = "索赔金额", index = 5, money = true)
    private String applyAmt;
    //最终赔付金额
    @ExcelProperty(value = "最终赔付金额", index = 6, money = true)
    private String lastCompAmt;
    //垫付标识(标识为是为医院垫付 导出医院银行信息)
    @ExcelProperty(value = "垫付标识", index = 7)
    private String paymentType;
    //医院代码
    @ExcelProperty(value = "医院代码", index = 8)
    private String hospInnerCode;
    //医院
    @ExcelProperty(value = "医院", index = 9)
    private String hospName;
    //银行编码
    @ExcelProperty(value = "银行编码", index = 10)
    private String bankCode;
    //约定转账银行
    @ExcelProperty(value = "约定转账银行", index = 11)
    private String bankName;
    //银行账户名
    @ExcelProperty(value = "银行账户名", index = 12)
    private String bankAccountName;
    //银行账户
    @ExcelProperty(value = "银行账户", index = 13)
    private String bankAccount;
    //转账时间
    @ExcelProperty(value = "转账时间", index = 14, format = "yyyy-MM-dd")
    private Date transferDate;
    //转账金额
    @ExcelProperty(value = "转账金额", index = 15)
    private String transferAmt;
    //备注
    @ExcelProperty(value = "备注", index = 16)
    private String remark;

}
