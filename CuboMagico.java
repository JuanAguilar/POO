package Reader;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CuboMagico {
  
	public static int[][] leerArchivo(String ruta,int ik,int j)
	{
		int[][] mat=new int[ik][j];
		int conti=0;
		FileReader fr;
		try {
			//Lectura de el fichero de acuerdo a la ruta asiganda
				fr = new FileReader(ruta);
				BufferedReader br = new BufferedReader(fr);
				String line = null;
			//Conversion de valores cadena a entero y asigancion en la matriz
			while ((line = br.readLine()) != null && conti<=ik) 
		    {
				for(int i=0;i<(line.split("\t").length);i++)
				{
					  mat[conti][i]=Integer.valueOf(line.split("\t")[i]);
				}
					conti++;
			}		
			br.close();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	  return mat;
	}
	
	public static void calcularCubo(int [][] mat,int posi,int posj)
	{
		//Suma de numeros pertenecientes a cada fila de la matriz
		for(int i=0;i<posi ;i++)
		{
			int sumaFil=0;
			for(int j=0;j<posj;j++)
			{
				sumaFil+=mat[i][j];
				System.out.print(mat[i][j]+" ");
			}
			System.out.println("="+sumaFil);
		}
		//Suma de numeros pertenecientes a cada columna de la matriz
		for(int i=0;i<posi ;i++)
		{
			int sumaCol=0;
			for(int j=0;j<posj;j++)
			{
				sumaCol+=mat[j][i];
			}
			System.out.println("Columna "+(i+1)+" = "+sumaCol);
		}
		//Suma de numeros que estan en la diagonal primaria
		int sumaDiagPrin=0;
		for(int i=0;i<posi ;i++)
		{		
			sumaDiagPrin+=mat[i][i];
		}
		System.out.println("Suma de numeros de la diagonal principal= "+sumaDiagPrin);
		//Suma de numeros que estan en la diagonal secundaria
		int sumaDiagSec=0,cont=0;
		for(int i=(posi-1);i>=0;i--)
		{	
			sumaDiagSec+=mat[i][cont];
			cont++;
		}
		System.out.println("Suma de numeros de la diagonal secundaria= "+sumaDiagSec);
	}
	public static void main(String []args)
	{
		int [][] luna=new int [9][9];
		luna=leerArchivo("C:/Users/USUARIO/Documents/U Catolica talleres/POO/Taller1/src/Luna.txt",9,9);
		int [][] mercurio=new int [9][9];
		mercurio=leerArchivo("C:/Users/USUARIO/Documents/U Catolica talleres/POO/Taller1/src/Mercury.txt",8,8);
		
        System.out.println("---CUBO MAGICO DE LUNA---");
		calcularCubo(luna,9,9);
		System.out.println();
        System.out.println("---CUBO MAGICO DE MERCURIO---");
		calcularCubo(mercurio,8,8);
	}
}
