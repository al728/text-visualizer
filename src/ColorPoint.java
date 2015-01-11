import java.awt.Color;

class ColorPoint{
	public Color color;
	public int x;
	public int y;

	public ColorPoint(Color color, int x, int y)
	{
		this.color = color;
		this.x = x;
		this.y = y;
	}
	public Color getColor(){
		return this.color;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
}