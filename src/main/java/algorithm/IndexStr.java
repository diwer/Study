package algorithm;

/**
 * describe: TODO
 *
 * @author: wanheming
 * @since: 2018/1/30
 **/

public class IndexStr {
    /**
     *
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }
        if (target.equals("")) return 0;
        if (target.equals(source)) return 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(0)) {
                if (i + target.length() <= source.length()) {
                    boolean result = true;
                    for (int j = target.length() - 1; j > 0; j--) {
                        if (source.charAt(i + j) != target.charAt(j)) {
                            result = false;
                            break;
                        }
                    }
                    if (result)
                        return i;
                }
            }
        }
        return -1;
    }

}
