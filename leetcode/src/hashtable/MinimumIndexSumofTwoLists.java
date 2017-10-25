package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * <code>MinimumIndexSumofTwoLists<code>
 * <strong></strong>
 * <p>说明：
 * <li>
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
 * </li>
 * </p>
 * @since 
 * @version 2017年10月25日 下午8:10:45
 * @author luoyao
 */
public class MinimumIndexSumofTwoLists {
	
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map = new HashMap<>();
		Map<Integer, List<String>> resultMap = new HashMap<>();
		int min = Integer.MAX_VALUE;
		for( int i = 0 ; i < list1.length ; i++ ) {
			map.put(list1[i], i);
		}
		for( int j = 0 ; j < list2.length ; j++ ) {
			if( map.get(list2[j]) != null ) {
				int len = map.get(list2[j]) + j;
				min = Math.min(len, min);
				List<String> list = resultMap.get(len);
				if( list == null ) {
					list = new ArrayList<>();
					list.add(list2[j]);
					resultMap.put(len, list);
				}else {
					list.add(list2[j]);
				}
			}
		}
		
		return resultMap.get(min).toArray(new String[0]);
	}
	
}
