package derivadas;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		
		double[][] mat;
		mat=new double[20][3];
		
		double rangeMax1 = 50;
		double rangeMin1 = 51;
		double rangeMax2 = 70;
		double rangeMin2 = 75;
		Redondear r = new Redondear();//Objeto que alberga un valor dado de tipo double, redondeado a 2 decimales
		
		Map<Integer,Double> mapaDeValores = new HashMap<Integer,Double>();
		int i = 0;
		mapaDeValores.put(i++, 135.0);
		mapaDeValores.put(i++, 140.0);
		mapaDeValores.put(i++, 144.0);
		mapaDeValores.put(i++, 130.0);
		mapaDeValores.put(i++, 131.0);
		mapaDeValores.put(i++, 140.0);
		mapaDeValores.put(i++, 133.0);
		mapaDeValores.put(i++, 143.0);
		mapaDeValores.put(i++, 142.0);
		mapaDeValores.put(i++, 140.0);
		mapaDeValores.put(i++, 136.0);
		mapaDeValores.put(i++, 139.0);
		mapaDeValores.put(i++, 140.0);
		mapaDeValores.put(i++, 144.0);
		mapaDeValores.put(i++, 133.0);
		mapaDeValores.put(i++, 135.0);
		mapaDeValores.put(i++, 138.0);
		mapaDeValores.put(i++, 139.0);
		mapaDeValores.put(i++, 144.0);
		mapaDeValores.put(i++, 132.0);
		
		
		Derivacion2 primD = new Derivacion2();//Objeto de la clase Derivacion2 que albergara la primera derivada
		Derivacion2 segD = new Derivacion2();//Objeto de la clase Derivacion2 que albergara la segunda derivada
		
		primD.x = Double.parseDouble("1");
		primD.deltaX = Double.parseDouble("1");
		
		for(int j = 1 ; j<19 ; j++){
			//Calculo de la 1° derivada por la diferencia dividida central
			primD.centradas = (primD.funcion(r.redondeo(j+primD.deltaX,2),mapaDeValores)-primD.funcion(r.redondeo(j-primD.deltaX,2),mapaDeValores))/(2*primD.deltaX);
			//Calculo de la 2° derivada por la diferencia dividida central
			segD.centradas = (primD.funcion(r.redondeo(j+primD.deltaX,2),mapaDeValores)-2*(primD.funcion(j,mapaDeValores))+primD.funcion(r.redondeo(j-primD.deltaX,2),mapaDeValores))/(primD.deltaX*primD.deltaX);
			//Impresion de los resultados obtenidos
			System.out.println("El valor aproximado de f'(x) valuada en x="+j+" por diferencia centrada \nes "+r.redondeo(primD.centradas,6)+"\n");
			System.out.println("El valor aproximado de f''(x) valuada en x="+j+" por diferencia centrada \nes "+r.redondeo(segD.centradas,6));
			mat[j][0] = mapaDeValores.get(j);
			mat[j][1] = r.redondeo(primD.centradas,6);
			mat[j][2] = r.redondeo(segD.centradas,6);
		}
		
        for(int f=0;f<mat.length;f++) {
            for(int c=0;c<mat[f].length;c++) {
                System.out.print(mat[f][c]+" ");
            }
            System.out.println();
        }

	}
	


}
