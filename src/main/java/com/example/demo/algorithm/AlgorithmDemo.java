package com.example.demo.algorithm;

import java.util.Arrays;

/**
 * Created by wangrong 2020/2/13
 */
public class AlgorithmDemo {

    public static void main(String[] args) {

//        // 二分查找测试
//        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6};
//        System.out.println(binarySearch(arr1, 1));

//        // 冒泡排序测试
//        int[] arr2 = new int[]{8, 2, 3, 4, 7, 1};
//        arr2 = bubbleSort(arr2);
//        for (int i = 0; i < arr2.length; i++) {
//            System.out.println(arr2[i]);
//        }

//        // 快排测试
//        int[] arr3 = new int[]{6, 8, 2, 3, 4, 7, 1, 5};
//        int start = 0;
//        int end = arr3.length - 1;
//        quickSort(arr3, start, end);
//        for (int i = 0; i < arr3.length; i++) {
//            System.out.println(arr3[i]);
//        }

//        // 插入排序测试
//        int[] arr4 = new int[]{6, 8, 2, 3, 4, 7, 1, 5};
//        simpleInsertSort(arr4);
//        for (int i = 0; i < arr4.length; i++) {
//            System.out.println(arr4[i]);
//        }

//        // 简单选择排序测试
//        int[] arr5 = new int[]{6, 8, 2, 3, 4, 7, 1, 5};
//        simpleSelectSort(arr5);
//        for (int i = 0; i < arr5.length; i++) {
//            System.out.println(arr5[i]);
//        }

//        // 堆排序测试
//        int[] arr6 = new int[]{6, 8, 2, 3, 4, 7, 1, 5};
//        heapSort(arr6);
//        for (int i = 0; i < arr6.length; i++) {
//            System.out.println(arr6[i]);
//        }

//        // 二路归并排序测试
//        int[] arr7 = new int[]{6, 8, 2, 3, 4, 7, 1, 5};
//        int[] sortArr = mergeSort(arr7);
//        for (int i = 0; i < sortArr.length; i++) {
//            System.out.println(sortArr[i]);
//        }

//        // 计数排序测试
//        int[] arr8 = new int[]{6, 8, 2, 3, 4, 7, 1, 5};
//        int[] sortArr = countSort(arr8, 8);
//        for (int i = 0; i < sortArr.length; i++) {
//            System.out.println(sortArr[i]);
//        }

        // 桶排序测试
        int[] arr9 = new int[]{16, 8, 25, 38, 4, 7, 1, 5};
        int[] sortArr = bucketSort(arr9, 3);
        for (int i = 0; i < sortArr.length; i++) {
            System.out.println(sortArr[i]);
        }


    }


