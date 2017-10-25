package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 * <code>EncodeandDecodeTinyURL<code>
 * <strong></strong>
 * <p>说明：
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 * <li></li>
 * </p>
 * @since 
 * @version 2017年10月25日 下午9:13:33
 * @author luoyao
 */
public class EncodeandDecodeTinyURL {
	Map<Integer, String> map = new HashMap<>();
	// Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    	int hashcode = longUrl.hashCode();
        map.put(hashcode, longUrl);
        return String.valueOf(hashCode());
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.valueOf(shortUrl));
    }
}
