package com.liutao.two;

/**
 * Author liutao
 * Date 2020/4/4 9:42 下午
 * Description:
 * Version: 1.0
 **/
public class P_42 {

    public static void main(String[] args) {
        // int[] aaa = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
          int[] aaa = {0,7,1,4,6};
       // int[] aaa = {5, 4, 1, 2};

        System.out.println(new P_42().trap(aaa));
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * <p>
     * <p>
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     * 通过次数81,818提交次数162,924
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 使用双指针+回朔
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int length = height.length;
        //如果雨水数量小于3, 则接不到雨水
        if (length < 3) {
            return 0;
        }
        int highPoint = 0;
        int sendHighPoint = 0;
        int countData = 0;  //计算柱型体所占的体积
        int maxData = 0;      //计算成功累计到的值  每当出现最高峰的时候进行累计
        int sendHighCountData = 0;

        for (int i = 1; i < length; i++) {
            //但出现最高峰的时候
            if (height[i] >= height[highPoint]) {
                // 最大面积-柱体所占面积-历史最大的面积
                int count = height[highPoint] * (i - highPoint - 1) - countData;
                // 更新累计储水量
                maxData = maxData + count;
                countData = 0;
                highPoint = i;
                sendHighPoint = 0; //第二高点设置为0;
            } else {
                //新的一轮设置
                if (sendHighPoint == 0) {
                    sendHighPoint = i;
                }
                if (height[i] >= height[sendHighPoint]) {
                    sendHighCountData = countData; //更新累计住高
                    sendHighPoint = i;
                }
                countData = countData + height[i];
            }
            if (i == length - 1) {
                int count = height[sendHighPoint] * (sendHighPoint - highPoint - 1) - sendHighCountData;
                if (sendHighPoint == length - 1) {
                    maxData = maxData + count;
                    break;
                }
                //开始缩减到第二高开始 , 将第二高设置成最高
                if (highPoint + 1 < length - 1) {
                    if (highPoint + 1 != sendHighPoint) {
                        maxData = maxData + count; //累计第二高的结果
                    }
                    highPoint = sendHighPoint; //移动最高峰到第二高峰
                    sendHighPoint = 0;
                    i = highPoint ;
                    countData = 0;
                }

            }
        }
        return maxData;
    }

}
