package algorithm.proxy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public interface GreetingService {
    String greet(String name);
}

// 실제 작업을 수행하는 객체
class GreetingServiceImpl implements GreetingService {

    public String greet(String name) {
        return "안녕하세요" + name;
    }
}