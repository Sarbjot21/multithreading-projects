package com.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;	

public class Consumer implements Runnable {
	int start;
	int end;
	BufferedReader br;
	PriorityQueue<Integer> queue;
	public Consumer(int start,int end,File file) throws FileNotFoundException{
		this.start = start;
		this.end = end;
		queue = new PriorityQueue<>((x,y) -> Integer.compare(x, y));
		if(file.exists())
			br = new BufferedReader(new java.io.FileReader(file));
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String line;
		try {
			while((line = br.readLine()) != null) 
			{
				//System.out.println(Thread.currentThread().getName()+" : "+line);
				int number = Integer.parseInt(line);
				if(number >= start && number<=end)
					queue.add(number);
				if(queue.size() == (end-start + 1))
					break;
			}
			this.writeToOutputFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void writeToOutputFile() throws IOException {
		// TODO Auto-generated method stub
		File file = new File("./"+start+"-"+end+"_output.txt");
		FileWriter bos = new FileWriter(file);
		while(!queue.isEmpty()) {
			int number = queue.poll();
			System.out.println(number);
			bos.write(number);
		}
		System.out.println(bos.getEncoding());
		bos.close();
		
	}
}
