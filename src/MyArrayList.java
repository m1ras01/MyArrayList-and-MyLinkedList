import java.util.Objects;

public class MyArrayList<E> implements MyList<E>{
    private Object[] arr;
    private int size = 0;

    MyArrayList() {
        arr = new Object[5];

    }

    public void add(E element) {
        if (size == arr.length) {
            E[] newArr = (E[]) new Object[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = (E) arr[i];
            }
            arr = newArr;
        }
        arr[size++] = element;
    }
    public void addAll(int[] ar,int index){
        Object[] NewArr = new Object[arr.length*20];
        for (int i = 0; i < arr.length; i++) {
            NewArr[i] = (E) arr[i];
        }
        arr = NewArr;

        for(int i = index;i<ar.length;i++ ){
           for(int k = 0 ; i < ar.length;i++) {
               for (int j = index + ar.length; j <= arr.length + ar.length; i++) {
                   arr[j] = arr[i];
                   arr[i] = ar[k];
               }
           }
        }
    }
    public void sort(int a, int b) {
        int n = b - a;

        Object[] arr2 = new Object[n];

            for (int i = a; i < b; i++) {
                arr2[i-n] = arr[i];
            }
        for (int i = 0; i < arr2.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr2.length; j++) {
                if (arr2[min] != null && arr2[j] != null) {
                    if ((Integer) arr2[min] > (Integer) arr2[j]) {
                        min = j;
                    }
                }
            }

            Object temp = arr2[i];
            arr2[i] = arr2[min];
            arr2[min] = temp;
        }

    }
     @Override
    public E get(int index) {
        return null;
    }

    public E getElement(int index) {
        // checkIndex(index);
        return (E) arr[index];
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--;
    }

    @Override
    public int size() {
        return 0;
    }

    public int Size() {
        return size;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= arr.length) throw new IndexOutOfBoundsException();
    }

    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (arr[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(arr[i])) {
                    return true;
                }

            }
        }
        return false;
    }

    public void add(E item, int index) {
        if (index >= size) {
            Object[] newArr = new Object[arr.length * 20];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
            arr[index] = item;
        } else {
            arr[index] = item;
            size++;
        }
    }

    public boolean removeAndChecker(E item) {
        for (int i = 0; i <= size; i++) {
            if (Objects.equals(item, arr[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public void clear() {
        size = 0;
        Object[] newArr = new Object[size];
        arr = newArr;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (Objects.equals(o, arr[i])) {
                    return i;
                }
            }

        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (Objects.equals(arr[i], o)) {
                    return i;
                }
            }
        }
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(arr[i], o)) {
                return i;
            }

        }
        return -1;
    }
    public void sort(){
        for(int i = 0; i < arr.length   ; i++) {
            int min = i;
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[min] != null && arr[j] != null){
                if((Integer)arr[min] > (Integer)arr[j]) {
                    min = j;
                }
                }
            }

            Object temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }


}



