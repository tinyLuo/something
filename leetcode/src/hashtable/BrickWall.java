package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * <code>BrickWall<code>
 * <strong></strong>
 * <p>说明：
 * https://leetcode.com/problems/brick-wall/description/
 * <li></li>
 * </p>
 * @since 
 * @version 2017年10月25日 下午8:44:15
 * @author luoyao
 */
public class BrickWall {
	public static int leastBricks(List<List<Integer>> wall) {
		if(wall == null || wall.size() == 0)	return 0;
		int hightTotal = wall.size();
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		//宽度从 1 到 widthTotal-1
		for( List<Integer> row : wall ) {
			int len = 0;
			for( int i = 0 ; i < row.size()-1 ; i++ ) {
				len += row.get(i);
				map.put(len, map.getOrDefault(len, 0)+1);
			}
		}
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			max = Math.max(entry.getValue(),max);
		}
		return hightTotal-max;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1,2,2,1));
		list.add(Arrays.asList(3,1,2));
		list.add(Arrays.asList(1,3,2));
		list.add(Arrays.asList(2,4));
		list.add(Arrays.asList(3,1,2));
		list.add(Arrays.asList(1,3,1,1));
		leastBricks(list);
	}
}
