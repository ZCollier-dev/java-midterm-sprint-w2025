public class Person {
    //attributes
    protected int id;
    protected String name;
    protected int age;
    protected String phone;

    //methods
    public Person(int id, String name, int age, String phone){
        this.id = id;
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

    public int getId(){
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
