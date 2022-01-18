package vsu.negulyaevPavelNikolaevich;

import vsu.negulyaevPavelNikolaevich.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Logic {
    public static void sort(List<Integer> list, int index1, int index2){
         // сортировка "пузырьком" для списка по возрастанию
        if(index1 < index2) {
            if(index1 < 0) {index1=list.size()-list.size();}
            if(index2 > list.size()-1) {index2=list.size()-1;}
            for (int i = index2; i > 0; i--) {
                for (int j = index1; j < i; j++) {
                    if (list.get(j) > list.get(j + 1)) {
                        Integer temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                    }
                }
            }
        }
        if(index1 > index2){
            if(index1 > list.size()-1) {index1=list.size()-1;} // возможность того что мы обращаемся за границы index1
            if(index2 < 0) {index2=list.size()- list.size();} // возможность того что мы обращаемся за границы index2
            for (int i = index1; i > 0; i--) {
                for (int j = index2; j < i; j++) {
                    if (list.get(j) < list.get(j + 1)) {
                        Integer temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                    }
                }
            }
        }
/*        public static void bubble (int[] array, int index1, int index2) { // пример работы алгоритма соритровки "пузырьком"
            int data [] = {20, 50, 30, 10, 40};

            for (int start = 0; start < data.length - 1; start++) {
                for (int index = start; index < data.length -1; index++) {
                    if (data[index] < data[index + 1]){
                        int tmp = data[index];
                        data[index] = data[(index + 1)];
                        data[(index + 1)] = tmp;
                    }
                }
            }
        }*/

    }
    /////////////////////////////////////////////////для интерфейсов///////////////////////////////////////
    public static <T> void printCollection(Collection<T> collection) {
        boolean first = true;
        for (T item : collection) {
            System.out.print((first ? "" : ", ") + item);
            first = false;
        }
        System.out.println();
    }
    public static List<Integer> arrToList(int[] arr){
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){
            list.add(arr[i]);
        }
        return list;
    }
    public static int[] readIntArrayFromFile(String fileName) {
        return ArrayUtils.readIntArrayFromFile(fileName);
    }
    public static int[] listToArr(List<Integer> list){
        int[] arr = new int[list.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)list.get(i);
        }
        return arr;
    }

}
