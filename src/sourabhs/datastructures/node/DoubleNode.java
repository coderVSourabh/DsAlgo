package sourabhs.datastructures.node;

public class DoubleNode<T> implements Comparable<T> {
	
	private T value;
    private DoubleNode<T> nextNode;
    private DoubleNode<T> prvNode;
     
    public DoubleNode(T value) {
    	super();
    	this.value = value;
    	this.nextNode = null;
    	this.prvNode = null;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
	public DoubleNode<T> getNextNode() {
        return nextNode;
    }
    public void setNextNode(DoubleNode<T> ref) {
        this.nextNode = ref;
    }
    public DoubleNode<T> getPrvNode() {
		return prvNode;
	}
	public void setPrvNode(DoubleNode<T> prvNode) {
		this.prvNode = prvNode;
	}

    @Override
    public int compareTo(T arg) {
        if(arg == this.value){
            return 0;
        } else {
            return 1;
        }
    }

}
