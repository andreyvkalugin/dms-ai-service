package ru.kalugin.ai.yandex.src.com.company;

import java.util.Arrays;

public class myAlgo {
    public static void main1(String[] args) {
        //selection sort
        int[] arr = {1, 0, -1, 7, 6, 9, 8};
        for (var i = 0; i < arr.length; i++) {
            var ind = i;
            for (var j = i; j < arr.length; j++) {
                if (arr[j] < arr[ind]) {
                    ind = j;
                }
            }
            swap(arr, i, ind);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main2(String[] args) {
        //bubble sort
        int[] arr = {1, 0, -1, 7, 6, 9, 8};
        for (var i = 0; i < arr.length; i++) {
            for (var j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    public static void main4(String[] args) {
        //insertion sort
        int[] arr = {1, 0, -1, 10, 6, 9, 8};
        for (var i = 1; i < arr.length; i++) {
            var j = i - 1;
            var temp = arr[i];
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    //shell sort
    public void sort(int arrayToSort[]) {
        int n = arrayToSort.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arrayToSort[i];
                int j = i;
                while (j >= gap && arrayToSort[j - gap] > key) {
                    arrayToSort[j] = arrayToSort[j - gap];
                    j -= gap;
                }
                arrayToSort[j] = key;
            }
        }
    }

    public static void main78(String[] args) {
        int[] arr = {1, 6, 2, 34, 67, 1, 2, 45, 4, 3, 11};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                swap(source, leftMarker, rightMarker);
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }

        } while (leftMarker < rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 34, 67, 1, 2, 45, 4, 3, 11};
        mergeSortM(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void mergeSortM(int[] source, int left, int right) {
        // Выберем разделитель, т.е. разделим пополам входной массив
        int delimiter = left + ((right - left) / 2) + 1;
        // Выполним рекурсивно данную функцию для двух половинок (если сможем разбить(
        if (delimiter > 0 && right > (left + 1)) {
            mergeSortM(source, left, delimiter - 1);
            mergeSortM(source, delimiter, right);
        }
        // Создаём временный массив с нужным размером
        int[] buffer = new int[right - left + 1];
        // Начиная от указанной левой границы идём по каждому элементу
        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {
            // Мы используем delimeter чтобы указывать на элемент из правой части
            // Если delimeter > right, значит в правой части не осталось недобавленных элементов
            if (delimiter > right || source[cursor] > source[delimiter]) {
                buffer[i] = source[cursor];
                cursor++;
            } else {
                buffer[i] = source[delimiter];
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, source, left, buffer.length);
    }


    //heap sort
    public static void sortHeap(int arr[]) {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int arr[], int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }

    public static void mergeSort(int[] source, int left, int right) {
        // Выберем разделитель, т.е. разделим пополам входной массив
        // 0 + 0 + 1
        int delimiter = left + ((right - left) / 2) + 1;
        // Выполним рекурсивно данную функцию для двух половинок (если сможем разбить(
        if (delimiter > 0 && right > (left + 1)) {
            mergeSort(source, left, delimiter - 1);
            mergeSort(source, delimiter, right);
        }

        var leftMarker = left;
        var rightMarker = delimiter;
        var pointer = left;
        var flag1 = false;
        var flag2 = false;
        var bufferArray = new int[right - left + 1];
        while (true) {

            if ((source[leftMarker] <= source[delimiter] && !flag1) || flag2) {
                bufferArray[pointer] = source[leftMarker];
                if (leftMarker < rightMarker - 1) {
                    leftMarker += 1;
                } else {
                    flag1 = true;
                }
                pointer++;
            }
            if (flag1 && flag2) {
                break;
            }
            if ((source[leftMarker] > source[delimiter] && !flag2) || flag1) {
                bufferArray[pointer] = source[delimiter];
                if (delimiter < right) {
                    delimiter += 1;
                } else {
                    flag2 = true;
                }
                pointer++;
            }
            if (flag1) {
                leftMarker = delimiter;
            }
            if (flag2) {
                delimiter = leftMarker;
            }
            if (flag1 && flag2) {
                break;
            }
        }

        //System.out.println(Arrays.toString(bufferArray));
        System.arraycopy(bufferArray, 0, source, left, bufferArray.length);
    }

    private static void swap1(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}
