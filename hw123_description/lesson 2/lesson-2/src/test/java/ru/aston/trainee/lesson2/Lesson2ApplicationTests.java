package ru.aston.trainee.lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import ru.aston.trainee.lesson2.myAraryList.MyArraylist;

import java.util.Comparator;

@SpringBootTest
class Lesson2ApplicationTests {
	MyArraylist<Integer> myIntArrayDemo = new MyArraylist<>();
	@BeforeEach
	void makeAMyArraylist(){
		myIntArrayDemo.add(1);
		myIntArrayDemo.add(65);
		myIntArrayDemo.add(3);
		myIntArrayDemo.add(4);
	}
	@Test
	void getAnElement() {
	Assertions.assertEquals(myIntArrayDemo.get(1), 65);
	}

	@Test
	void getSizeOfArray(){
		Assertions.assertEquals(myIntArrayDemo.size(), 4);
	}

	@Test
	void removeAnElement(){
		Assertions.assertEquals(myIntArrayDemo.size(), 4);
		myIntArrayDemo.remove(1);
		Assertions.assertEquals(myIntArrayDemo.size(), 3);

	}
	@Test
	void testIsEmpty() {
		Assertions.assertEquals(myIntArrayDemo.size()>0, !myIntArrayDemo.isEmpty());
	}
	@Test
	void testIsClear(){
		myIntArrayDemo.clear();
		Assertions.assertEquals(myIntArrayDemo.size(), 0);

	}
	@Test
	void sortingArray(){
		myIntArrayDemo.sort(Comparator.naturalOrder());
		Assertions.assertEquals(myIntArrayDemo.get(0),1 );
		Assertions.assertEquals(myIntArrayDemo.get(myIntArrayDemo.size()-1), 65);
	}

}
