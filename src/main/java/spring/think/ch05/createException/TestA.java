package spring.think.ch05.createException;

public class TestA {
    private TestB testB;

    public TestA(TestB testB){
        this.testB = testB;
    }
    public void a(){
        testB.b();
    }
    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }
}
