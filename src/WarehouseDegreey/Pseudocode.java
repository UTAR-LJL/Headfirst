package WarehouseDegreey;

import com.sun.tools.javac.code.Type.ForAll;

public class Pseudocode {

	
	
	
	
	
	eventSimulation() {
		
		for i : orderSum{
			
			initialize(i); // OrderTag; 放入对应stacker；
			
			process(); //orderList已经被schedule排好序，按照orderTag从小到大
			//根据新订单的arrivalTime，处理orderlist里面订单
			//1. 如果某个订单的 orderTag 或者 orderStartTime < arrivalTime,
			//标记该订单完成，计算出该订单的delay = orderTag - arrivalTime 存入orderDelay
			// 修改订单包含的items所在stacker的busyTime，存入stackerExcute
			//
			schedule();
			//把新订单放入orderList，  重新计算剩余订单的orderTag, taskFinishTime = max(stackBusyTime , arrivalTime) + retrievalTime, 排序订单
			//选出tag最小的，修改相同stacker上其它task的waitingTime = stackBusyTime + retrievalTime, 同时修改它们的finishTime = waitingTime+ retrievalTime;
		}
		
		
		
	}
	
int cnt = 0;
for (int i = 0; i < 30; i ++) {
	int x = Math.random();
	if(x < P) {
		cnt ++;
	}
}
itemSum = cnt;
	
}
