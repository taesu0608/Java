package algorithm.proxy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Mainex {
    public static void main(String[] args) {
        GreetingService target = new GreetingServiceImpl();

        GreetingService proxy = (GreetingService) Proxy.newProxyInstance(
                GreetingService.class.getClassLoader(),
                new Class<?>[]{GreetingService.class},
                (proxyObject, method, methodArgs) -> {
                    System.out.println("호출 전: " + method.getName());

                    try {
                        Object result = method.invoke(target, methodArgs);

                        System.out.println("호출 후: " + method.getName());
                        return result;
                    } catch (InvocationTargetException e) {
                        throw e.getCause();
                    }
                }
        );

        System.out.println(proxy.greet("나"));
    }
}