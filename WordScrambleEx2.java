package word_scramble;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//�ܾ��� ö�ڸ� ������� ���� �ܾ ����.
public class WordScrambleEx2 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW" };
		
		String answer = getAnswer(strArr);
		String question = getScrambleWord(answer);
		
		while(true) {
			
			System.out.println("Question : " + question);
			System.out.println("Your answer is : ");
			
			Scanner sc = new Scanner(System.in);
			String result = sc.next().trim().toUpperCase();
			
			//����ڿ� ���� ����
			if( "Q".equals(result.toUpperCase()) ) {
				System.out.println("����� ��û�� ���� �����մϴ�.");
				System.exit(0);
			}
			
			//���� �� ����
			if(answer.equals(result)) {
				System.out.println("�����Դϴ�.");
				break;
			}
		}
		
	}
	
	
	//�迭 strArr�� ������� �ϳ��� ���Ƿ� ��� ��ȯ�Ѵ�.(Math.random()���)
	public static String getAnswer(String[] strArr) {
		
		int i = (int) (Math.random()*strArr.length);
		return strArr[i];
	}
	
	//�־��� ���ڿ� str�� �� ������ ������ �ڼ��� ����, ���ο� ���ڿ��� ��ȯ(Math.random()���)
	public static String getScrambleWord(String str) {
		
		String mStr = str;
		int strLen  = mStr.length();
		
		//�ܾ���� 2�踸ŭ �ݺ�
		for(int i = 0; i < strLen*2; i++) {
			
			mStr = randomSwap(mStr);
		}
		
		//�� �������� ���� �������� �������� �ٽ� ����
		if(str.equals(mStr))
			getScrambleWord(str);
			
		return mStr;
	}
	
	//map�� �ִ� ���� int[] ���·� ��ȯ
	public static int[] mapToIntegerArray(Map<Integer, Integer> mRet) {
		
		//�ߺ��˻� ȿ���� ���ؼ� map���� �Ҵ��ϰ� int[]���·� ��ȯ
		int[] iArr = new int[mRet.size()];
		Set<Integer> set = mRet.keySet();
		Iterator<Integer> itr = set.iterator();
		int i = 0;
		
		while(itr.hasNext()) {
			
			iArr[i++] = itr.next();
		}
		
		return iArr;
	}
	
	//���� ���ڰ� ���ϱ�
	public static int[] randomInt(int maxLength, int count) {
		
		//��������
		if(maxLength < count)
			return null;
		
		int max = maxLength;
		int cnt = count;
		int ran = 0;
		Map<Integer, Integer> mRet = new HashMap<Integer, Integer>();

		//������ŭ map�� �� �Ҵ�
		for(int i = 0; i < cnt; i++) {
			
			//���� �� �Է�
			
			//�ߺ�üũ �� �� �Է�
			while(true) {
			
				ran = (int)(Math.random()*max);
					
				if(!mRet.containsKey(ran)) {
					mRet.put(ran, ran);
					break;
				}
			}
			
		}
		
		
		return mapToIntegerArray(mRet);
	}

	
	//strWord �� ����
	public static String randomSwap(String strWord) {
		
		String strRet   = null;
		int strLen      = strWord.length();
		int changeCount = 2;
		
		char[] chWord = strWord.toCharArray();
		char[] temp   = chWord.clone();
		
		
		int[] iArr = randomInt(strLen, changeCount);
		
		temp[iArr[1]] = chWord[iArr[0]];
		temp[iArr[0]] = chWord[iArr[1]];
		
		strRet = new String(temp);
		return strRet;
	}

	

}
