package cn.liuhp.stack;

import java.util.Arrays;

/**
 * @description: 栈
 * @author: hz16092620
 * @create: 2019-05-20 11:47
 */
public class Stack {

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 50; i++) {
            stack.push(i + "");
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static final int default_capacity = 16;

    private int size = 0;

    private int capacity = default_capacity;

    private Object[] elements = new Object[capacity];

    /*添加新元素，为什么不是put（阻塞设置）、offer（无阻塞）、add（抛出异常）*/
    public boolean push(Object e) {
        this.ensureCapacity();
        this.elements[size++] = e;
        return true;
    }

    /*栈顶元素，poll获取首元素*/
    public Object pop() {
        if (size <= 0) {
            throw new RuntimeException();
            //throw new Exception();//这样的异常需要抛出
        }
        Object e = this.elements[--size];
        this.elements[size] = null;
        return e;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void ensureCapacity() {
        if (size >= capacity) {
            int oldCapacity = capacity;
            int newCapacity = capacity + (capacity >> 1);
            capacity = newCapacity;
            System.out.println(String.format("扩容 oldCapacity %d newCapacity %d 增量 %d", oldCapacity, newCapacity, (newCapacity - oldCapacity)));
            elements = Arrays.copyOf(this.elements, newCapacity);
        }
    }



}
