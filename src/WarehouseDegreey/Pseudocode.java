package WarehouseDegreey;

import com.sun.tools.javac.code.Type.ForAll;

public class Pseudocode {

	
	
	
	
	
	eventSimulation() {
		
		for i : orderSum{
			
			initialize(i); // OrderTag; �����Ӧstacker��
			
			process(); //orderList�Ѿ���schedule�ź��򣬰���orderTag��С����
			//�����¶�����arrivalTime������orderlist���涩��
			//1. ���ĳ�������� orderTag ���� orderStartTime < arrivalTime,
			//��Ǹö�����ɣ�������ö�����delay = orderTag - arrivalTime ����orderDelay
			// �޸Ķ���������items����stacker��busyTime������stackerExcute
			//
			schedule();
			//���¶�������orderList��  ���¼���ʣ�ඩ����orderTag, taskFinishTime = max(stackBusyTime , arrivalTime) + retrievalTime, ���򶩵�
			//ѡ��tag��С�ģ��޸���ͬstacker������task��waitingTime = stackBusyTime + retrievalTime, ͬʱ�޸����ǵ�finishTime = waitingTime+ retrievalTime;
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
