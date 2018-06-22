package spring.think.ch07.jdkAop;

/**
 * @create 2018/6/21
 */
public class UserServiceImpl implements UserService {

    /**
     * @see dynamic.proxy.UserService#add()
     */
    @Override
    public void add() {
        System.out.println("---add---");
    }
}
