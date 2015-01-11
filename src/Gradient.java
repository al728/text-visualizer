import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

public class Gradient {
	
	//Specify File path in which to read from
	private static String fileName = "/Users/allenlee/Desktop/poem";	
	
	public static void main(String[] args) throws Exception {
		FileReader file = new FileReader(fileName);
		BufferedReader reader = new BufferedReader(file); 
		String poem = "";
		ArrayList<String> poem_as_list = new ArrayList<String>();
		String line = reader.readLine();
		while (line !=null){
			//poem = poem + line + " ; ";
			poem_as_list.add(line);
			line = reader.readLine();
		}
		
		ArrayList<ColorPoint> colorPoints = new ArrayList<ColorPoint>();
		colorPoints = parse_poem(poem_as_list);
		
		ArrayList<ColorPoint> randomcolorPoints = new ArrayList<ColorPoint>();
		randomcolorPoints = random_parse_poem(poem_as_list);
		
		JFrame window = new JFrame("Poems to Art");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 700, 700);
		MyCanvas canvas = new MyCanvas(poem,colorPoints);
		window.getContentPane().add(canvas);
		window.setVisible(true);
	}


public static ArrayList<String> string_to_words(String a){
	ArrayList<String> wordStore = new ArrayList<String>(); 
	String temp = ""; 
	for(int i = 0; i<a.length(); i++){
		if(a.charAt(i)==' '){
			wordStore.add(temp);
			temp = ""; 
		}else{
			temp = temp + a.charAt(i); 
		}
	}
	return wordStore;
}

public static ArrayList<ColorPoint> parse_poem(ArrayList <String> poem_as_list) {
	ArrayList<ColorPoint> list  = new ArrayList<ColorPoint>(); 
	int tRow = poem_as_list.size();
	int column = 0;
	int counter = 0;	
	Hashtable<String,Color> colorMap = new Hashtable<String,Color>();
	colorMap.put("red",new Color(255,0,0));
	colorMap.put("blue",new Color(0,0,255));
	colorMap.put("green",new Color(0,255,0));
	colorMap.put("white",new Color(255,255,255));
	colorMap.put("black",new Color(0,0,0));
	colorMap.put("navy",new Color(0,0,128));
	colorMap.put("teal",new Color(0,128,128));
	colorMap.put("gray",new Color(128,128,128));
	colorMap.put("grey",new Color(128,128,128));
	colorMap.put("maroon",new Color(128,0,0));
	colorMap.put("turquoise",new Color(64,224,208));
	colorMap.put("purple",new Color(128,0,128));
	colorMap.put("pink",new Color(255,105,180));
	colorMap.put("brown",new Color(139,69,19));
	colorMap.put("orange",new Color(255,140,0));
	colorMap.put("yellow",new Color(255,255,0));
	colorMap.put("gold",new Color(255,215,0));
	colorMap.put("silver",new Color(192,192,192));
	colorMap.put("beige",new Color(245,245,220));
	colorMap.put("chocolate",new Color(210,105,30));

	for (int line=0; line<poem_as_list.size(); line++)
	{
		String[] words = poem_as_list.get(line).split(" ");
		for (int i=0; i<words.length; i++)
		{
			if(colorMap.keySet().contains(words[i]))
			{
				ColorPoint newC = new ColorPoint(colorMap.get(words[i]), (int)((i+1)*700/(words.length+1)), (int)(line+1)*700/(tRow+1));
				list.add(newC);
			}
		}
	}

	return list;
}

public static ArrayList<ColorPoint> random_parse_poem(ArrayList <String> poem_as_list) {
	ArrayList<ColorPoint> list  = new ArrayList<ColorPoint>(); 
	int tRow = poem_as_list.size();
	int column = 0;
	int counter = 0;	
	Hashtable<String,Color> colorMap = new Hashtable<String,Color>();
	colorMap.put("red",new Color(255,0,0));
	colorMap.put("blue",new Color(0,0,255));
	colorMap.put("green",new Color(0,255,0));
	colorMap.put("white",new Color(255,255,255));
	colorMap.put("black",new Color(0,0,0));
	colorMap.put("navy",new Color(0,0,128));
	colorMap.put("teal",new Color(0,128,128));
	colorMap.put("gray",new Color(128,128,128));
	colorMap.put("grey",new Color(128,128,128));
	colorMap.put("maroon",new Color(128,0,0));
	colorMap.put("turquoise",new Color(64,224,208));
	colorMap.put("purple",new Color(128,0,128));
	colorMap.put("pink",new Color(255,105,180));
	colorMap.put("brown",new Color(139,69,19));
	colorMap.put("orange",new Color(255,140,0));
	colorMap.put("yellow",new Color(255,255,0));
	colorMap.put("gold",new Color(255,215,0));
	colorMap.put("silver",new Color(192,192,192));
	colorMap.put("beige",new Color(245,245,220));
	colorMap.put("chocolate",new Color(210,105,30));

	for (int line=0; line<poem_as_list.size(); line++)
	{
		String[] words = poem_as_list.get(line).split(" ");
		for (int i=0; i<words.length; i++)
		{
			if(colorMap.keySet().contains(words[i]))
			{
				ColorPoint newC = new ColorPoint(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)), (int)((i+1)*700/(words.length+1)), (int)(line+1)*700/(tRow+1));
				list.add(newC);
			}
		}
	}

	return list;
}
public static final Random random = new Random();

	public static double getdist(int i, int j) {
		return (Math.sqrt((i*i)+(j*j)));
	}
}

