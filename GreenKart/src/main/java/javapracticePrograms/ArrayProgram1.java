package javapracticePrograms;

public class ArrayProgram1 {
	
	public static void main(String[] args) {
		
	
	int Array1[]= {1,0,1,0,0,1,2,3,4,0,1,2,1};
	int n=Array1.length;
	int Array2[] = new int[n-1];
	
	int k=0;
	for(int i=0;i<Array1.length; i++) {
		if(Array1[i]==0) {
			Array2[0]=Array1[i];
		}else if(Array1[i]==1)
	Array2[n-1]=Array1[i];
		else
			Array2[k++]=Array1[i];
	}
	for(int j=0;j<Array2.length;j++) {
		System.out.println(Array2[j]);
	}

}}
