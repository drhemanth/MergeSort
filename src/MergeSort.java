/**
 * Created by hemanth on 14/03/2016.
 */
public class MergeSort extends Thread{


    public static int[] mergeSort(int[] A){

        //If array completely sorted or single element then return it
        if(A.length < 2)
            return A;

        int midPoint = (int) Math.floor(A.length/2);
        int[] lArray = new int[midPoint];
        int[] rArray = new int[A.length-midPoint];

        for(int i=0; i<A.length; i++)
        {
            if(i < lArray.length)
                lArray[i] = A[i];
            else
                rArray[i-midPoint] = A[i];
        }

        int[] sortedArray = new int[A.length];

        lArray = mergeSort(lArray);
        rArray = mergeSort(rArray);

        sortedArray = merge(lArray, rArray);

        return sortedArray;

    }

    public static int[] merge(int[] lArray, int[] rArray)
    {
        int i=0;
        int j=0;
        int k=0;
        int[] newArr = new int[lArray.length + rArray.length];
        while(i<lArray.length && j<rArray.length)
        {
            if(lArray[i] <= rArray[j])
            {
                newArr[k] = lArray[i];
                i++;
                k++;
            }else
            {
                newArr[k] = rArray[j];
                j++;
                k++;
            }

        }

        //There will be some elements of array left out in any one of the arrays lArray or rArray. Hence the below
        while(i < lArray.length)
        {
            newArr[k] = lArray[i];
            i++;
            k++;
        }

        while(j < rArray.length)
        {
            newArr[k] = rArray[j];
            j++;
            k++;
        }

        return newArr;
    }


    @Override
    public void run() {
        int A[] = new int[10];
        //Fill elements in to the array
        fillArray(A);
        //Print elements before sort
        System.out.println("Printing unsorted array :");
        printArray(A);

        A = mergeSort(A);

        //Print sorted array
        System.out.println("Printing sorted array :");
        printArray(A);
    }

    public static int[] fillArray(int[] A)
    {
        for(int i=0; i<A.length; i++)
        {
            A[i] = (int) (Math.random()*100);
        }

        return A;
    }

    public static void printArray(int[] A)
    {
        for(int i=0; i<A.length; i++)
        {
            System.out.print(A[i] + ", ");
        }
        System.out.println();
    }
}