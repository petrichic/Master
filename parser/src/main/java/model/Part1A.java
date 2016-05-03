package model;

import item.*;
import item.Item1;

public class Part1A {
	private Item1 Item1;
	private Item2A Item2A;
	private Item2B Item2B;
	private Item3A Item3A;
	
	public Item1 getItem1() {
		return Item1;
	}
	public void setItem1(Item1 item1) {
		this.Item1 = item1;
	}
	public Item2A getItem2A() {
		return Item2A;
	}
	public void setItem2A(Item2A item2a) {
		Item2A = item2a;
	}
	public Item2B getItem2B() {
		return Item2B;
	}
	public void setItem2B(Item2B item2b) {
		Item2B = item2b;
	}
	public Item3A getItem3A() {
		return Item3A;
	}
	public void setItem3A(Item3A item3a) {
		Item3A = item3a;
	}
	@Override
	public String toString() {
		return "Part1A [Item1=" + Item1 + ", Item2A=" + Item2A + ", Item2B=" + Item2B + ", Item3A=" + Item3A + "]";
	}

}
