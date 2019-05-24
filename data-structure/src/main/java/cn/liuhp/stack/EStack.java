package cn.liuhp.stack;

import java.util.Arrays;

/**
 * @description: 泛型栈
 * @author: hz16092620
 * @create: 2019-05-20 14:18
 */
public class EStack<E> {

    /*测试栈*/
    public static void main(String[] args) {
        EStack<String> eStack = new EStack<>();
        for (int i = 0; i < 50; i++) {
            eStack.push(i + "");
        }
        while (!eStack.isEmpty()) {
            System.out.println(eStack.pop());
        }
    }

    private static final int default_capacity = 16;

    private int size;

    //private E[] elements = null;
    private Object[] elements = null;

    public EStack () {
        /*
        * 数组不能创建位置类型的 new E[default_capacity]
        * 方法一：E[] elements = (E[]) new Object[default_capacity]; 通过类型转换
        * 方法二：Object[] elements = new Object[default_capacity];
        * 这个时候E e = (E) this.elements[--size];需要转换 ArrayList用的是这种
        * */
        //elements = (E[]) new Object[default_capacity];
        elements = new Object[default_capacity];
    }

    public boolean push(E e) {
        ensureCapacity();
        elements[size++] = e;
        return true;
    }

    public void ensureCapacity() {
        if (size >= this.elements.length) {
            int oldCapacity = this.elements.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            System.out.println(String.format("扩容 oldCapacity %d newCapacity %d 增量 %d", oldCapacity, newCapacity, (newCapacity - oldCapacity)));
            this.elements = Arrays.copyOf(this.elements, newCapacity);
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E pop() {
        if (size <= 0) {
            throw new RuntimeException();
        }
        E e = (E) this.elements[--size];
        this.elements[size] = null;
        return e;
    }




}
