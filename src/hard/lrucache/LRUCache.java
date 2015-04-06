package hard.lrucache;

import java.util.HashMap;
import java.util.Map;
// 考虑问题不完整，应该先给问题分类，把分类写下来，仔细考虑是否完整。
public class LRUCache {
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache(1);
    	cache.set(2,1);cache.get(2);cache.set(3,2);cache.get(2);cache.get(3);
    }
    private Map<Integer, Node> cache;
    private int capacity;
    private Node firstNode;
    private Node lastNode;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
    	Node node = cache.get(key);
    	
    	if (node != null) {
    		if (node == firstNode && node == lastNode) {
    			return node.pair.value;
    		}
    		if (node == firstNode) {
    			firstNode = firstNode.next;
    			firstNode.previous = null;
    			lastNode.next = node;
    			node.previous = lastNode;
    			lastNode = node;
    			lastNode.next = null;
    			return node.pair.value;
    		}
    		if (node == lastNode) {
    			return node.pair.value;
    		}
    		node.next.previous = node.previous;
    		node.previous.next = node.next;
    		
        	lastNode.next = node;
        	node.previous = lastNode;
        	lastNode = node;
        	// node.next = null 不能写在 lastNode.next = node; 前面，不然 当lastNode ＝＝ node的时候会无限循环。
        	node.next = null;
        	System.out.println(node.pair.value);
        	return node.pair.value;
    	}
    	System.out.println(-1);
        return -1;
    }
    
    public void set(int key, int value) {
    	Node existingNode = cache.get(key);
    	if (existingNode != null) {
    		cache.remove(key);
    		if (existingNode == firstNode && existingNode == lastNode) {
    			firstNode = null;
    			lastNode = null;
    		} else if (existingNode == firstNode && existingNode != lastNode) {
    			firstNode = firstNode.next;
    			firstNode.previous = null;
    		} else if (existingNode != firstNode && existingNode == lastNode) {
    			lastNode = lastNode.previous;
    			lastNode.next = null;
    		} else {
    			existingNode.previous.next = existingNode.next;
    			existingNode.next.previous = existingNode.previous;
    		}
    	}
    	Pair p = new Pair(key, value);
    	if (lastNode == null) {
    		lastNode = new Node(p);
    		firstNode = lastNode;
    	} else {
    		if (cache.size() >= capacity) {
    			cache.remove(firstNode.pair.key);
    			if (firstNode.next != null) {
    				firstNode = firstNode.next;
            		firstNode.previous = null;
    			}
        		
        		
        	}
    		Node node = new Node(p);
    		node.previous = lastNode;
    		lastNode.next = node;
    		lastNode = lastNode.next;
    	}
    	cache.put(key, lastNode);
    }
    
    private static class Pair {
    	Pair(int key, int value) {
    		this.key = key;
    		this.value = value;
		}
    	
    	@Override
    	public int hashCode() {
    		return key * 31 + value;
    	}
    	
    	@Override
    	public boolean equals(Object o) {
    		if (o instanceof Pair) {
    			Pair p = (Pair) o;
    			return this.key == p.key && this.value == p.value;
    		}
    		
    		return false;
    	}
    	
    	int key;
    	int value;
    }
    
    private static class Node {
    	Pair pair;
    	Node next;
    	Node previous;
    	Node(Pair pair) {
    		this.pair = pair;
    	}
    	
    	@Override
    	public String toString() {
    		String s = pair.key+" ";
    		if (this.next != null) {
    			s = s + this.next;
    		}
    		return s;
    	}
    	@Override
    	public int hashCode() {
    		return pair.hashCode();
    	}
    	
    	@Override
    	public boolean equals(Object o) {
    		if (o instanceof Node) {
    			Node n = (Node) o;
    			return this.pair.equals(n.pair);
    		}
    		
    		return false;
    	}
    }
}