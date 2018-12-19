package com.gzw.disruptor;

import java.nio.ByteBuffer;
import java.util.Queue;

import com.lmax.disruptor.RingBuffer;

public class LongEventProducer {
	

	private final RingBuffer<LongEvent> ringBuffer;

	public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}
	
	public void onData(ByteBuffer bb){
		
		long sequence = ringBuffer.next();
		try {
			LongEvent event = ringBuffer.getPreallocated(sequence);
			event.setValue(bb.getLong(0));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ringBuffer.publish(sequence);
		}
	}
	
}
