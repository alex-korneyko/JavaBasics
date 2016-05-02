package ua.in.codegym;

/**
 * Created by Alex Korneyko on 02.05.2016.
 */
public class GnomeFood {

    public int[] find(int[] gnomes, int[] portions) {

        int[] result = new int[gnomes.length];

        for (int i = 0; i < gnomes.length; i++) {
            result[findIndexForMaxValue(gnomes)] = findIndexForMaxValue(portions);
        }
        return result;
    }

    private int findIndexForMaxValue(int[] array){

        int indexMaxValue = 0;

        for(int i=0; i<array.length; i++){
            if(array[i] > array[indexMaxValue]){
                indexMaxValue = i;
            }
        }
        array[indexMaxValue] = 0;
        return indexMaxValue;
    }
}