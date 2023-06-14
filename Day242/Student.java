package Day242;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Solutions {
    public static void main(String[] args) {
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        List<String> methodNames = new ArrayList<>();
        for (Method method : methods) {
            methodNames.add(method.getName());
        }
        Collections.sort(methodNames);
        for (String name : methodNames) {
            System.out.println(name);
        }
    }
}