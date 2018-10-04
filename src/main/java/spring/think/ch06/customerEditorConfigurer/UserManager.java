package spring.think.ch06.customerEditorConfigurer;

import java.util.Date;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/4 9:12
 */
public class UserManager {
    private Date dataValue;

    public Date getDataValue() {
        return dataValue;
    }

    public void setDataValue(Date dataValue) {
        this.dataValue = dataValue;
    }

    @Override
    public String toString() {
        return "dataValue:" + dataValue;
    }
}
