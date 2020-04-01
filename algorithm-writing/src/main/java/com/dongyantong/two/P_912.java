package com.dongyantong.two;

/**
 * @Author: dongyantong
 * @Date: 2020/3/31
 */
public class P_912 {
    public static void main(String[] args) {

    }

    // 快速排序 选择一个基准点 使基准点两边的有序
    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            // 选取第一个点为基准点
            int pivot = arr[start];
            int low = start;
            int high = end;
            // 循环对比对基准数小和大的数字
            while (low < high) {
                while (low < high && pivot <= arr[high]) {
                    high--;
                }
                // 如果比基数大 用低位数字替换高位数字
                arr[low] = arr[high];
                while (low < high && arr[low] <= pivot) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = pivot;
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }
}
