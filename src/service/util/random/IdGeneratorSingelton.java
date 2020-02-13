package service.util.random;

//pogledati
public class IdGeneratorSingelton {
	

	
	int[] id = new int[24];
	
	public  int[] getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private static IdGeneratorSingelton instance;
	
	private IdGeneratorSingelton() {
	}
	
	public int[] uniqueRandom (int size) {
	    int[] a = new int[size];
	    for (int i = 0; i < size; i++) {
	        a[i] = (int)(Math.random()*24);

	        for (int j = 0; j < i; j++) {
	            if (a[i] == a[j]) {
	                i--; 
	                break;
	            }
	        }  
	    }
	    return a;
	}


	public static IdGeneratorSingelton getInstance() {
		if(instance == null) {
			instance = new IdGeneratorSingelton();
		}
		return instance;
	}
	
}
