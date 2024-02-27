package ru.aston.trainee.lesson2.myAraryList;


import java.util.*;

public class MyArraylist<E> implements MyArray<E>{
    private static final int DEFAULT_CAPACITY = 10;
    transient Object[] elementData;
    private int size;
    protected transient int modCount = 0;
    private final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new Object[0];
    private final Object[] EMPTY_ELEMENTDATA = new Object[DEFAULT_CAPACITY];

    public MyArraylist(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else {
            if (initialCapacity != 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
            }
            this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        }
    }

    public MyArraylist() {
        this.elementData = EMPTY_ELEMENTDATA;
    }

    @Override
    public int size() {
        return this.size;
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = this.elementData.length;
        if (oldCapacity <= 0 && this.elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return this.elementData = new Object[Math.max(10, minCapacity)];
        } else {
            int newCapacity = (int) (oldCapacity * 1.5);
            return this.elementData = Arrays.copyOf(this.elementData, newCapacity);
        }
    }

    private Object[] grow() {
        return this.grow(this.size + 1);
    }


    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length) {
            elementData = this.grow();
        }
        elementData[s] = e;
        this.size = s + 1;
    }

    @Override
    public boolean add(E e) {
        ++this.modCount;
        this.add(e, this.elementData, this.size);
        return true;
    }

    public void add(int index, E element) {
        this.rangeCheckForAdd(index);
        ++this.modCount;
        int s;
        Object[] elementData;
        if ((s = this.size) == (elementData = this.elementData).length) {
            elementData = this.grow();
        }

        System.arraycopy(elementData, index, elementData, index + 1, s - index);
        elementData[index] = element;
        this.size = s + 1;
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        ++this.modCount;
        int numNew = a.length;
        if (numNew == 0) {
            return false;
        } else {
            Object[] elementData;
            int s;
            if (numNew > (elementData = this.elementData).length - (s = this.size)) {
                elementData = this.grow(s + numNew);
            }
            System.arraycopy(a, 0, elementData, s, numNew);
            this.size = s + numNew;
            return true;
        }
    }

    public E remove(int index) {
        Objects.checkIndex(index, this.size);
        Object[] es = this.elementData;
        E oldValue = (E) es[index];
        this.fastRemove(es, index);
        return oldValue;
    }

    private void fastRemove(Object[] es, int i) {
        ++this.modCount;
        int newSize;
        if ((newSize = this.size - 1) > i) {
            System.arraycopy(es, i + 1, es, i, newSize - i);
        }

        es[this.size = newSize] = null;
    }
    public E get(int index) {
        Objects.checkIndex(index, this.size);
        return this.elementData(index);
    }
    E elementData(int index) {
        return (E) this.elementData[index];
    }

    private void rangeCheckForAdd(int index) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("Index bounds Exception" + (index));
        }
    }

    public boolean removeAll(Collection<?> c) {
        return this.batchRemove(c, false, 0, this.size);
    }

    @Override
    public void clear() {
        ++this.modCount;
        Object[] es = this.elementData;
        int to = this.size;

        for(int i = this.size = 0; i < to; ++i) {
            es[i] = null;
        }

    }

    private void shiftTailOverGap(Object[] es, int lo, int hi) {
        System.arraycopy(es, hi, es, lo, this.size - hi);
        int to = this.size;

        for (int i = this.size -= hi - lo; i < to; ++i) {
            es[i] = null;
        }

    }

    boolean batchRemove(Collection<?> c, boolean complement, int from, int end) {
        Objects.requireNonNull(c);
        Object[] es = this.elementData;

        for (int r = from; r != end; ++r) {
            if (c.contains(es[r]) != complement) {
                int w = r++;

                try {
                    for (; r < end; ++r) {
                        Object e;
                        if (c.contains(e = es[r]) == complement) {
                            es[w++] = e;
                        }
                    }
                } catch (Throwable var12) {
                    System.arraycopy(es, r, es, w, end - r);
                    w += end - r;
                    throw var12;
                } finally {
                    this.modCount += end - w;
                    this.shiftTailOverGap(es, w, end);
                }

                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void sort(Comparator<? super E> comp) {
        if (size == 0 || size == 1) return;
        quickSort(comp, 0, size - 1);
    }

    private void quickSort(Comparator<? super E> comp, int low, int high) {
        if (low < high) {
            int partition = partition(comp, low, high);

            quickSort(comp, low, partition - 1);
            quickSort(comp, partition + 1, high);
        }
    }

    @SuppressWarnings("unchecked")
    private int partition(Comparator<? super E> comp, int low, int high) {
        E pivot = (E) elementData[high];

        int j = low - 1;

        for (int i = low; i < high; i++) {
            E element = (E) elementData[i];

            if (comp.compare(element, pivot) < 0) {
                j++;
                elementData[i] = elementData[j];
                elementData[j] = element;
            }
        }

        Object temp = elementData[j + 1];
        elementData[j + 1] = elementData[high];
        elementData[high] = temp;

        return j + 1;
    }
}