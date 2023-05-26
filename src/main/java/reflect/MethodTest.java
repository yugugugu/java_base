package reflect;

import java.lang.reflect.Method;

public class MethodTest {
    public static void main (String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> targetClass = Class.forName("reflect.TargetObject");
        TargetObject targetObject = (TargetObject) targetClass.newInstance();

        Method[] methods = targetClass.getDeclaredMethods();
        for(Method method: methods){
            System.out.println(method.getName());
        }
    }
}
