package test;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ling.zhang on 16/4/26.
 */
public class LocalCacheQueue<T> {
    private Lock lock=new ReentrantLock();
    private int maxSize;
    private int currentSize;
    private int size;
    private LinkedList<T> requestQueue;

    public LocalCacheQueue(int size){
        this.size=size;
        this.maxSize=2*size;
        currentSize=0;
        requestQueue=new LinkedList<>();
    }

    public T pop(){
        try{
            lock.lock();
            T getOne=requestQueue.pop();
            if(getOne!=null){
                currentSize--;
            }
            return getOne;
        }catch (Exception e){
            return null;
        }finally {
            lock.unlock();
        }
    }

    public void push(T one){
        try{
            lock.lock();
            if(currentSize>size)
                ltrim();
            requestQueue.push(one);
            currentSize++;
        }catch (Exception e){
        }finally {
            lock.unlock();
        }
    }

    private void ltrim(){
        int needClearSize=currentSize-size;
        for(int i=0;i<needClearSize;i++){
            try {
                T getOne = requestQueue.removeLast();
                currentSize--;
            }catch (Exception e){

            }
        }
    }

    public static void main(String[] args) {
    	LocalCacheQueue<String> queue = new LocalCacheQueue<String>(10);
    	queue.push("123");
    	queue.push("4325");
    	new Thread("Thread1"){
    		@Override  
            public void run() {  
    			queue.push("567");
            }
    	}.start();
    	System.out.println(queue.pop());
    	System.out.println(queue.pop());
    	System.out.println(queue.pop());
	}
}
