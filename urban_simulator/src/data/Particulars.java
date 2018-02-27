/**
 * 
 */
package data;

/**
 * @author andro
 *
 */
public class Particulars {
	private int X;
	private int Y;
	
	public Particulars (int X, int Y) {
		this.X = X;
		this.Y = Y;
	}
	public int getX () {
		return X;
	}
	public int getY () {
		return Y;
	}
	public void setX (int X1){
		this.X = X1;
	}
	public void setY (int Y1){
		this.Y =  Y1;
	}
}
