package com.lichao.two;

import java.util.Arrays;

/**
 *
 * desc : top K 问题，采用 堆排序算法
 * @Author: lichao
 * @Date: 2020-04-01 21:23
 */
public class P_215 {

    public static int findKthLargest(int[] nums, int k) {


        int[] topK = Arrays.copyOf(nums, k);
        buildMaxHeap(topK);
        for(int i = k; i < nums.length; i++){
            if (nums[i] > topK[0]){
                topK[0] = nums[i];
                minHeap(topK,topK.length,0);
            }
        }
        return topK[0];
    }




    /**
     * 0
     * 1    2
     * 3  4 5
     */
    static void buildMaxHeap(int[] topK) {
        if (topK == null || topK.length == 1)
            return;
        // 找到第一个非叶子节点
        int cursor = (topK.length / 2) - 1;
        for (int i = cursor; i >= 0; i--) { // 这样for循环下，就可以第一次排序完成
//            maxHeap(array, array.length, i);
            minHeap(topK, topK.length, i);
        }
    }




    // 最小堆
    public static void minHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1; // 左子节点
        int right = index * 2 + 2; // 右子节点
        int maxValue = index; // 暂时定在Index的位置就是最小值

        // 如果左子节点的值，比当前最小的值小，就把最小值的位置换成左子节点的位置
        if (left < heapSize && array[left] < array[maxValue]) {
            maxValue = left;
        }

        //  如果右子节点的值，比当前最小的值小，就把最小值的位置换成左子节点的位置
        if (right < heapSize && array[right] < array[maxValue]) {
            maxValue = right;
        }

        // 如果不相等，说明这个子节点的值有比自己小的，位置发生了交换了位置
        if (maxValue != index) {
            swap(array, index, maxValue); // 就要-交换位置元素

            // 交换完位置后还需要判断子节点是否打破了最小堆的性质。最小性质：两个子节点都比父节点大。
            minHeap(array, heapSize, maxValue);
        }
    }




    // 数组元素交换
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }




    public static void main(String[] args) {
        int[] input = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(input, k));
    }
}
