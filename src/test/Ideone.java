package test;

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * 时间并集算法
 * @author hefan
 * @date 创建时间：2017年5月13日 上午11:59:51
 *
 */
/* Name of the class has to be "Main" only if the class is public. */
class Ideone {
	public static void main(String[] args) throws java.lang.Exception {
		List<MyTime> myTimeList = new ArrayList<MyTime>();
		myTimeList.add(new MyTime(7, 9));
		myTimeList.add(new MyTime(9, 15));
		myTimeList.add(new MyTime(2, 6));
		myTimeList.add(new MyTime(1, 5));
		myTimeList.add(new MyTime(2, 4));
		myTimeList.add(new MyTime(10, 12));

		Collections.sort(myTimeList);

		System.out.println(myTimeList.size());

		Stack s = new Stack();
		Stack e = new Stack();
		s.push(0);
		e.push(0);
		for (MyTime time : myTimeList) {
			System.out.println(time.getStart() + " " + time.getEnd());
			if (time.getStart() > time.getEnd())
				throw new Exception("The time is incorrect.");

			if (time.getStart() > (int) e.peek()) // 没有交集
			{
				s.push(time.getStart());
				e.push(time.getEnd());
			} else if (time.getEnd() > (int) e.peek()) // 有部分交集，取并集
			{
				e.pop();
				e.push(time.getEnd());
			}
			// else {} //完全被覆盖
		}

		int total = 0;
		while (!s.empty()) {
			System.out.println(s.peek() + " ~ " + e.peek());
			total += (int) e.pop() - (int) s.pop();
		}
		System.out.println("Total: " + total);
	}
}

class MyTime implements Comparable<MyTime> {
	private int start;
	private int end;

	MyTime() {
	}

	MyTime(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int compareTo(MyTime other) {
		if (start == other.start) {
			return other.end - end;
		}
		return start - other.start;
	}
}
