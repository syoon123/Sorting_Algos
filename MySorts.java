/*======================================
Class MySorts: 
Implements
- Bubble Sort
- Selection Sort
- Bogo Sort
======================================*/

import java.util.ArrayList;

public class SelectionSort {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) 
    {
	for (int p=0; p<data.size(); p++) {
	    int champ = p;
	    for (int i=p; i<data.size(); i++) {
		if ((data.get(i)).compareTo(data.get(champ)) < 0) {
		    champ = i;
		}
	    }
	    Comparable temp = data.get(champ);
	    data.set(champ, data.get(p));
	    data.set(p, temp);
	}
    }//end selectionSort -- O(?)


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> 
	selectionSort( ArrayList<Comparable> input ) 
    {
	ArrayList ret = input;
	selectionSortV(ret);
	return ret;
    }//end selectionSort -- O(?)

    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	for (int p=0; p<data.size()-1; p++) // there are always n-1 passes
	    {
		for (int i=data.size()-1; i>0; i--) // going right to left
		    {
			if ((data.get(i)).compareTo(data.get(i-1)) < 0) // if current < previous
			{
			    Comparable temp = data.get(i); // swap
			    data.set(i, data.get(i-1));
			    data.set(i-1, temp);
			}
		    }
	    }	    
    }//end bubbleSortV -- O(n^2)


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
    {
	ArrayList<Comparable> ret = new ArrayList<Comparable>(l);
	bubbleSort(ret);
	return ret;
    }//end bubbleSort -- O(?)

    // VOID version of bogoSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bogoSort(ArrayList<Comparable> l) {
	while (!(isSorted(l))) {
	    shuffle(l);
	}
    }

    // ArrayList-returning bogoSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bogoSorted(ArrayList<Comparable> l) {
	ArrayList<Comparable> ret = new ArrayList<Comparable>(l);
	bogoSort(ret);
	return ret;
    }

    //main method for testing
    public static void main( String [] args ) {
	
    }//end main

}//end class SelectionSort
