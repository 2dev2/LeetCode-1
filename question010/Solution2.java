package question010;

/*
 * ���������https://blog.csdn.net/qq_41231926/article/details/82010888
 */
public class Solution2 {

	/*
	 * ״̬���壺f(x, y)------�ַ���s��[0, x - 1]��Χ�ڵ��ַ����ܷ�ƥ���ַ���p��[0, y - 1]��Χ�ڵ��ַ���
	 * ״̬ת�ƣ�
	 * 			1.���p(y) == '.', f(x, y) == f(x - 1, y - 1).
	 * 			2.���p(y) == s(x), f(x, y) == f(x - 1, y - 1).
	 * 			3.���p(y) == '*'
	 * 				3-1.���s(x) == p(y - 1) || p(y - 1) == '.', 
	 * 					3-1-1.ʹ��'*'�Ž���ƥ��-----f(x - 1, y)
	 * 					3-1-2.ֻʹ��'*'��ǰ����Ǹ��ַ�ƥ�䣬��ʹ��'*'ƥ��-----f(x, y - 1)
	 * 					3-1-3.'*'��ǰ����Ǹ��ַ���ƥ��Ĺ��̵���һ������ʹ��-----f(x, y - 2)
	 * 				f(x, y) = f(x - 1, y) || f(x, y - 1) || f(x, y - 2)
	 * 				3-2.���s(x) != p(y - 1) && p(y - 1) != '.'
	 * 					*��ǰ����Ǹ��ַ���ƥ��Ĺ��̵���һ������ʹ�á�
	 * 				f(x, y) = f(x, y - 2)
	 */
	public boolean isMatch(String s, String p) {
		int ns = s.length() + 1;
		int np = p.length() + 1;
		boolean[][] matched = new boolean[ns][np];
		//��s�ַ���Ϊ�յ����⴦��

		//f(0, 0)��ʾs�ַ���Ϊ�գ�p�ַ���Ϊ�յ�����
		matched[0][0] = true;
		//״̬ת�ƹ���
		for (int i = 0; i < ns; i++) {
			for (int j = 1; j < np; j++) {
				if(i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
					matched[i][j] = matched[i - 1][j - 1];
				}
				if(p.charAt(j - 1) == '*') {
					if(i == 0 || (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.')) {
						matched[i][j] = matched[i][j - 2];
					}else {
						matched[i][j] = matched[i - 1][j] || matched[i][j - 1] || matched[i][j - 2];
					}
				}
			}
		}
		return matched[ns - 1][np - 1];
	}
}
