package question003;

/*
 * ���������https://blog.csdn.net/qq_41231926/article/details/81784418
 */
public class Solution5 {

	public int lengthOfLongestSubstring(String s) {
		int left = 0, right = 0;		//��������Ϊ[left, right]
		int res = 0;
		while(right < s.length()) {
			int index = isDuplicateChar(s, left, right);
			//���s[right]֮ǰ���ֹ�
			//left����ֱ������s[right]֮ǰ���ֵ�λ��+1�ĵط�
			if(index != -1) {
				left = index + 1;
			}
			res = Math.max(res, right - left + 1);
			right++;
		}
		return res;
	}
	
	//�鿴s[left, right - 1]֮���Ƿ����s[right]�������ڣ�������Ӧ�����������򷵻�-1
	private int isDuplicateChar(String s, int left, int right) {
		for(int i = left ; i < right ; i ++)
            if(s.charAt(i) == s.charAt(right))
                return i;
        return -1;
	}
}
