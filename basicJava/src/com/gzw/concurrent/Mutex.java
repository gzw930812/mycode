package com.gzw.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义独占锁 ---AQS实现方式
 * @author gzw
 *
 */
public class Mutex implements Lock {

	private static class Sync extends AbstractQueuedSynchronizer {
		// 是否处于占用状态
		protected boolean isHeldExclusively() {
			return getState() == 1; // 若占用,getstate= 1返回true
		}

		/**
		 * 当状态为0时获取锁
		 * 
		 * @param acquires
		 * @return
		 */
		public boolean tryAcquire(int acquires) {
			System.out.println("尝试获取锁");
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());// 设置同步状态的占有线程为当前线程
				return true;
			}
			return false;
		}

		/**
		 * 释放锁，将当前状态设置为0
		 * 
		 * @param releases
		 * @return
		 */
		protected boolean tryRelease(int releases) {
			if (getState() == 0)
				throw new IllegalMonitorStateException();
			setExclusiveOwnerThread(null); // 将同步状态的占有线程置空，释放同步状态，因为没做重入处理，同一个线程再次加锁时会导致死锁
			setState(0);
			return true;
		}

		/**
		 * 返回一个Condition
		 * 
		 * @return
		 */
		Condition newCondition() {
			return new ConditionObject();
		}
	}
	
	private final Sync sync = new Sync();

	@Override
	public void lock() {
		sync.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit)
			throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		sync.release(1);

	}

	@Override
	public Condition newCondition() {
		return sync.newCondition();
	}

}
