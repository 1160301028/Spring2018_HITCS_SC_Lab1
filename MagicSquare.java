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
			File file = new File(fileName);//���File����
			if(file.isFile() && file.exists())//�ж��ļ��Ƿ����
			{
				//File����->FileInputStream����->InputStreamReader����
				InputStreamReader read = new InputStreamReader(new FileInputStream(file));
				//ͨ��InputStreamReader������BufferedReader����
				//@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(read);
				//ͨ��BufferedReader�����ļ��������ַ�����ʽ����
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
					//���ַ�������ֽ�ɵ����ַ�����
					String[] line = new String[150]; 
					line = lineText.split("\t");
					
					int n = line.length;
					column = n;
					
					//���ַ�����ת��Ϊ��������
					int[] intarray = new int[n];
					for(int i=0; i<n; i++)
					{
						intarray[i] = Integer.valueOf(line[i]);
					}
					
					//������ʾ�÷������ζ�ά����
					for(int j=0; j<n; j++)
					{
						array[row][j] = intarray[j];
						//System.out.println(array[row][j]+"\t");
					}
					
					row++;
				}
		
				//����
				if(row != column)
				{
					return false;
				}
				
				//���ÿ��Ԫ���Ƿ����Ҫ����������
				for(int i =0;i < column; i++)
				{
					for(int j =0; j < column;j++)
					{
						//�ų�����Ԫ��
						if(array[i][j] < 0)
							return false;
					}
				}
				
				//����Ƚϱ�׼ֵ
				int num = 0,temp = 0;
				for(int i = 0;i < column;i++)
				{
					num = num+array[0][i];
				}
				
				//�Ƚ�ÿ�еĺ��Ƿ����
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
				
				//�Ƚ�ÿ�еĺ��Ƿ����
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
				
				//�Ƚ����Խ��ߵĺ��Ƿ����
				for(int i = 0; i< column; i++)
				{
					temp = temp + array[i][i];
				}
				if(temp != num)
					return false;
				temp = 0;
				
				//�Ƚϸ��Խ��ߵĺ��Ƿ����
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
		System.out.println(isLegalMagicSquare("F:"+"\\"+"yumuxiao"+"\\"+"majority"+"\\"+"�������"+"\\"+"experiment"+"\\"+"MagicSquare"+"\\"+"bin"+"\\"+"1.txt"));
		System.out.println(isLegalMagicSquare("F:"+"\\"+"yumuxiao"+"\\"+"majority"+"\\"+"�������"+"\\"+"experiment"+"\\"+"MagicSquare"+"\\"+"bin"+"\\"+"2.txt"));
		System.out.println(isLegalMagicSquare("F:"+"\\"+"yumuxiao"+"\\"+"majority"+"\\"+"�������"+"\\"+"experiment"+"\\"+"MagicSquare"+"\\"+"bin"+"\\"+"3.txt"));
		System.out.println(isLegalMagicSquare("F:"+"\\"+"yumuxiao"+"\\"+"majority"+"\\"+"�������"+"\\"+"experiment"+"\\"+"MagicSquare"+"\\"+"bin"+"\\"+"4.txt"));
		System.out.println(isLegalMagicSquare("F:"+"\\"+"yumuxiao"+"\\"+"majority"+"\\"+"�������"+"\\"+"experiment"+"\\"+"MagicSquare"+"\\"+"bin"+"\\"+"5.txt"));
	}
	
	

}
