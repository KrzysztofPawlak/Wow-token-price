package paka;

import paka.myFrame;

import java.awt.Frame;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class test extends TimerTask {

	private int buy, min24, max24;
	long date;
	String sURL = "https://wowtoken.info/snapshot.json"; // String
	URL url;
	JsonObject raw;
	JsonObject timestamp;
	String time;
	long dif; // difference between last update

	public int getBuy() {
		return buy;
	}

	public int getMin24() {
		return min24;
	}

	public int getMax24() {
		return max24;
	}

	public String getTime() {
		return time;
	}
	
	public long getDif() {
		return dif;
	}

	public void run() {

		try {
			// Connect to the URL using java's native library
			url = new URL(sURL);
			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			request.connect();

			// Convert to a JSON object to print data
			JsonParser jp = new JsonParser(); // from gson
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
			JsonObject rootobj = root.getAsJsonObject(); // May be an array, may
															// be an object.
			raw = rootobj.getAsJsonObject("EU").getAsJsonObject("raw");
			timestamp = rootobj.getAsJsonObject("EU");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		buy = raw.get("buy").getAsInt();
		min24 = raw.get("24min").getAsInt();
		max24 = raw.get("24max").getAsInt();
		date = timestamp.get("timestamp").getAsLong();

		Date d = new java.util.Date(date * 1000); // unix time to Date
		Date now = new Date();
		long tera = new Long(now.getTime() / 1000);
		dif = (tera - date) / 60;

		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		time = localDateFormat.format(d);
		
	}
}
