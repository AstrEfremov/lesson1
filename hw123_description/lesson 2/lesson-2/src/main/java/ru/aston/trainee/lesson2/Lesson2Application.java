package ru.aston.trainee.lesson2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.aston.trainee.lesson2.myAraryList.MyArraylist;

import java.util.*;

@SpringBootApplication
public class Lesson2Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson2Application.class, args);
		MyArraylist<Integer> list1 = new MyArraylist<>();
		MyArraylist<String> list2 = new MyArraylist<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list2.add("a");
		list2.add("b");
		list2.add("c");
		System.out.println(list1.get(1));
		System.out.println(list2.get(1));

		}

}
