package spring.think.ch12.httpInvoker;

/**
 * @create 2018/8/13
 */
public class HttpInvokerIImpl implements HttpInvokerI {
    @Override
    public String getTestPo(String desp) {
        return "getTestPo" + desp;
    }
}
