package java.util;

public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String test(){
        System.out.println(111);
        return "myPerson";
    }
}
