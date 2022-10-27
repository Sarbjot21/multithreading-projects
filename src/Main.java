

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.thread.Consumer;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("./input.txt");
		Consumer consumer1 = new Consumer(1, 10, file);
		Consumer consumer2 = new Consumer(11, 20, file);
		Consumer consumer3 = new Consumer(21, 30, file);
		
		ExecutorService service = Executors.newFixedThreadPool(3);
//		se	rvice.submit(consumer1);
//		service.submit(consumer2);
//		service.submit(consumer3);
//		
		service.execute(consumer1);
		service.execute(consumer2);
		service.execute(consumer3);
	}
}

