package by.ales.core;

import by.ales.core.annotations.TimeBenchmark;
import by.ales.core.intefaces.ProxyConfigurator;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalTime;

public class TimeBenchmarkHandlerProxyConfiguratorImpl implements ProxyConfigurator {

    @Override
    public <T> Object replaceWithProxyIfNeeded(Object t, Class<T> implClass) {
        boolean hasMethodWithTimeBenchmarkAnnotation = false;
        for (Method method : implClass.getMethods()) {
            if (method.isAnnotationPresent(TimeBenchmark.class)){
                hasMethodWithTimeBenchmarkAnnotation = true;
                break;
            }
        }

        if (hasMethodWithTimeBenchmarkAnnotation){
            if (implClass.getInterfaces().length == 0){
                return Enhancer.create(implClass,
                        (InvocationHandler) (o, method, args) -> getInvocationHandlerLogic(t, method, args));
            }
            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(),
                    (proxy, method, args) -> getInvocationHandlerLogic(t, method, args));
        } else {
            return t;
        }
    }

    private Object getInvocationHandlerLogic(Object t, Method method, Object[] args)
            throws InvocationTargetException, IllegalAccessException {
        Object result;
        if (method.isAnnotationPresent(TimeBenchmark.class)){
            LocalTime startTime = LocalTime.now();
            result = method.invoke(t, args);
            LocalTime finishTime = LocalTime.now();
            printTimeOfWorkMethod(method, startTime, finishTime);
        } else {
            result = method.invoke(t, args);
        }
        return result;
    }

    private static final String TIME_BENCHMARK_MESSAGE_PATTERN =
            "=================================\n" +
            "          TIME BENCHMARK:        \n" +
            "Method '%s' working %d nano sec.\n" +
            "=================================\n";

    private void printTimeOfWorkMethod(Method method, LocalTime start, LocalTime finish){
        long time = finish.getNano() - start.getNano();
        System.out.printf(TIME_BENCHMARK_MESSAGE_PATTERN, method.getName(), time);
    }
}
