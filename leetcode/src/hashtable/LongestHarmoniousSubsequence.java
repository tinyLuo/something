package hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 *
 * <code>LongestHarmoniousSubsequence<code>
 * <strong></strong>
 * <p>说明：
 * https://leetcode.com/problems/longest-harmonious-subsequence/description/
 * <li></li>
 * </p>
 * @since 
 * @version 2017年10月25日 下午8:28:41
 * @author luoyao
 */
public class LongestHarmoniousSubsequence {
	
	public int findLHS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for(int num:nums){
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		int result = 0;
		for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
			if(map.containsKey(entry.getKey()+1)){
				result = Math.max(result, map.get(entry.getKey())+map.get(entry.getKey()+1));
			}
		}
		return result;
    }
	
}
