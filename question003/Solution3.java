package question003;

/*
 * ���������https://blog.csdn.net/qq_41231926/article/details/81784418
 */
public class Solution3 {
	
	public int lengthOfLongestSubstring(String s) {

		int[] freq = new int[256];
		int l = 0, r = -1; //��������Ϊs[l...r]
		int res = 0;
		// ������, ѭ����ֹ������������ r + 1 < s.length(), ���뿴Ϊʲô?
		//��Ϊ�ҵ��ǲ������ظ��ַ�����Ӵ�����right�ƶ������ұ�֮��left����������ֻ������Ӵ��ĳ��ȣ�
		while( r + 1 < s.length() ){

			if( r + 1 < s.length() && freq[s.charAt(r+1)] == 0 )
				freq[s.charAt(++r)] ++;
			else    //freq[s[r+1]] == 1
				freq[s.charAt(l++)] --;

			res = Math.max(res, r-l+1);
		}
		return res;
	}
}
