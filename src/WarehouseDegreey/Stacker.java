package WarehouseDegreey;

import java.util.ArrayList;

public class Stacker {
	ArrayList<Task> task;
	ArrayList<Task> scheduledTask;
	ArrayList<Task> executedTask;
	int busyTime;
	int realBusyTime;
	Stacker (){
		task = new ArrayList<Task>();
		scheduledTask = new ArrayList<Task>();
		executedTask = new ArrayList<Task>();
	}

}
