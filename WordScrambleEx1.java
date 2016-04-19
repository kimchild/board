package word_scramble;

//�ܾ��� ö�ڸ� ������� ���� �ܾ ����.
public class WordScrambleEx1 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW" };
		
		String answer = getAnswer(strArr);
		String question = getScrambleWord(answer);
		
		System.out.println("Question:"+question);
		System.out.println("Answer:"+answer);
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
		int findNum = 0;
		int changeNum = 0;
		char[] mChar = mStr.toCharArray();
		char[] temp = mChar.clone();
		
			
		//������ ������ �� ���ϱ� 
		findNum   = (int) (Math.random()*strLen);
		changeNum = (int) (Math.random()*strLen);
		
		while( findNum == changeNum )
			changeNum = (int) (Math.random()*strLen);
		
		
		temp[findNum]   = mChar[changeNum];
		temp[changeNum] = mChar[findNum];
		
		
		for(int k = 0; k < temp.length; k++) {
			System.out.println(" k for : " + temp[k]);
		}
		System.out.println("-----------------");

			
			
		mStr = new String(temp);
		
		return mStr;
	}

}
