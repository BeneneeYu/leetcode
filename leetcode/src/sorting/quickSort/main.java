package sorting.quickSort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Leetcode
 * @description:
 * @author: Shen Zhengyu
 * @create: 2020-05-30 10:14
 **/
public class main {
    public static void main(String[] args) throws ParseException {
        //
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      SimpleDateFormat forma2 = new SimpleDateFormat("yyyy.MM.dd");

      //点字符串 到 杠日期
      Date utilDate1 = forma2.parse("2020.01.01");
      System.out.println();

      Date utilDate = format.parse("2020-01-01");
      System.out.println(forma2.format(utilDate));
      System.out.println(format.format(new Date()));
      int[] ar = {1,3,222,4,12312,19248,-33,1213,4283,999,4123,44,5,2123123123,423,4123123,88};
        quickSort(ar,0,ar.length-2,ar.length-1);
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }

    private static void quickSort(int[] array,int start,int end,int piv){
        System.out.println("进行start为" + start + ",end为" + end + ",piv为" + piv);
        if (array.length <= 1 || start > end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = piv;
        while (left < pivot){
            if (array[left] > array[pivot]){
                break;
            }
            left++;
        }
        if (left == pivot){
            quickSort(array,start,end-1,piv-1);
        }
        while(right > start && right >left){
            if (array[right] < array[pivot]){
                break;
            }
            right--;
        }
        if (right != left){
            swap(array,right,left);
            quickSort(array,left+1,right,piv);
        }else{
            quickSort(array,start,right-2,right-1);
            quickSort(array,right+1,end,piv);
        }

    }

    private static void swap(int[] array,int pos1,int pos2){
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
        System.out.println("交换了" + array[pos1] + "和" + array[pos2]);


    }

}
