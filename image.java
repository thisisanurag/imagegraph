import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;
public class image {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a message");
		String str=sc.nextLine();
		System.out.println("Message length="+str.length());
		int count=0;
		char ch=' ';
		int p=0,a=0,r=0,g=0,b=0,k=0;
		try
		{
			BufferedImage img=null;
			img=ImageIO.read(new File("a.png"));
		    //get image width and height 
	        int width = img.getWidth(); 
	        int height = img.getHeight();
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {

					p=img.getRGB(i,j);// getting the RGB values at specified pixel
					// get alpha 
					a = (p>>24) & 0xff;

					// get red 
					r = (p>>16) & 0xff; 
					// get green 
					g = (p>>8) & 0xff; 

					// get blue 
					b = p & 0xff;
					if (count<str.length()) { // if a character exists to encode
						ch=str.charAt(count);// extracting a character
						count++;
						System.out.println(Integer.toBinaryString(ch));
						//encoding last 2 bits of character in last two bits of a
						k=ch & (0x3);
						a=a&(0xfc); 
						a=a|k;
						System.out.println(Integer.toBinaryString(a));
						//encoding next 2 bits of char in last two bits of r and so on
						k= ch & (0xc);
						r=r&(0xfc);
						k=k>>2;
						r=r|k;
						System.out.println(Integer.toBinaryString(r));
						 
						k= ch &(0x30);
						g=g&(0xfc);
						k=k>>4;
						g=g|k;
						System.out.println(Integer.toBinaryString(g));
						
						k=ch &(0xc0);
						b=b&(0xfc);
						k=k>>6;
						b=b|k;
						System.out.println(Integer.toBinaryString(b));
					}
					// if no char is there to encode then simply reform the previous p
					p = (a<<24) | (r<<16) | (g<<8) | b;
					img.setRGB(i, j, p); 
				}
			} 
			File outputfile = new File("b.png");
			ImageIO.write(img, "png", outputfile);
		}
		catch (Exception e)
		{
			//System.out.println(e);
		}

		System.out.println("END of programme");
	}
}
