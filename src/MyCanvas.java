import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

class MyCanvas extends JComponent {
	String poem;
	ArrayList<ColorPoint> colorPoints;
	Hashtable<String,Color> colorMap;

	public static final Random random = new Random();
	
	public Color randomColor() {
		return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
	}

	public MyCanvas(String poem, ArrayList<ColorPoint> colorPoints){
		super();
		
		this.poem = poem;
		//String[] lines = poem.split(System.getProperty("line.separator"));
		this.colorPoints = colorPoints;

	}
	public void paint(Graphics g) {
		for (int x=0; x<701; x++){
			for (int y=0; y<701; y++){
				g.setColor(getweightedcolor(x,y,colorPoints));
				g.drawLine(x, y, x, y);
			}
		}
	}

	public static double getdist(int i, int j) {
		return 1/(Math.sqrt((i*i)+(j*j)));
	}
	
	public static Color getweightedcolor(int x, int y, ArrayList<ColorPoint> colorPoints){
		double weights[] = new double [colorPoints.size()];
		double rsum = 0;
		double gsum = 0;
		double bsum = 0;
		double totalweight = 0;
		ColorPoint t;
		for(int i=0; i<colorPoints.size(); i++){
			t=colorPoints.get(i);
			weights[i] = getdist(Math.abs(x-t.getX()), Math.abs(y-t.getY()));
			totalweight = weights[i] + totalweight;
		}
		for (int j=0; j<weights.length; j++)
		{
			weights[j] = weights[j] / totalweight;
		}
			
		for(int k=0; k<colorPoints.size(); k++){
			t = colorPoints.get(k);
			rsum = weights[k]*t.getColor().getRed() + rsum;
			gsum = weights[k]*t.getColor().getGreen() + gsum;
			bsum = weights[k]*t.getColor().getBlue()+ bsum;
		}
		
		for(ColorPoint z:colorPoints){
			if(x==z.getX() && y==z.getY()){
				rsum = z.getColor().getRed();
				gsum = z.getColor().getGreen();
				bsum = z.getColor().getBlue();
			}
		}
		return new Color((int)rsum,(int)gsum,(int)bsum);
	}
}
