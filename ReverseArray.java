public class ReverseArray {
    public static void main(String [] args){
        int [] a={1,2,3,4,5};
        int [] b= reverseArray(a);
        
        for(int i=0; i<b.length;i++){
            System.out.print(" "+b[i]+" "); 
        }
        System.out.println();

    }
    static int [] reverseArray(int [] arr){
        int S = arr.length;

        for(int i=0;i < S/2;i++){
            int temp= arr[i];
            arr[i]=arr[S-i-1];
            arr[S-i-1]=temp;
        }
        return arr;
    }
}
