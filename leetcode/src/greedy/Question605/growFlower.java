package greedy.Question605;

public class growFlower {
//    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        if (n == 0) return true;
//        int length = flowerbed.length;
//        if (length == 1){
//            if (flowerbed[0] == 0 && n <= 1){
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//        if (flowerbed[0] == 0 && flowerbed[1] == 0){
//            flowerbed[0] = 1;
//            n--;
//        }
//        for (int i = 1; i < length-1; i++) {
//            if (n == 0) return true;
//            if (flowerbed[i-1] == 0 && flowerbed[i+1] == 0 && flowerbed[i] == 0) {
//                flowerbed[i] = 1;
//                n--;
//            }
//        }
//        if (flowerbed[length-2] == 0 && flowerbed[length-1] == 0)n--;
//        return n == 0;
//    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
                int length = flowerbed.length;
                int[] temp = new int[flowerbed.length+2];
                System.arraycopy(flowerbed,0,temp,1,length);
//        for (int i = 0; i < length+2; i++) {
//            System.out.println(temp[i]);
//        }
                for (int i = 1; i < length + 1; i++) {
            if (n == 0) return true;
            if (temp[i-1] == 0 && temp[i+1] == 0 && temp[i] == 0) {
                temp[i] = 1;
                n--;
            }
        }
                return n==0;
    }
    public static void main(String[] args) {
        int[] t = new int[]{1,0,0,0,1,0,0};
        growFlower g = new growFlower();
        System.out.println(g.canPlaceFlowers(t, 2));
    }
}
