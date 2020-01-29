import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;
public class imgrecv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch=' ';
		int p=0,a=0,r=0,g=0,b=0,k=0;
		Scanner sc=new Scanner (System.in);
		//System.out.println("Enter the length of the message");
		int l=10000;
		int count=0;
		BufferedImage img=null;
		try
		{
			img=ImageIO.read(new File("b.png"));
			//get image width and height 
			int width = img.getWidth(); 
			int height = img.getHeight();
			for (int i = 0; i < width && count < l; i++) {
				for (int j = 0; j < height && count < l; j++) {
					//System.out.println(0);
					p=img.getRGB(i,j);
					String str="";
					String t="";
					int len=0;
					// get alpha 
					a = (p>>24) & 0xff;
					t=Integer.toBinaryString(a);
					len=t.length();
					str=t.charAt(len-2)+""+t.charAt(len-1)+str;
					//a=a&1;

					// get red 
					r = (p>>16) & 0xff;
					t=Integer.toBinaryString(r);
					len=t.length();
					str=t.charAt(len-2)+""+t.charAt(len-1)+str;
					//System.out.println(t);
					// get green 
					g = (p>>8) & 0xff; 
					t=Integer.toBinaryString(g);
					len=t.length();
					str=t.charAt(len-2)+""+t.charAt(len-1)+str;
					//System.out.println(t);

					// get blue 
					b = p & 0xff;
					t=Integer.toBinaryString(b);
					len=t.length();
					str=t.charAt(len-2)+""+t.charAt(len-1)+str;
					//System.out.println(t);
					k=Integer.parseInt(str,2);
					if (i==0 && j==0)
					{
						//System.out.println(k);
						l=k;
					}
					else
					{
						System.out.print((char)k);
						count++;
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
