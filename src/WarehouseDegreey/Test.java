package WarehouseDegreey;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		Order a = new Order(1, 3);
		Order b = a;
		System.out.println(a == b);
		System.out.println(a);

	}

}