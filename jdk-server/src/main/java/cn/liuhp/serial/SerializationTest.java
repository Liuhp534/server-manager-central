package cn.liuhp.serial;


import java.io.IOException;


public class SerializationTest {

    public static void main(String[] args) {
        //fun1();
        fun2();

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