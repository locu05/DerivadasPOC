package derivadas;

import java.math.*;

public class Redondear {
	public double redondeo(double resultado, int redondeo){
        BigDecimal bd = new BigDecimal
        (Double.toString(resultado)).setScale(redondeo,BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
	
//	public Integer redondeo(double resultado ,int redondeo){
//        return Integer.valueOf(Double.toString(resultado).split("\\.")[0]);
//    }
}