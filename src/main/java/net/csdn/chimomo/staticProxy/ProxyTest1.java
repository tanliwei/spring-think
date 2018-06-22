package net.csdn.chimomo.staticProxy;

/**
 * https://blog.csdn.net/troubleshooter/article/details/78467637
 */
public class ProxyTest1 {

    public static void main(String[] args) {
        /**
         * 每次都需要一个代理对象
         */
        Candidate c = new Gunman(new LazyStudent("王小二"));
        c.answerTheQuestions();
    }
}
