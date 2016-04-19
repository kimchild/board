package word_scramble;

//단어의 철자를 섞어놓고 원래 단어를 맞춤.
public class WordScrambleEx1 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW" };
		
		String answer = getAnswer(strArr);
		String question = getScrambleWord(answer);
		
		System.out.println("Question:"+question);
		System.out.println("Answer:"+answer);
	}
	
	
	//배열 strArr의 요소중의 하나를 임의로 골라서 반환한다.(Math.random()사용)
	public static String getAnswer(String[] strArr) {
		
		int i = (int) (Math.random()*strArr.length);
		return strArr[i];
	}
	
	//주어진 문자열 str의 각 문자의 순서를 뒤섞은 다음, 새로운 문자열로 반환(Math.random()사용)
	public static String getScrambleWord(String str) {
		
		
		String mStr = str;
		int strLen  = mStr.length();
		int findNum = 0;
		int changeNum = 0;
		char[] mChar = mStr.toCharArray();
		char[] temp = mChar.clone();
		
			
		//변경할 순서의 값 구하기 
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
