package application;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ThreadToPNG {
	private String url;
	private String directory;
	private ArrayList<String> page = new ArrayList<String>();
	
	public ThreadToPNG(String url, String directory) throws IOException {
		this.url = url;
		this.directory = directory;
		System.out.println(this.url + " " + this.directory);
		
		try {
			fetchThread();
			System.out.println(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fetchThread() throws Exception {
		if(url.charAt(4) == 's')
			url = url.substring(0,4) + url.substring(5, url.length()-1);
		System.out.println(url);
		URL picchan = new URL(url);
		HttpURLConnection yc = (HttpURLConnection) picchan.openConnection();
		yc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
		BufferedReader in = new BufferedReader(
				new InputStreamReader(yc.getInputStream()));
		
		String inputLine;
		while((inputLine = in.readLine()) != null)
			page.add(inputLine);
		in.close();
	}
}
