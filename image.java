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
		int count=0;
		char ch=' ';
		int p=0,a=0,r=0,g=0,b=0,k=0;
		try
		{
			BufferedImage img=null;

			img=ImageIO.read(new File("C:\\Users\\Anurag\\Desktop\\image\\y.jpg"));
			

			for (int i = 0; i < 5184; i++) {
				for (int j = 0; j < 3456; j++) {

					p=img.getRGB(i,j);
					if (count<str.length()) {
						ch=str.charAt(count);
						System.out.println(ch);
						count++;

						// get alpha 
						k=ch & (0x3);
						a = (p>>24) & 0xff;
						//System.out.println(a);
						a=a&(0xfc);
						a=a|k;
						System.out.println(a);
						// get red 
						k= ch & (0xc);
						r = (p>>16) & 0xff; 
						r=r&(0xfc);
						r=r|k;

						// get green 
						k= ch &(0x30);
						g = (p>>8) & 0xff; 
						g=g&(0xfc);
						g=g|k;

						// get blue 
						k=ch &(0xc0);
						b = p & 0xff;
						b=b&(0xfc);
						b=b|k;

						p = (a<<24) | (r<<16) | (g<<8) | b; 
					}
					else
					{
						// get alpha 
						a = (p>>24) & 0xff;

						// get red 
						r = (p>>16) & 0xff; 
						// get green 
						g = (p>>8) & 0xff; 

						// get blue 
						b = p & 0xff;
						
						p = (a<<24) | (r<<16) | (g<<8) | b;
					}
					img.setRGB(i, j, p); 
				}
			} 
			File outputfile = new File("C:\\Users\\Anurag\\Desktop\\image\\b.jpg");
			ImageIO.write(img, "jpg", outputfile);
		}
		catch (Exception e)
		{
			//System.out.println(e);
		}

		System.out.println("END of programme");
	}
}
