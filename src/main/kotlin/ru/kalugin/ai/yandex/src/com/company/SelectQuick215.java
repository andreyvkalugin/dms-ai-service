package ru.kalugin.ai.yandex.src.com.company;

class SelectQuick215 {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{5, 2, 4, 1, 3, 6, 0}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }

        return quickSort1(nums.length - k, nums, 0, nums.length - 1);
    }

    public static int quickSort1(int k, int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        var pivotIndex = (leftMarker + rightMarker) / 2;
        int pivot = source[pivotIndex];
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
                var a = source[leftMarker];
                var b = source[rightMarker];
                swap(source, leftMarker, rightMarker);
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }

        } while (leftMarker < rightMarker);

        if (k == leftMarker && (leftBorder > rightMarker)) {
            return source[k];
        } else if ((k < leftMarker) && (leftBorder < rightMarker)) {
            return quickSort1(k, source, leftBorder, rightMarker);
        } else if (leftMarker < rightBorder) {
            return quickSort1(k, source, leftMarker, rightBorder);
        } else {
            return source[k];
        }
    }

    public static int quickSort2(int k, int[] nums, int start, int end) {

        int pivot = nums[end];

        int left = start;
        int right = end;

        while (true) {

            while (nums[left] < pivot && left < right) {
                left++;
            }

            while (nums[right] >= pivot && right > left) {
                right--;
            }

            if (left == right) {
                break;
            }

            swap(nums, left, right);
        }

        swap(nums, left, end);

        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return quickSort2(k, nums, start, left - 1);
        } else {
            return quickSort2(k, nums, left + 1, end);
        }
    }

    public static void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }
}
