/**
 * 
 */
package ds;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.StringUtils;

import myproject.test;

/**
 * @author bdhakad
 *
 */
public class hk {
	
	
	public static void main(String[] args) {
		hk t = new hk();
		int arr1[] = { 3, 5, 2, 5, 2 }; 
        int arr2[] = { 2, 3, 5, 5, 2 }; 
  
//        if (t.areEqual(arr1, arr2)) 
//            System.out.println("Yes"); 
//        else
//            System.out.println("No"); 
        String string = System.getProperties().toString();
		System.out.println(string);
	}
	
	
	
	public boolean areEqual(int[] arr1, int[] arr2){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        if(arr1.length!= arr2.length) return false;
        
        for(int i=0; i<arr1.length;i++){
            if(map.containsKey(arr1[i])){
               int count =  map.get(arr1[i]);
               map.put(arr1[i], ++count);
            }else {
            	 map.put(arr1[i], 1);
            }
        }
        
        for(int i=0; i<arr2.length;i++){
            if(!map.containsKey(arr2[i])){
               return false;
            }else {
            	if(map.get(arr2[i]) == 0) {
            		return false;
            	}else {
            		int count =  map.get(arr2[i]);
            		map.put(arr2[i], --count);
            	}
            }
        }
		return true;
        
    }
	
	
	
	
	
	
	
	
	
	public int indexOfNonRepeatingCharacter(String str) {

		if (str == null || str == "") {
			return -1;
		}

		Map<Character, CountIndex> map = new HashMap<Character, CountIndex>();

		for (int i = 0; i < str.length(); i++) {

			if (map.containsKey(str.charAt(i))) {
				map.get(str.charAt(i)).count++;
			} else {
				map.put(str.charAt(i), new CountIndex(i));
			}
		}

		for (int i = 0; i < str.length(); i++) {
			if (map.get(str.charAt(i)).count == 1)
				return map.get(str.charAt(i)).index;
		}

		return -1;
	}
	

	public class CountIndex {
		int count, index;

		public CountIndex(int index) {
			count = 1;
			this.index = index;
		}
	}
	
	
	
	public boolean isPalindrome(String A) {
        
        /* Enter your code here. Print output to STDOUT. */
//		StringBuffer sk =  new StringBuffer(A);
		StringBuilder sb = new StringBuilder(A);
        String revStr =sb.reverse().toString();
        if(A.compareTo(revStr) == 0) 
        	return true;
        else
        	return false;
    }
	
	
	public  String getSmallestAndLargest(String s, int k) {
//		t.getSmallestAndLargest("welcometojava", 3);
        String smallest = "";
        String largest = "";
        
        int len = s.length();
        
        for(int i= 0; i<len-k; i++) {
        	String sub = s.substring(i, i+k);
        	if("".equalsIgnoreCase(smallest) && "".equalsIgnoreCase(smallest)) smallest=largest =sub;
        	
        	if(sub.compareTo(smallest)<0) {
        		smallest = sub;
        	}else if(sub.compareTo(largest)>0){
        		largest = sub;
        	}else {
        		
        	}
        	
        }
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        return smallest + "\n" + largest;
    }
	
	
	
}
