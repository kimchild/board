package word_scramble;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//단어의 철자를 섞어놓고 원래 단어를 맞춤.
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
			
			//사용자에 의한 종료
			if( "Q".equals(result.toUpperCase()) ) {
				System.out.println("사용자 요청에 의해 종료합니다.");
				System.exit(0);
			}
			
			//정답 후 종료
			if(answer.equals(result)) {
				System.out.println("정답입니다.");
				break;
			}
		}
		
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
		
		//단어길이 2배만큼 반복
		for(int i = 0; i < strLen*2; i++) {
			
			mStr = randomSwap(mStr);
		}
		
		//값 변경이후 최초 질문값과 같을때는 다시 섞기
		if(str.equals(mStr))
			getScrambleWord(str);
			
		return mStr;
	}
	
	//map에 있는 값을 int[] 형태로 반환
	public static int[] mapToIntegerArray(Map<Integer, Integer> mRet) {
		
		//중복검색 효율을 위해서 map으로 할당하고 int[]형태로 반환
		int[] iArr = new int[mRet.size()];
		Set<Integer> set = mRet.keySet();
		Iterator<Integer> itr = set.iterator();
		int i = 0;
		
		while(itr.hasNext()) {
			
			iArr[i++] = itr.next();
		}
		
		return iArr;
	}
	
	//랜덤 숫자값 구하기
	public static int[] randomInt(int maxLength, int count) {
		
		//에러방지
		if(maxLength < count)
			return null;
		
		int max = maxLength;
		int cnt = count;
		int ran = 0;
		Map<Integer, Integer> mRet = new HashMap<Integer, Integer>();

		//배울수만큼 map에 값 할당
		for(int i = 0; i < cnt; i++) {
			
			//최초 값 입력
			
			//중복체크 및 값 입력
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

	
	//strWord 값 섞기
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
