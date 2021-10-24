package com.example.datastructure.Queues;

/**
 * 队列是一个有序列表，可以用数组或者链表来实现
 * 遵循先入先出（FIFO）的原则，即先进去的数据，先出来
 * 此类是用数组来实现一个队列
 */
public class ArrayQueue<T> {

    //队列的最大容量,默认10
    private int maxSize = 10;
    //队列头位置
    private int front;
    //队列尾部位置
    private int rear;
    //保存数据的数组，
    private Object[] elements;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        elements = new Object[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    //向队列里添加数据
    public void add(T t){
        if (isFull()) {
            throw new RuntimeException("队列已经满了");
        }
        rear++;
        elements[rear] = t;
    }
    //获取队列里的一个数据
    public T get(){
        if (isEmpty()) {
            throw new RuntimeException("数组为空，没有数据");
        }
        //每取出一个值，front置要往后移一个位置
        front++;
        return (T)elements[front];
    }
    //打印队列里的数据
    public void showQueue(){
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,elements[i]);
        }
    }

    //显示队列头的数据，注意不是取出数据，所以 front值没有自增
    public T headQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return (T)elements[front+1];
    }








}
