package com.samshih.springcloud.lb;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

@Component
public class MyLB implements LoadBalancer {

	private AtomicInteger atomicInteger = new AtomicInteger(0);

	public final int getAndIncrement() {
		int current;
		int next;

		do {
			current = this.atomicInteger.get();
			next = current >= Integer.MAX_VALUE ? 0 : current + 1;
		} while (!this.atomicInteger.compareAndSet(current, next));
		System.out.println("next: " + next);
		return next;
	}

	@Override
	public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
		int index = getAndIncrement() % serviceInstances.size();
		return serviceInstances.get(index);
	}
}
