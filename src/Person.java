import java.util.UUID;

public class Person {
    //attributes
    private String id;
    private String name;
    private int age;
    private String phone;

    //methods
    public Person(String name, int age, String phone){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getPhone(){
        return this.phone;
    }
}
