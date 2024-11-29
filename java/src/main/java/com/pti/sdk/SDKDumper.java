package com.pti.sdk;

import com.pti.sdk.core.Environment;
import com.pti.sdk.core.RequestOptions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SDKDumper {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        PTIClient client = new PTIClientBuilder()
                .environment(Environment.DEFAULT)
                .ptiClientId("3450582c-1955-11eb-adc1-0242ac120002")
                .privateKeyPath("/Users/remicartier/Documents/cucumber_key.pem")
                .build();

//        System.out.println(client.wallets().getListOfAssets());

        // List all 'client' from base client
        for (Method clientMethod : client.getClass().getDeclaredMethods()) {
            if (!clientMethod.getReturnType().getName().endsWith("Client") || Modifier.isStatic(clientMethod.getModifiers())) {
                continue;
            }
            Object resClient = clientMethod.invoke(client);
            for (Method apiMethod : resClient.getClass().getDeclaredMethods()) {
                // if last argument if RequestOption skip the method
                if (apiMethod.getParameterCount() > 0 && apiMethod.getParameters()[apiMethod.getParameterCount() - 1].getType() == RequestOptions.class) {
                    continue;
                }
                System.out.print(clientMethod.getReturnType().getSimpleName() + "." + apiMethod.getName() + "(");
                for (Parameter parameter : apiMethod.getParameters()) {
                    dumpParameter("\t", parameter, null);
                }
                // \b is to delete the extra last comma
                System.out.println("\b);");
                System.out.println("---------------------------------------------");
            }
        }
    }

    private static void dumpBuilderStage(String padding, Object object) throws InvocationTargetException, IllegalAccessException {
        // check all the public method available
        boolean finalStage = isFinalStage(object);
        // is final, call all other methods and then build
        if (finalStage) {
            for (Method method : object.getClass().getDeclaredMethods()) {
                if (!Modifier.isPublic(method.getModifiers())) {
                    continue;
                }
                if (method.getName().equals("build") || method.getName().equals("from")) {
                    continue;
                }
                if (method.getParameterCount() > 0 && method.getParameters()[method.getParameterCount() - 1].getType() == Optional.class) {
                    continue;
                }
                System.out.print("." + method.getName() + "(");
                dumpParameter(padding + "\t", method.getParameters()[0], method.getName());
                System.out.print("\b)");
            }
            System.out.print(".build()");
        } else { // if not final, find the arg that need to be set and recursively call this method
            for (Method method : object.getClass().getDeclaredMethods()) {
                if (!Modifier.isPublic(method.getModifiers())) {
                    continue;
                }
                // there should only be a single public method per stage, call it
                System.out.print("\n" + padding + object.getClass().getSimpleName() + ".builder()");
                dumpBuilderStage(padding + "\t", method.invoke(object, new Object[]{null}));
                return;
            }
        }
    }

    private static boolean isFinalStage(Object object) {
        try {
            object.getClass().getMethod("build");
            return true;
        } catch (Exception x) {
            return false;
        }
    }

    private static void dumpParameter(String padding, Parameter parameter, String methodName) throws InvocationTargetException, IllegalAccessException {
        boolean hasBuilder = false;
        for (Method parameterMethod : parameter.getType().getDeclaredMethods()) {
            if (parameterMethod.getName().equals("builder")) {
                hasBuilder = true;
                System.out.print("\n" + padding + parameter.getType().getSimpleName() + ".builder()");
                dumpBuilderStage(padding + "\t", parameterMethod.invoke(null));
                break;
            }
        }
        if (parameter.getType().getPackageName().equals("com.pti.sdk.types") && !hasBuilder) {
            out:
            for (Method parameterMethod : parameter.getType().getDeclaredMethods()) {
                if (Modifier.isStatic(parameterMethod.getModifiers()) && Modifier.isPublic(parameterMethod.getModifiers()) && parameterMethod.getParameterCount() == 1) {
                    for (Method staticMethod1stParameterMethod : parameterMethod.getParameters()[0].getType().getDeclaredMethods()) {
                        if (staticMethod1stParameterMethod.getName().equals("builder")) {
                            hasBuilder = true;
                            System.out.print("\n" + padding + parameter.getType().getSimpleName() + "." + parameterMethod.getName() + "(" + parameterMethod.getParameters()[0].getType().getSimpleName() + ".builder()");
                            dumpBuilderStage(padding + "\t", staticMethod1stParameterMethod.invoke(null));
                            System.out.print(padding + ")");
                            break out;
                        }
                    }
                }
            }
        }
        String value = "";
        if (!hasBuilder) {
            if (parameter.getType().isAssignableFrom(String.class)) {
                value = methodName != null ? "\"" + methodName + "\"" : "\"\"";
            } else if (Number.class.isAssignableFrom(parameter.getType()) || "double".equals(parameter.getType().getSimpleName())) {
                value = "0";
            } else if (parameter.getType().isAssignableFrom(List.class)) {
                value = "List.of()";
            } else if (parameter.getType().isAssignableFrom(Map.class)) {
                value = "Map.of()";
            } else if (Enum.class.isAssignableFrom(parameter.getType())) {
                value = parameter.getType().getSimpleName() + "." + parameter.getType().getEnumConstants()[0].toString();
            } else if (Boolean.class.isAssignableFrom(parameter.getType())) {
                value = "true";
            } else if (Optional.class.isAssignableFrom(parameter.getType())) {
                value = "Optional.empty()";
            } else {
                value = "FIXME:" + parameter.getType().getSimpleName();
            }
        }
        System.out.print(value + ",");
    }
}
