package spring.think.ch05.createException;

public class TestC {
    private TestA testA;
    public TestC(TestA testA){
        this.testA = testA;
    }
    public void c() {
    }

    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }
}
