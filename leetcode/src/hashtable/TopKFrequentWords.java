package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 *
 * <code>TopKFrequentWords<code>
 * <strong></strong>
 * <p>说明：
 * <li>https://leetcode.com/problems/top-k-frequent-words/description/</li>
 * </p>
 * @since 
 * @version 2017年10月23日 下午10:14:34
 * @author luoyao
 */
public class TopKFrequentWords {
	
	public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
		if(words==null||words.length==0) {
        	return result;
        }
		Map<String, Integer> wordCount = new HashMap<>();
		Arrays.asList(words)
			.stream()
			.forEach(key->wordCount.put(key,wordCount.getOrDefault(key, 0)+1));
		Map<Integer, List<String>> reverse = new HashMap<>();
		List<Integer> countList = new ArrayList<>();
		wordCount.entrySet()
			.stream()
			.forEach(entry->{
				List<String> list = reverse.getOrDefault(entry.getValue(), new ArrayList<>());
				if(list.isEmpty()) countList.add(entry.getValue());
				list.add(entry.getKey());
				reverse.put(entry.getValue(), list);
			});
		Collections.sort(countList,(a,b)->b-a);
		int need = k;
		int pos = 0;
		while( need > 0 ) {
			List<String> tmpList = reverse.get(countList.get(pos++));
			Collections.sort(tmpList);
			if( tmpList.size() <= need ) {
				result.addAll(tmpList);
				need -= tmpList.size();
				continue;
			}else {
				for( int i = 0 ; i < need ; i++ ) {
					result.add(tmpList.get(i));
				}
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
		String[] words = new String[]{"i",
		                               "love",
		                               "leetcode",
		                               "i",
		                               "love",
		                               "coding"
		                               };
		topKFrequentWords.topKFrequent(words, 1);
	}
}
