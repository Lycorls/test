package test.copyOnWriteArrayList;

import java.util.List;

public class ReadThread implements Runnable {

	private List<Integer> list;

    public ReadThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (Integer ele : list) {
            System.out.println("ReadThread:"+ele);
        }
    }

}
