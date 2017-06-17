package test;

/**
 * String contains追踪源码
 * @author hefan
 * @date 创建时间：2017年1月22日 上午9:13:28
 *
 */
public class StringContain {
	public static void main(String[] args) {
		String a = "abcd";
		
		String b = "abcd";
		
//		if(a.contains(b)){
//			System.out.println(true);
//		}else{
//			System.out.println(false);
//		}
		
		int tmp = indexOf(a.toCharArray(), 0, a.length(),
                b.toCharArray(), 0, b.length(), 0);
	}
	
	static int indexOf(char[] source, int sourceOffset, int sourceCount,
            char[] target, int targetOffset, int targetCount,
            int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
}
