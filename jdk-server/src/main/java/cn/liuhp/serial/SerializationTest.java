package cn.liuhp.serial;


import java.io.IOException;


public class SerializationTest {

    public static void main(String[] args) {
        //fun1();
        //fun2();
        //fun3();
        fun4();
    }

    /*
    * 父类序列化子类没有
    * */
    private static void fun3() {
        String fileName = "person.ser";
        Person person = new Person();
        person.setName("john");
        person.setValue("我是父类");
        try {
            SerializationUtils.serialize(person, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("person Object::"+person);
    }

    /*
     * 反序列化
     * */
    private static void fun4() {
        String fileName="person.ser";
        Person personNew = null;
        try {
            personNew = (Person) SerializationUtils.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }


        System.out.println("personNew Object::"+personNew);
    }

    /*
    * 序列化
    * */
    private static void fun1() {
        String fileName="employee.ser";
        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("Pankaj");
        emp.setSalary(5000);
        emp.setValue("我是父类");
        //serialize to file
        try {
            SerializationUtils.serialize(emp, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("emp Object::"+emp);
    }

    /*
    * 反序列化
    * */
    private static void fun2() {
        String fileName="employee.ser";
        Employee empNew = null;
        try {
            empNew = (Employee) SerializationUtils.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }


        System.out.println("empNew Object::"+empNew);
    }

}