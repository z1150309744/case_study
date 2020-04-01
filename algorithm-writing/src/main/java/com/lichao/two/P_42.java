package com.lichao.two;

/**
 * @Author: lichao
 * @Date: 2020-01-16 21:35
 */
public class P_42 {

    public static int trap(int[] height) {
        return trap(height, 0, height.length -1 );
    }




    public static int trap(int[] height, int begin, int end) {
        if (end - begin <= 1) {
            return 0;
        }
        int middle = -1;
        for (int i = begin + 1; i < end; i++) {
            if ((height[i] > height[begin] || height[i] > height[end]) && (middle == -1 || height[i] > height[middle])) {
                middle = i;
            }
        }
        if (middle > -1) {
            return trap(height, begin, middle) + trap(height, middle, end);
        }
        int min = Math.min(height[begin], height[end]);
        int total = min * (end - begin -1 );
        for (int i = begin + 1; i < end; i++) {
            total -= height[i];
        }
        return total;
    }




    public static void main(String[] args) {
        int[] input = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
        Integer ret = trap(input);
        System.out.println(
                ret
        );
    }
}