    /**
     * 二分查找
     * 时间复杂度: O(1) ~ O(log2^n)
     * 空间复杂度: O(1)
     *
     * @param arr 有序数组
     * @param key 查找的目标值
     * @return
     */
    public static boolean binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (key == arr[mid]) {
                return true;
            }
            if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 冒泡排序
     * 时间复杂度: O(n) ~ O(n^2)
     * 空间复杂度: O(1)
     * 稳定性：稳定
     *
     * @param arr 无序数组
     * @return 有序数组
     */
    public static int[] bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            boolean sorted = true;
            for (int j = 0; j <= len - 2 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                    sorted = false;
                }
            }
            if (sorted) {
                return arr;
            }
        }
        return arr;
    }

    /**
     * 快排
     * 时间复杂度: O(nlog2^n) ~ O(n^2)
     * 空间复杂度: O(nlog2^n)
     * 稳定性：不稳定
     *
     * @param arr   无序数组
     * @param start 开始位置
     * @param end   结束位置
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = start;
        int index = pivot + 1;
        for (int i = index; i <= end; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        quickSort(arr, start, index - 2);
        quickSort(arr, index, end);
    }


    /**
     * 简单插入排序
     * 时间复杂度: O(n) ~ O(n^2)
     * 空间复杂度: O(1)
     * 稳定性： 稳定
     *
     * @param arr
     */
    public static void simpleInsertSort(int[] arr) {
        int len = arr.length - 1;
        for (int i = 1; i <= len; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }


    /**
     * 希尔排序
     * 时间复杂度: O(n) ~ O(n^2)
     * 空间复杂度: O(1)
     * 稳定性： 不稳定
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int len = arr.length;
        for (int gap = (int) Math.floor(len / 2); gap > 0; gap = (int) Math.floor(gap / 2)) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
    }


    /**
     * 简单选择排序
     * 时间复杂度: O(n^2) ~ O(n^2)
     * 空间复杂度: O(1)
     * 稳定性： 不稳定
     *
     * @param arr
     */
    public static void simpleSelectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
    }


    /**
     * 堆排序
     * 时间复杂度: O(nlog2^n) ~ O(nlog2^n)
     * 空间复杂度: O(1)
     * 稳定性： 不稳定
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        int len = arr.length;
        buildMaxHeap(arr, len);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, 0);
            len--;
            adjustment(arr, 0, len);
        }
    }

    /**
     * 构建最大堆
     *
     * @param arr 无序数组
     * @param len 数组长度
     */
    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustment(arr, i, len);
        }
    }

    /**
     * 调整堆
     *
     * @param arr  无序数组
     * @param root 根节点下标
     * @param len  待调整数组长度
     */
    private static void adjustment(int[] arr, int root, int len) {
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        int largest = root;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != root) {
            swap(arr, largest, root);
            adjustment(arr, largest, len);
        }
    }

    /**
     * 二路归并排序
     * 时间复杂度: O(nlog2^n) ~ O(nlog2^n)
     * 空间复杂度: O(n)
     * 稳定性： 稳定
     *
     * @param arr 无序数组
     * @return
     */
    public static int[] mergeSort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return arr;
        }
        int middle = len / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, len);
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * 合并两个有序数组
     *
     * @param left  左有序数组
     * @param right 右有序数组
     * @return
     */
    private static int[] merge(int[] left, int[] right) {
        int len = left.length + right.length;
        int[] arr = new int[len];
        int arrIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                arr[arrIndex++] = left[leftIndex++];
            } else {
                arr[arrIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            arr[arrIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            arr[arrIndex++] = right[rightIndex++];
        }
        return arr;
    }


    /**
     * 计数排序
     * 时间复杂度: O(n+k) ~ O(n+k)
     * 空间复杂度: O(n+k)
     * 稳定性： 稳定
     *
     * @param arr    无序数组
     * @param maxVal 无序数组的最大值
     * @return
     */
    public static int[] countSort(int[] arr, int maxVal) {
        int[] bucket = new int[maxVal + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]] += 1;
        }
        int index = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j] > 0) {
                arr[index++] = j;
                bucket[j] -= 1;
            }
        }
        return arr;
    }

    /**
     * 桶排序
     * 时间复杂度: O(n) ~ O(n^2)
     * 空间复杂度: O(n+k)
     * 稳定性： 稳定
     * @param arr
     * @param bucketSize
     * @return
     */
    public static int[] bucketSort(int[] arr, int bucketSize) {
        int DEFAULT_BUCKET_SIZE = 5;
        bucketSize = bucketSize >= 0 ? bucketSize : DEFAULT_BUCKET_SIZE;
        int minVal = arr[0];
        int maxVal = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= minVal) {
                minVal = arr[i];
            } else if (arr[i] >= maxVal) {
                maxVal = arr[i];
            }
        }
        int bucketCount = (maxVal - minVal) / bucketSize + 1;
        int[][] bucketArr = new int[bucketCount][0];
        int len;
        int[] bucketInnerArr;
        int[] newInnerArr;
        for (int j = 0; j < arr.length; j++) {
            bucketInnerArr = bucketArr[(arr[j] - minVal) / bucketSize];
            len = bucketInnerArr.length;
            newInnerArr = new int[len + 1];
            System.arraycopy(bucketInnerArr, 0, newInnerArr, 0, len);
            newInnerArr[len] = arr[j];
            bucketArr[(arr[j]-minVal) / bucketSize] = newInnerArr;
        }
        int arrIndex = 0;
        for (int b = 0; b < bucketArr.length; b++) {
            simpleInsertSort(bucketArr[b]);
            for (int dex = 0; dex < bucketArr[b].length; dex++) {
                arr[arrIndex++] = bucketArr[b][dex];
            }
        }
        return arr;
    }

}
