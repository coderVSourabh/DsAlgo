package sourabhs.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sourabh
 * 
 * Behavioural design pattern
 * 
 * Iterator pattern is used to provide a standard way to traverse through a group of Objects. 
 * It is widely used in Java Collection Framework. Iterator interface provides methods for
 * traversing through a collection.
 * Example: java.util.Scanner;  Java Collection Framework
 *
 */

enum FMChannelType {
	ENGLISH, HINDI, FRENCH, ALL;
}

class FMChannel {

	private double frequency;
	private FMChannelType TYPE;
	
	public FMChannel(double freq, FMChannelType type){
		this.frequency=freq;
		this.TYPE=type;
	}

	public double getFrequency() {
		return frequency;
	}

	public FMChannelType getTYPE() {
		return TYPE;
	}
	
	@Override
	public String toString(){
		return "Frequency: " + this.frequency+", Type: " + this.TYPE;
	}
}

interface ChannelCollection {

	public void addChannel(FMChannel c);
	public void removeChannel(FMChannel c);
	public ChannelIterator iterator(FMChannelType type);
}

interface ChannelIterator {

	public boolean hasNext();
	public FMChannel next();
}

/**
 *  inner class implementation of iterator interface so that 
 *  the implementation can't be used by any other collection.
 *
 */
class ChannelCollectionImpl implements ChannelCollection {

	private List<FMChannel> channelsList;

	public ChannelCollectionImpl() {
		channelsList = new ArrayList<>();
	}

	public void addChannel(FMChannel c) {
		this.channelsList.add(c);
	}

	public void removeChannel(FMChannel c) {
		this.channelsList.remove(c);
	}

	@Override
	public ChannelIterator iterator(FMChannelType type) {
		return new ChannelIteratorImpl(type, this.channelsList);
	}

	private class ChannelIteratorImpl implements ChannelIterator {

		private FMChannelType type;
		private List<FMChannel> channels;
		private int position;

		public ChannelIteratorImpl(FMChannelType type, List<FMChannel> channels) {
			this.type = type;
			this.channels = channels;
		}

		@Override
		public boolean hasNext() {
			while (position < channels.size()) {
				FMChannel c = channels.get(position);
				if (c.getTYPE().equals(type) || type.equals(FMChannelType.ALL)) {
					return true;
				} else
					position++;
			}
			return false;
		}

		@Override
		public FMChannel next() {
			FMChannel c = channels.get(position);
			position++;
			return c;
		}

	}
}

public class IteratorPattern {
	public static void main(String[] args) {
		ChannelCollection channels = populateChannels();
		ChannelIterator baseIterator = channels.iterator(FMChannelType.ALL);
		
		while (baseIterator.hasNext()) {
			FMChannel c = baseIterator.next();
			System.out.println(c.toString());
		}
		System.out.println("****************************************************");
		
		// Channel Type Iterator
		ChannelIterator englishIterator = channels.iterator(FMChannelType.ENGLISH);
		while (englishIterator.hasNext()) {
			FMChannel c = englishIterator.next();
			System.out.println(c.toString());
		}
	}

	private static ChannelCollection populateChannels() {
		ChannelCollection channels = new ChannelCollectionImpl();
		channels.addChannel(new FMChannel(98.5, FMChannelType.ENGLISH));
		channels.addChannel(new FMChannel(99.5, FMChannelType.HINDI));
		channels.addChannel(new FMChannel(100.5, FMChannelType.FRENCH));
		channels.addChannel(new FMChannel(101.5, FMChannelType.ENGLISH));
		channels.addChannel(new FMChannel(102.5, FMChannelType.HINDI));
		channels.addChannel(new FMChannel(103.5, FMChannelType.FRENCH));
		channels.addChannel(new FMChannel(104.5, FMChannelType.ENGLISH));
		channels.addChannel(new FMChannel(105.5, FMChannelType.HINDI));
		channels.addChannel(new FMChannel(106.5, FMChannelType.FRENCH));
		return channels;
	}


}
