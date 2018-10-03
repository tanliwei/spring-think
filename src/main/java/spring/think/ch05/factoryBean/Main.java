package spring.think.ch05.factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext bf =
                new ClassPathXmlApplicationContext("ch05/car.xml");
        Car car = (Car) bf.getBean("car");
        /**
         * Console:
         * 超级跑车,400,2000000.0
         */
        System.out.println(car.getBrand() + "," + car.getMaxSpeed() + "," + car.getPrice());

        CarFactoryBean carFactoryBean = (CarFactoryBean) bf.getBean("&car");

        Car carObject = carFactoryBean.getObject();
        /**
         * Console:
         *  超级跑车,400,2000000.0
         */
        System.out.println(carObject.getBrand() + "," + carObject.getMaxSpeed() + "," + carObject.getPrice());

    }
}
