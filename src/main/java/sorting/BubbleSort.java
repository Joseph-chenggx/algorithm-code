package sorting;

import org.junit.Test;

/**
 * @Author: Joseph Cheng
 * @Date: 2022/11/9 5:19 下午
 **/
public class BubbleSort {

    @Test
    public void testMethod() {
        Integer[] array1 = new Integer[]{3, 2, 4, 7, 8, 1, 6};
        Integer[] array = new Integer[]{1, 2, 3, 4, 6,8, 7};

        // bubbleSort1(array);
        // bubbleSort2(array);
        bubbleSort3(array);
        for (Integer integer : array) {
            System.out.print(integer);
        }
    }

    /**
     * version1
     * 1、核心是两两比较并且交换
     * 2、理论上n个数字需要比较n-1趟，所以粗略的做了两层循环
     * 3、时间复杂度，O(n^2)
     *
     * @param array 初始数据
     */
    public void bubbleSort1(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * version2
     * 优化：内层循环的上限改成了 j < array.length - i - 1,
     * 每一趟能找出一个最大或者最小的数，比如此处是找出了最大的数，
     * 那么除去最后一个数，每次遍历就无须遍历到最后，做此改进
     *
     * @param array 初始数据
     */
    public void bubbleSort2(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * version3
     * 在version2的基础上再做修改，即如果已经有序的或者中途排列已经有序了，
     * 后面就完全不用再进行后续的遍历排序，交换次数为0时，已经有序了，提前break
     * @param array 初始数据
     */
    public void bubbleSort3(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            //每趟的交换次数
            int exchangeCount = 0;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    exchangeCount++;
                }
            }
            //未曾交换，已经有序
            if (exchangeCount == 0) {
                break;
            }
        }
    }
}
