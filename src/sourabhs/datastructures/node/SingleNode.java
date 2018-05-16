package sourabhs.datastructures.node;


public class SingleNode<T> implements Comparable<T> {
    
    private T value;
    private SingleNode<T> nextNode;
    
    public SingleNode() {
    	super();
    	nextNode = null;
    }
    
    public SingleNode(T val) {
    	this();
    	this.value = val;
    }
     
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public SingleNode<T> getNextNode() {
        return nextNode;
    }
    public void setNextNode(SingleNode<T> ref) {
        this.nextNode = ref;
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