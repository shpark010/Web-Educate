import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		boolean changed = false;
		for (int i=0; i< N-1; i++) {
		    changed = false;
		    for (int j=0; j<=i; j++) {
		        if (A[j] > A[j+1]) {
		            changed = true;
		            int num = A[j];
		            A[j] = A[j+1];
		            A[j+1] = num;
		        }
		    }
		    if (changed == false) {
		        System.out.println(A[i+1]);
		        break;
		    }
		}

	}

}
