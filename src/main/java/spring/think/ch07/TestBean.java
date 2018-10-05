package spring.think.ch07;

/**
 * @Creator Tan Liwei
 * @Date 2018/10/5 10:08
 */
public class TestBean {
    private String testStr = "testStr";

    public String getTestStr(){
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test(){
        System.out.println("test");
    }
}
