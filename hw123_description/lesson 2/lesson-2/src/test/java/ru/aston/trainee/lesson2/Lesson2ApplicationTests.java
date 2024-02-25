package ru.aston.trainee.lesson2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.aston.trainee.lesson2.myAraryList.MyArraylist;

import java.util.Comparator;

@SpringBootTest
class Lesson2ApplicationTests {
	MyArraylist<Integer> str = new MyArraylist<>();
	@BeforeEach
			void makeAMyArraylist(){
		str.add(1);
		str.add(65);
		str.add(3);
		str.add(4);
	}
	@Test
	void getAnElement() {
		System.out.println(str.get(1));
	}

	@Test
	void getSizeOfArray(){
		System.out.println(str.size());
	}

	@Test
	void removeAnElement(){
		System.out.println(str.size());
		str.remove(1);
		System.out.println(str.size());
	}
	@Test
	void testIsEmpty() {
		System.out.println(str.size());
		System.out.println(str.isEmpty());
	}
	@Test
	void testIsClear(){
		str.clear();
		System.out.println(str.size());
	}
	@Test
	void sortingArray(){
		str.sort(Comparator.naturalOrder());
		System.out.println(str.get(str.size()-1));
	}

}
