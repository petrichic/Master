import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class  Flower implements Comparable<Object>{
    double price; //цена за цветок
    String name;  //название цветка
	String color; //цвет
    int fresh;//свежесть
	int lenghtstalk;//длина стебля
    static double total;

	double GetPrice(){
    return price;
    }

	double GetTotal(){
    return total;
    }

	public int compareTo(Object obj) {
		Flower tmp = (Rouse)obj;
	       if(this.fresh < tmp.fresh)
	       {
	         return -1;
	       }   
	       else if(this.fresh > tmp.fresh)
	       {
	         return 1;
	       }
	       return 0;  
	}
}
class Rouse extends Flower{
     Rouse(double price, String name, String color, int fresh, int lenghtstalk){
        this.price = price;
        this.name = name;
        this.color = color;
        this.fresh = fresh;
        this.lenghtstalk = lenghtstalk;
        total += price;
    }
}

class Violet extends Flower{
     Violet(double price, String name, String color, int fresh, int lenghtstalk){
        this.price = price;
        this.name = name;
        this.color = color;
        this.fresh = fresh;
        this.lenghtstalk = lenghtstalk;
        total += price;        
    }
}
class Tulip extends Flower{
    Tulip(double price, String name, String color, int fresh, int lenghtstalk){
        this.price = price;
        this.name = name;
        this.color = color;
        this.fresh = fresh;
        this.lenghtstalk = lenghtstalk;
        total += price;
    }
}

public class Blabal {
	private static final double packet = 7.5;
    private static final double band = 9.8;
	public static void main(String[] args) throws IOException, Exception{
		Flower[] flowers = new Flower[5];
		flowers [0] = new Rouse(36.5, "Rouse", "Red", 1, 26);
		flowers [1] = new Rouse(25, "Tulip", "Green", 4, 30);
		flowers [2] = new Rouse(55.56, "Violet", "Yellow", 2, 40);
		flowers [3] = new Rouse(40, "Rouse", "Black", 5, 50);
		flowers [4] = new Rouse(30, "Tulip", "Yellow", 3, 45);
	    Arrays.sort(flowers);
		Flower.total+= band+packet;
		stalk(flowers);
	    System.out.println(Flower.total);
	    for(int i = 0; i < flowers.length; i++)
	    {
	      System.out.println(flowers[i].price + flowers[i].name + flowers[i].color 
	    		  + flowers[i].fresh 
	    		  + flowers[i].lenghtstalk);
	    }
    }
public static void stalk (Flower[] flowers) throws Exception, IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input first value");
		int first = Integer.parseInt(reader.readLine());
		System.out.println("Input second value");
		int second = Integer.parseInt(reader.readLine());
		if (second < first || second==first)
			System.out.println("Input correct values");
		else
		{
		for (int i=0;i<flowers.length;i++){
			int l= flowers[i].lenghtstalk;
			 if (l>=first && l<=second)
				System.out.println(flowers[i].price + flowers[i].name + flowers[i].color 
			    		  + flowers[i].fresh 
			    		  + flowers[i].lenghtstalk);
		}
		}
	}
}