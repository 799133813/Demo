import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // 冒泡排序
        //bubbsort();
        // 选择排序
        //selectSort();
        //插入排序
        //insertSort();

        // 快速排序
       /* int[] arr = {4,3,45,78,23,1,5,6,79,100,32,54,101};
        fastSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));*/

        // 折半查找
        int[] arr = {1, 4, 7, 10, 13, 15, 21, 25};
        System.out.println(halfSort(arr,7));
    }

    // 冒泡排序
    public static void bubbsort() {

        int[] arr = {4, 3, 45, 78, 23, 1, 5, 6, 79, 100, 32, 54, 101};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // 2.选择排序 先认定一个元素为最小值 分别于他们比较
    //  相对于冒泡 先找最小的
    public static void selectSort() {
        int[] arr = {4, 3, 45, 78, 23, 1, 5, 6, 79, 100, 32, 54, 101};
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // 把最小值交换个当前元素
            int t = arr[min];
            arr[min] = arr[i];
            arr[i] = t;
        }
        System.out.println(Arrays.toString(arr));
    }

    //  插入排序 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描
    public static void insertSort() {
        int[] arr = {4, 3, 45, 78, 23, 1, 5, 6, 79, 100, 32, 54, 101};
        for (int i = 0; i < arr.length - 1; i++) {
            int star = i;
            int cunnert = arr[i + 1];
            while (star >= 0 && cunnert < arr[star]) {
                arr[star + 1] = arr[star];
                star--;
            }
            arr[star + 1] = cunnert;
        }
        System.out.println(Arrays.toString(arr));

    }

    // 快速排序 定义一个基础值 并在两边进行大小比较
    public static void fastSort(int arr[], int left, int height) {
        int i, j, t, temp;
        i = left;
        j = height;
        if (left > height) {
            return;
        }
        temp = arr[left];
        while (i != j) {
            //先 队尾 找小于基数的
            while (arr[j] >= temp && i < j) {
                j--;
            }
            //在队首 找大于基数的
            while (arr[i] <= temp && i < j) {
                i++;
            }
            // 第一步 把找到的两个数交换
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //   把当前 元素 给 左左边
        arr[left] = arr[i];
        arr[i] = temp;
        fastSort(arr, left, i - 1);
        fastSort(arr, i + 1, height);
    }

    // 折半查找
    public static int halfSort(int[] arr, int key){
        int min = 0;
        int max = arr.length-1;
        int index = 0;
        while (min <= max){
            index = (max-min)/2+min;
            if(key< arr[index]){
                max = index-1;
            }else  if (key > arr[index]){
                min = index +1;
            }else {
                return  index;
            }
        }
        return  -1;
    }
}
