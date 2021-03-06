import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize
        int[] a0 = new int[3];
        int[] a1 = {1, 2, 3};
        // 2. Get Length
        System.out.println("The size of a1 is: " + a1.length);
        // 3. Access Element
        System.out.println("The first element is: " + a1[0]);
        // 4. Iterate all Elements
        System.out.print("[Version 1] The contents of a1 are:");
        for (int i = 0; i < a1.length; ++i) {
            System.out.print(" " + a1[i]);
        }
        System.out.println();
        System.out.print("[Version 2] The contents of a1 are:");
        for (int item: a1) {
            System.out.print(" " + item);
        }
        System.out.println();
        // 5. Modify Element
        a1[0] = 4;
        // 6. Sort
        Arrays.sort(a1);
        System.out.print("[Version 3] The contents of a1 are:");
        for (int item: a1) {
            System.out.print(" " + item);
        }

        // 1. initialize
        List<Integer> v0 = new ArrayList<>();
        List<Integer> v1;                           // v1 == null
        // 2. cast an array to a vector
        Integer[] a = {0, 1, 2, 3, 4};
        v1 = new ArrayList<>(Arrays.asList(a));
        // 3. make a copy
        List<Integer> v2 = v1;                      // another reference to v1
        List<Integer> v3 = new ArrayList<>(v1);     // make an actual copy of v1
        // 3. get length
        System.out.println("The size of v1 is: " + v1.size());;
        // 4. access element
        System.out.println("The first element in v1 is: " + v1.get(0));
        // 5. iterate the vector
        System.out.print("[Version 1] The contents of v1 are:");
        for (int i = 0; i < v1.size(); ++i) {
            System.out.print(" " + v1.get(i));
        }
        System.out.println();
        System.out.print("[Version 2] The contents of v1 are:");
        for (int item : v1) {
            System.out.print(" " + item);
        }
        System.out.println();
        // 6. modify element
        v2.set(0, 5);       // modify v2 will actually modify v1
        System.out.println("The first element in v1 is: " + v1.get(0));
        v3.set(0, -1);
        System.out.println("The first element in v3 is: " + v3.get(0));
        // 7. sort
        Collections.sort(v1);
        // 8. add new element at the end of the vector
        v1.add(-1);
        v1.add(1, 6);
        // 9. delete the last element
        v1.remove(v1.size() - 1);

    //  Find Pivot Index

//        int nums[] = {-1,-1,-1,-1,-1,0};
//        int pivotindex = pivotIndex(nums);
//        System.out.println("The pivot index is: " + pivotindex );

   //   Largest Number At Least Twice of Others
        int nums[] = {3, 6, 1, 0};
        int dominantIndex = dominantIndex(nums);
        System.out.println("The dominantIndex index is: " + dominantIndex );


    }
//    Find Pivot Index
    public static int pivotIndex(int[] nums) {

            int leftSum = 0, rightSum = 0;

            for (int i = 0; i < nums.length; i++) {
                rightSum = rightSum+nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                rightSum = rightSum - nums[i];
                if (rightSum == leftSum) {
                    return i;
                }
                leftSum = leftSum+nums[i];
            }
            return -1;
    }

    //    Largest Number At Least Twice of Others

    public static int dominantIndex(int[] nums) {

        int first = -1;
        int second = -1;
        int indexValue = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first){
                second = first;
                first = nums[i];
                indexValue = i;
            }else if (nums[i] > second && nums[i] != first){
                second = nums[i];
            }
        }
        if (first >= second * 2){
            return indexValue;
        } else {
            return -1;
        }
    }

}