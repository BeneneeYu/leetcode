package sorting.quickSort;

/**
 * @program: leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2021-03-31 21:04
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] num = new int[]{1,3,222,4,12312,19248,-33,1213,4283,999,4123,44,5,2123123123,423,4123123,88};
        for(int a:quickSort(num, 0, num.length-1)) {
            System.out.print(a+" ");
        }
    }
    public static int[] quickSort(int[] num, int leftPos, int rightPos) {
        if(rightPos < leftPos)
            return num;
        else {
            //将数列最左边第一个数字作为基准数
            int initLeftPos = leftPos;
            int initRightPos = rightPos;
            int baseNum = num[leftPos];

            while(rightPos > leftPos) {
                //第二步：右边指针找到小于基准数的就停下
                while(num[rightPos] >= baseNum & rightPos > leftPos) {
                    rightPos--;
                }

                //第二步：左边指针找到大于基准数的就停下
                while(num[leftPos] <= baseNum & rightPos > leftPos) {
                    leftPos++;
                }

                //交换两个指针最终标记的数字
                if(rightPos > leftPos)
                    swap(num,leftPos,rightPos);
            }

            //当左右两边指针重合时，将基准数与指针指向数字交换
            swap(num,leftPos,initLeftPos);

            //指针左半边递归，以进来的数组的左边为界，右边是左右指针相同时左边一个
            quickSort(num, initLeftPos, leftPos-1);

            //右边同理
            quickSort(num, rightPos+1, initRightPos);

            return num;
        }
    }

    //swap方法：将数组中leftPos和rightPos上的两个数值进行交换
    public static void swap(int[] num,int leftPos,int rightPos) {
        int temp = num[leftPos];
        num[leftPos] = num[rightPos];
        num[rightPos] = temp;
    }
}