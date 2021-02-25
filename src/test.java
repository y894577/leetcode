import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Stack;

interface Person {
    void thing1();
    void thing2();
}

//委托类
class RealPerson implements Person{

    @Override
    public void thing1() {
        System.out.println("do thing 1");
    }

    @Override
    public void thing2() {
        System.out.println("do thing 2");
    }
}

//代理类
class PersonProxy implements InvocationHandler {
    private Object proxied;

    public PersonProxy(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke before");
        Object result = method.invoke(proxied, args);
        System.out.println("invoke after");
        return result;
    }
}

public class test {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {


        Person person = (Person) Proxy.newProxyInstance
                (RealPerson.class.getClassLoader(),new Class[]{Person.class},new PersonProxy(new RealPerson()));

        person.thing1();
        person.thing2();

        String[]a = new String[6];
        Stack<Integer> stack = new Stack<>();
    }
}
