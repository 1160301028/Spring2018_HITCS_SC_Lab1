import java.io.*;
import java.io.File;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;

public class MagicSquare {
	public static boolean isLegalMagicSquare(String fileName)
	{
		try
		{
			File file = new File(fileName);//获得File对象
			if(file.isFile() && file.exists())//判断文件是否存在
			{
				//File对象->FileInputStream对象->InputStreamReader对象
				InputStreamReader read = new InputStreamReader(new FileInputStream(file));
				//通过InputStreamReader对象获得BufferedReader对象
				//@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(read);
				//通过BufferedReader对象将文件内容以字符串形式读出
				String lineText = null;
				
				int row = 0, column = 0;
				int[][] array = new int[150][150];
				for(int i =0;i<150;i++)
				{
					for(int j =0;j < 150; j++)
					{
						array[i][j] = 0;
					}
				}
				
				while((lineText = br.readLine()) != null)
				{
					//将字符串数组分解成单个字符数组
					String[] line = new String[150]; 
					line = lineText.split("\t");
					
					int n = line.length;
					column = n;
					
					//将字符数组转化为整形数组
					int[] intarray = new int[n];
					for(int i=0; i<n; i++)
					{
						intarray[i] = Integer.valueOf(line[i]);
					}
					
					//建立表示幻方的整形二维数组
					for(int j=0; j<n; j++)
					{
						array[row][j] = intarray[j];
						//System.out.println(array[row][j]+"\t");
					}
					
					row++;
				}
		
				//检验
				if(row != column)
				{
					return false;
				}
				
				//检测每个元素是否符合要求（正整数）
				for(int i =0;i < column; i++)
				{
					for(int j =0; j < column;j++)
					{
						//排除负数元素
						if(array[i][j] < 0)
							return false;
					}
				}
				
				//计算比较标准值
				int num = 0,temp = 0;
				for(int i = 0;i < column;i++)
				{
					num = num+array[0][i];
				}
				
				//比较每行的和是否相等
				for(int i = 1;i < column;i++)
				{
					for(int j = 0; j < column; j++)
					{
						temp = temp + array[i][j];
					}
					
					if(temp != num)
					{
						return false;
					}
					
					temp = 0;
				}
				
				//比较每列的和是否相等
				for(int i = 0; i < column; i++)
				{
					for(int j = 0; j < column; j++)
					{
						temp = temp + array[j][i];
					}
					
					if(temp != num)
					{
						return false;
					}
					
					temp = 0;
				}
				
				//比较主对角线的和是否相等
				for(int i = 0; i< column; i++)
				{
					temp = temp + array[i][i];
				}
				if(temp != num)
					return false;
				temp = 0;
				
				//比较副对角线的和是否相等
				for(int i = 0; i < column;i++)
				{
					temp = temp + array[i][column-1-i];
				}
				if(temp != num)
					return false;
				temp = 0;
				
				br.close();
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
			return false;
		}catch(NumberFormatException e){
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	static public void main(String[] args)
	{
		System.out.println(isLegalMagicSquare("F:"+"\\"+"yumuxiao"+"\\"+"majority"+"\\"+"软件构造"+"\\"+"experiment"+"\\"+"MagicSquare"+"\\"+"bin"+"\\"+"1.txt"));
		System.out.println(isLegalMagicSquare("F:"+"\\"+"yumuxiao"+"\\"+"majority"+"\\"+"软件构造"+"\\"+"experiment"+"\\"+"MagicSquare"+"\\"+"bin"+"\\"+"2.txt"));
		System.out.println(isLegalMagicSquare("F:"+"\\"+"yumuxiao"+"\\"+"majority"+"\\"+"软件构造"+"\\"+"experiment"+"\\"+"MagicSquare"+"\\"+"bin"+"\\"+"3.txt"));
		System.out.println(isLegalMagicSquare("F:"+"\\"+"yumuxiao"+"\\"+"majority"+"\\"+"软件构造"+"\\"+"experiment"+"\\"+"MagicSquare"+"\\"+"bin"+"\\"+"4.txt"));
		System.out.println(isLegalMagicSquare("F:"+"\\"+"yumuxiao"+"\\"+"majority"+"\\"+"软件构造"+"\\"+"experiment"+"\\"+"MagicSquare"+"\\"+"bin"+"\\"+"5.txt"));
	}
	
	

}
