package Clone;

/**
 * Create  with Intellij IDEA .
 * User : WLM
 * Date : 2021-05-02
 * Time : 14: 35
 */

class Money implements Cloneable{
    public double money = 88.8;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


//Cloneable  空接口/ 标识接口    如果有一个类实现了这个接口，说明该类可以被克隆的
class Person implements Cloneable{
    public int age;
    public String name;
    public Money m;

    public  Person(int age, String name){
        this.age = age;
        this.name = name;
        this.m = new Money();
    }

    public String toString(){
        return "Person{"+
                "age= "+ age +
                ", name= "+ name +
                '\''+
                '}';
    }

    //重写Object的克隆方法！！！
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person personClone = (Person) super.clone();
        personClone.m = (Money) this.m.clone();
        return personClone;
    }
}

public class TestDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person  =  new Person(18,"Bob");
        Person person1 = (Person) person.clone();

        System.out.println(person.m.money);
        System.out.println(person1.m.money);

        System.out.println("====================");

        person1.m.money = 100.0;
        System.out.println(person.m.money);
        System.out.println(person1.m.money);
    }
}
