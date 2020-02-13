package service.util.random;



public  class Random10 {


public static int[] uniqueRandom (int size) {

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
}