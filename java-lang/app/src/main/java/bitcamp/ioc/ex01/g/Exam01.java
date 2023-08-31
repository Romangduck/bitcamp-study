// IoC 컨테이너에서 객체 꺼내기
package bitcamp.ioc.ex01.g;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import bitcamp.ioc.SpringUtils;

public class Exam01 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(//
        "/bitcamp/ioc/ex01/g/application-context.xml");

    // 현재 IoC 컨테이너에 들어 있는 객체를 출력해 보자.
    SpringUtils.printBeanList(iocContainer);

    // 1) 객체 이름으로 꺼내기
    System.out.println(iocContainer.getBean("c1"));

    // 2) 객체 타입으로 꺼내기
    System.out.println();

    System.out.println("실행 완료!");
  }
}


