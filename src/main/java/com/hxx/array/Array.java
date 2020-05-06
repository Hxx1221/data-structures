package com.hxx.array;

/***
 * 数组
 */
public class Array<E> {

    private E[] data;

    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    //获取数组的元素
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("AddLast failed");
//        }
//        data[size] = e;
//        size++;
        add(size, e);
    }

    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //扩容数组
    private void resize(int capacity) {
        E[] e = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            e[i] = data[i];
        }
        data = e;
    }

    //数组头部添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //根据下标取数组元素
  public   E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed");
        }
        return data[index];
    }

    //修改元素
    void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed");
        }
        data[index] = e;
    }

    //判断数组中是否包含该元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //查找数组中元素e所在的索引 如果不存在元素e 则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //从数组中删除index位置元素 返回该元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed");
        }

        if (size==data.length/4 && data.length/2!=0){
            resize(data.length/2);
        }

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    //从数组中删除元素e
    public void removeElement(E e) {
        int i = find(e);
        if (i != -1) {
            remove(i);
        }
    }

     public E getLast(){
        return get(size-1);
     }
    public E getFirst(){
        return get(0);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        stringBuffer.append("[");
        for (int i = 0; i < size; i++) {
            stringBuffer.append(data[i]);
            if (i != size - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
/***
 * 时间复杂度
 *  addLast（e） O(1)   扩容
 *  addFirst（e） O（n）
 *  add（index，e） O（n/2）=O(n)
 *  添加操作的时间复杂度为O（n）
 *
 *  removeLast(e)  O(1)
 *  removeFirst(e) O(n)       扩容
 *  remove(index,e) O(n/2)
 *  删除操作时间复杂度 O（n）
 *
 *  修改操作  set（index， e）  O（1）
 *   get（index） O（1）
 *   contains（e） O(n)
 *   find（e）  O（n）
 *
 *   均摊复杂度
 *
 *   复杂度震荡
 *            if (size==data.length/4)
 */

