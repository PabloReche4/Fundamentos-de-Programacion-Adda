package ejerciciostransformaciones;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjercicioTransformaciones {
	public static void main(String[]args) {
	System.out.println(recursivaNoFinal(65, 25, "Hola", "Adios"));
	System.out.println(funcional(355, 56, "als"));
	}
//si a<2 o b<3 -->a*2+b*3+d.length
//si b>=3 --> a*b +recursivo(b, a/2, "("+c+")",d+"2")
//else -->a+f(a,b/2,c , "["+d+"]"
	public static Integer recursivaNoFinal(Integer a, Integer b, String c, String d) {
		Integer res=null;
		if(a<2||b<3) {
			res=a*2+b*3+d.length();
		}else if(b>=3) {
			res=a*b + recursivaNoFinal(b, a/2, "("+c+")", d+"2");
		}else {
			res=a+recursivaNoFinal(a, b/2, c,"["+ d+"]");
		}
		return res;
	}
	public static int recursivaFinal(int a, int b, String c, String d) {
		return recursivaFinal(0, a, b, c, d);
	}
	private static Integer recursivaFinal(int acum, int a, int b, String c, String d) {
		
		if(a<2||b<3) {
			 acum+=a*2+b*3+d.length();
		}else if(b>=3) {
			acum+=recursivaFinal(acum+a*b, b, a/2, "("+c+")", d+"2");
		}else {
			acum+=recursivaFinal(acum+a, a, b/2, c, "["+d+"]");
		}
		return acum;
	}
	public static 	Integer iterativa(int a, int b, String c,String d) {
		int res=0;
		while(!(a<2||b<3)) {
			if(b>=3) {
				res+=a*b;
				int tempA=a;
				b=tempA/2;
				c="("+c+")";
				d=d+"2";
			}else {
				res+=a;
				b=b/2;
				d="["+d+"]";
						
			}
			
		}
		res+=a*2+b*3+d.length();
		return res;
	}
//public record Tupla(int a, int b, String c, String d) {
//	public static Tupla of(int a, int b, String c, String d, int res) {
//		return new Tupla(a, b, c, d, res);
//	}
//	public Tupla next() {
//		
//	}
//}//TODO
	public static Map<Integer, Long>funcional(Integer a, Integer b, String c){
		return Stream.iterate(2*b, e->e<a*c.length(),e->e+b)
				.map(e->c+"-"+e)
				.collect(Collectors.groupingBy(s->s.length(),Collectors.counting()));
	}
	//TRANSFORMAR A IMPERATIVO USANDO WHILE
	public static Map<Integer, Long>funcionaImp(Integer a, Integer b, String c){
		Map<Integer, Long>res=new HashMap<>();
		Integer e=2*b;
		while(!(e<a*c.length())) {
			if(e%10!=0) {
				String s=c+"-"+e;
				if(res.containsKey(s.length())) {
					res.put(s.length(), res.get(s.length())+1);
				}else {
					res.put(s.length(), 1L);
				}
			}
			e=e+b;
		}
		return res;
	}
	public static Map<Integer, Long>recursivaFinal2(Integer a, Integer b, String c){
		return recursivaFina2(2*b,a,b,c, new HashMap<>());
	}
	private static Map<Integer, Long> recursivaFina2(Integer e, Integer a, Integer b, String c, Map<Integer, Long>res) {
		
		if(e<a*c.length()) {
		 if(e%10!=0) {
			String s=c+"-"+e;
			if(res.containsKey(s.length())) {
				res.put(s.length(), res.get(s.length())+1);
			}else {
				res.put(s.length(), 1L);
			}
			
		}
		 res=recursivaFina2(e+b, a, b, c, res);
		
	}
		return res;
}
}
