import java.util.*;

class GenericTest {

    public static void main(String[] args) {
        System.out.println("I Love coding !!!");

        GenericTest main = new GenericTest();
        main.workWithLists();
    }

    private void workWithLists() {
        CustomList<Integer> tempList = new CustomList<>();

        tempList.add(1);
        tempList.add(2);
        tempList.add(3);

        System.out.println(tempList.get(0));
    }

    class CustomList<T> {

        Object[] myList;
        int currentPos;

        CustomList() {
            this.myList = new Object[32];
            this.currentPos = 0;
        }

        public void add(T inputVal) {
            this.myList[currentPos] = inputVal;
            this.currentPos++;
        }

        public T[] getElements() {
            return (T[]) this.myList;
        }

        public T get(int i) {
            return (T) this.myList[i];
        }

    }

}

