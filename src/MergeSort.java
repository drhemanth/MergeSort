/**
 * Created by hemanth on 14/03/2016.
 */
public class MergeSort extends Thread{
    private static int []a;
    private static int []b;
    // sorting the function here
    public static int[] sort(int [] a){
        int []tempArray = new int[a.length];
        mergeSort(tempArray,0,a.length-1,a);
        return tempArray;
    }
    // merge the sorted function
    public static void mergeSort(int []tempArray,int lowerIndex, int upperIndex,int [] a){
        if(lowerIndex == upperIndex){
            return;
        }else{
            int mid = (lowerIndex+upperIndex)/2;
            mergeSort(tempArray, lowerIndex, mid,a);
            mergeSort(tempArray, mid+1, upperIndex,a);
            merge(tempArray,lowerIndex,mid+1,upperIndex,a);
        }
    }

    public static void merge(int []tempArray,int lowerIndexCursor,int higerIndex,int upperIndex, int[] a){
        int tempIndex=0;
        int lowerIndex = lowerIndexCursor;
        int midIndex = higerIndex-1;
        int totalItems = upperIndex-lowerIndex+1;
        while(lowerIndex <= midIndex && higerIndex <= upperIndex){
            if(a[lowerIndex] < a[higerIndex]){
                tempArray[tempIndex++] = a[lowerIndex++];
            }else{
                tempArray[tempIndex++] = a[higerIndex++];
            }
        }

        while(lowerIndex <= midIndex){
            tempArray[tempIndex++] = a[lowerIndex++];
        }

        while(higerIndex <= upperIndex){
            tempArray[tempIndex++] = a[higerIndex++];
        }

        for(int i=0;i<totalItems;i++){
            a[lowerIndexCursor+i] = tempArray[i];
        }
    }
    // Printing the array
    public static void printArray(int []array){
        for(int i : array){
            System.out.print(i+" ");
        }
    }
    // geneating the array
    public static int[] getArray(){
        int size=10;
        int []array = new int[size];
        int item = 0;
        for(int i=0;i<size;i++){
            item = (int)(Math.random()*100);
            array[i] = item;
        }
        return array;
    }
    public void run() {
        System.out.print("Printing the input");
        a = getArray();
        printArray(a);
        System.out.print("Printing the output");
        b= sort(a);
        System.out.println();
        printArray(b);

    }

}