package learn.spaceflight;

import learn.spaceflight.spacecraft.InterstellarTransport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext container = new ClassPathXmlApplicationContext("dependency-configuration.xml");

        InterstellarTransport transport = container.getBean(InterstellarTransport.class);
        System.out.println(transport);
    }
}
