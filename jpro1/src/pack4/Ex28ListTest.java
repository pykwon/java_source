package pack4;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex28ListTest {
	public static void main(String[] args) {
		// List류의 ArrayList로 연습 : 중복 가능, 순서O
		ArrayList<String> list = new ArrayList<String>();
		list.add("lee");
		list.add("lee");
		list.add("lee");
		list.add("park");
		list.add("hong");
		//list.remove("park");
		list.remove(0);   // List는 가능, Set은 불가
		//list.clear();
		System.out.println("크기 : " + list.size());
		
		for(Object obj:list) {
			System.out.println(obj);
		}
		
		System.out.println();
		// Iterator(반복자) : 개발자가 컨테이너, 특히 리스트를 순회할 수 있게 해주는 객체다.
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			String ss = (String)iter.next();
			System.out.println(ss);
		}
	}

}
