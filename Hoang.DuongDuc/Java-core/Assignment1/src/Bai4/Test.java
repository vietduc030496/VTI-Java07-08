package Bai4;

public class Test {
    public static void main(String[] args) {
        System.out.println("Day la InsertSort");
        InsertSort numbers1= new InsertSort(5);
        numbers1.input();
        numbers1.sort();
        numbers1.print();


        System.out.println("Day la SelectionSort");
        SelectionSort numbers2= new SelectionSort(5);
        numbers2.input();
        numbers2.sort();
        numbers2.print();

        System.out.println("Day la QuickSort");
        QuickSort numbers3= new QuickSort(5);
        numbers3.input();
        numbers3.sort();
        numbers3.print();


    }
}
