package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
// import java.util.HashSet;
import java.util.HashMap;

public class Array {
    // largest element in an array
    public static int largestInArray(int[] arr) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>largest) {
                largest = arr[i];
            }
        }
        return largest;
    }
    // second largest element in array
    public static int secondLargestElement(int[] arr) {
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>largest) {
                secondLargest = largest;
                largest = arr[i];
            }else if (arr[i]<largest && arr[i]>secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
    // second smallest element in array
    public static int secondSamllestElement(int[] arr) {
        int smallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            }else if (arr[i] != smallest && arr[i]<secondSmallest) {
                secondSmallest = arr[i];
            }
        }
        return secondSmallest;
    }
    // remove duplicte in-place from sorted array
    public static int removeDuplicate(int[] arr) {
        // BRUTE FORCE METHOD
        // HashSet<Integer> set = new HashSet<>();
        // for (int i = 0; i < arr.length; i++) {
        //     set.add(arr[i]);
        // }
        // int setSize = set.size();
        // int j = 0;
        // for (Integer i : set) {
        //     arr[j] = i;
        //     j++;
        // }
        // return setSize;
        // OPTIMAL 2 POINTER METHOD
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i++] = arr[j];
            }
        }
        return i;
    }
    // left rotate by one position
    public static int[] leftRotateByOne(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
        return arr;
    }
    // reverse function
    public static int[] reverseArray(int[] arr, int startIndex, int endIndex) {
        while (startIndex<=endIndex) {
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return arr;
    }
    // left rotate by Dth position
    public static int[] leftRotateByDth(int[] arr, int d) {
        if (arr.length == 0) {
            return arr;
        }
        d = d%arr.length;
        if (d == 0) {
            return arr;
        }
        // int[] temp = new int[d];
        // for (int i = 0; i < temp.length; i++) {
        //     temp[i] = arr[i];
        // }
        // for (int i = d; i < arr.length; i++) {
        //     arr[i-d] = arr[i];
        // }
        // for (int i = arr.length - d; i < arr.length; i++) {
        //     arr[i] = temp[i - (arr.length - d)];
        // }
        // return arr;
        arr = reverseArray(arr, 0, d-1);
        arr = reverseArray(arr, d, arr.length-1);
        arr = reverseArray(arr, 0, arr.length-1);
        return arr;
    }
    // move all zero at last
    public static int[] moveZeroAtLast(int[] arr) {
        // ArrayList<Integer> list = new ArrayList<>();
        // for (int i = 0; i < arr.length; i++) {
        //     if (arr[i] != 0) {
        //         list.add(arr[i]);
        //     }
        // }
        // int i = 0;
        // for (Integer integer : list) {
        //     arr[i] = integer;
        //     i++;
        // }
        // for (int j = list.size(); j < arr.length; j++) {
        //     arr[j] = 0;
        // }
        // return arr;

        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && j == -1) {
                // set the j as the first zero index
                j = i;
            } else if (arr[i] != 0 && j != -1) {
                // swap
                arr[j] = arr[i];
                arr[i] = 0;
                j++;
            }
        }
        return arr;
    }
    // Linear search 
    public static int linearSearch(int[] arr, int findingElement) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == findingElement) {
                return i;
            }
        }
        return -1;
    }
    // Union of array
    public static ArrayList<Integer> unionOfArray(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i<arr1.length && j<arr2.length) {
            if (arr1[i]<=arr2[j]) {
                if(list.size() == 0||list.get(list.size()-1) != arr1[i]){
                    list.add(arr1[i]);
                }
                i++;
            }else{
                if(list.size() == 0||list.get(list.size()-1) != arr2[j]){
                    list.add(arr2[j]);
                }
                j++;
            }
        }
        while (i<arr1.length) {
            if (list.size()==0||list.get(list.size()-1) != arr1[i]) {
                list.add(arr1[i]);
            }
            i++;
        }
        while (j<arr2.length) {
            if(list.size()==0||list.get(list.size()-1) != arr2[j]){
                list.add(arr2[j]);
            }
            j++;
        }
        return list;
    }
    // Intersection of 2 array
    public static ArrayList<Integer> intersectionOfArray(int[] arr1, int[] arr2) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i<arr1.length && j<arr2.length) {
            if (arr1[i] == arr2[j]) {
                list.add(arr1[i]);
                i++;
                j++;
            }else if (arr1[i]<arr2[j]) {
                i++;
            }else{
                j++;
            }
        }
        return list;
    }
    // Find missing number
    public static int findMissingNumber(int[] arr, int k) {
        int xor1 = 0;
        for (int i = 0; i < arr.length; i++) {
            xor1 ^= arr[i];
        }
        int xor2 = 0;
        for (int i = 1; i <= k ; i++) {
            xor2 ^= i;
        }
        return xor2^xor1;
    }
    // Maximum consecutive one's
    public static int maximumConsecutiveOne(int arr[]) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }else{
                count = 0;
            }
            max = Integer.max(max, count);
        }
        return max;
    }
    // find the number that come once where other come twice
    public static int findTheElementThatAppearOnce(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans ^= arr[i];
        }
        return ans;
    }
    // Longest subarray with sum k
    public static int longestSubarraySumK(int[] arr, int k) {
        // Brute
        // int len = Integer.MIN_VALUE;
        // for (int i = 0; i < arr.length; i++) {
        //     int sum = 0;
        //     for (int j = i; j < arr.length; j++) {
        //         sum += arr[j];
        //         if (sum == k) {
        //             len = Integer.max(len, (j-i)+1);
        //         }
        //     }
        // }
        // return len;

        // Better 
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int sum = 0;
        // int len = Integer.MIN_VALUE;
        // for (int i = 0; i < arr.length; i++) {
        //     sum += arr[i];
        //     if (sum == k) {
        //         len = Integer.max(len, i);
        //     }
        //     if (map.containsKey(sum-k)) {
        //         len = Integer.max(len, i-map.get(sum-k));
        //     }
        //     if (map.containsKey(sum) == false) {
        //         map.put(sum, i);
        //     }
        // }
        // return len;

        // optimal
        int j = 0;
        int sum = 0;
        int len = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                len = Integer.max(len, (i-j)+1);
            }
            while (sum > k) {
                sum = sum-arr[j];
                j++;
            }
        }
        return len;
    }
    // 2 sum problem 
    public static boolean twoSum(int[] arr, int target) {
        // Brute
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = i+1; j < arr.length; j++) {
        //         if (arr[i]+arr[j] == target) {
        //             return true;
        //         }
        //     }
        // }
        // return false;

        // Better
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < arr.length; i++) {
        //     int rem = target - arr[i];
        //     if (map.containsKey(rem)) {
        //         return true;
        //     }
        //     map.put(arr[i], i);
        // }
        // return false;

        // optimal
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length-1;
        while (i<j) {
            int total = arr[i]+arr[j];
            if (total == target) {
                return true;
            }else if (total<target) {
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
    // swap in array
    public static void swap(int position1, int position2, int[] arr) {
        int temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temp;
    }
    // Sorted the array filled with 0's, 1's and 2(Dutch national flag allgorithm)
    public static int[] sortArrayWithZeroOneAndTwo(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while (mid<=high) {
            if (arr[mid] == 0) {
                swap(low, mid, arr);
                low++;
                mid++;
            }else if (arr[mid] == 1) {
                mid++;
            }else if (arr[mid] == 2) {
                swap(mid, high, arr);
                high--;
            }
        }
        return arr;
    }
    // Mejority element inside an Array(Moore's voting algorithm)
    public static int mejorityElement(int[] arr) {
        // Better 
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < arr.length; i++) {
        //     if (map.containsKey(arr[i])) {
        //         int value = map.get(arr[i]);
        //         value++;
        //         map.put(arr[i],value);
        //     }else{
        //         map.put(arr[i], 1);
        //     }
        // }
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if(entry.getValue()>arr.length/2){
        //         return entry.getKey();
        //     }
        // }
        // return -1;

        // Optimal 
        int cnt = 0;
        int ele = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cnt == 0) {
                ele = arr[i];
                cnt++;
            }else if (arr[i] == ele) {
                cnt++;
            }else if (arr[i] != ele) {
                cnt--;
            }
        }
        if (cnt > 0) {
            cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (ele == arr[i]) {
                    cnt++;
                }
            }
            if (cnt > arr.length/2) {
                return ele;
            }
        }
        return -1;
    }
    // Maximum sub-array sum(Kadan's Algorithm)
    public static int maxSubarraySum(int[] arr) {
        int sum  = 0;
        int max = Integer.MIN_VALUE;
        int ansStart = -1, ansEnd = -1, start = -1;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {start = i;}
            sum += arr[i];
            if (max<sum) {
                max = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(ansStart);
        System.out.println(ansEnd);
        return max;
    }
    public static void main(String[] args) {
        // int[] arr1 = {5,6,7,9};
        // int[] arr = {0,0,1,1,0,1,1,1,0,1,1};
        // int arr[] = {1,2,3,1,1,1,4,2,3};
        // int arr[] = {0,1,1,0,1,2,1,2,0,0,0};
        // int arr[] = {2,2,3,3,1,4,4};
        int arr[] = {-2,-3,4,-1,-2,1,5,-3};
        // int k = 5;
        // int k = 5;
        // System.out.println(secondLargestElement(arr));  
        // System.out.println(secondSamllestElement(arr)); 
        // arr = leftRotateByDth(arr, 3);
        // arr = moveZeroAtLast(arr);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i]+" ");
        // }   
        // System.out.println(intersectionOfArray(arr1, arr2));
        // System.out.println(findMissingNumber(arr, k));
        // System.out.println(maximumConsecutiveOne(arr));
        // System.out.println(findTheElementThatAppearOnce(arr));
        // System.out.println(longestSubarraySumK(arr, k));
        // System.out.println(twoSum(arr, k));
        // for (int i : sortArrayWithZeroOneAndTwo(arr)) {
        //     System.out.print(i+" ");
        // }
        // System.out.println(mejorityElement(arr));
        System.out.println("ans "+maxSubarraySum(arr));
    }
}