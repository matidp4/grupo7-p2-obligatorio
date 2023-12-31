public class Sorting {

    private static <T extends Comparable<T>> T[] heapSort(T[] elements, int orderedElements){
        int valuePosition;
        int newPosition;
        T value;
        for(int i = 1; i < elements.length ; i++){
            valuePosition = i;
            value = elements[i];
            while (valuePosition != 0 && value.compareTo(elements[getHeapFatherPosition(valuePosition)]) > 0) {
                T tempValue = elements[getHeapFatherPosition(valuePosition)];
                elements[getHeapFatherPosition(valuePosition)] = value;
                elements[valuePosition] = tempValue;
                valuePosition = getHeapFatherPosition(valuePosition);
            }
        }

        for (int i = elements.length-1; i >= elements.length-orderedElements;i--){
            value = elements[i];
            elements[i] = elements[0];
            elements[0] = value;
            valuePosition = 0;
            newPosition = valuePosition;
            value = elements[0];
            while(true) {

                if (getHeapChildPosition(valuePosition) < i && value.compareTo(elements[getHeapChildPosition(valuePosition)]) < 0){
                    newPosition = getHeapChildPosition(valuePosition);
                    value = elements[newPosition];
                }
                if (getHeapChildPosition(valuePosition)+1 < i && value.compareTo(elements[getHeapChildPosition(valuePosition)+1]) < 0){
                    newPosition = getHeapChildPosition(valuePosition)+1;
                }

                if (valuePosition != newPosition ){
                    value = elements[valuePosition];
                    elements[valuePosition] = elements[newPosition];
                    elements[newPosition] = value;
                    valuePosition = newPosition;
                } else{
                    break;
                }
            }
        }

        if (orderedElements == elements.length){
            if(elements[0].compareTo(elements[1]) > 0){
                value = elements[0];
                elements[0] = elements[1];
                elements[1] = value;
            }
        }


        return elements;

    }

    public static <T extends Comparable<T>> T[] heapSort(T[] elements){
        return heapSort(elements, elements.length);
    }
    private static int getHeapFatherPosition(int childPosition){
        return ((childPosition-1)/2);
    }
    private static  int getHeapChildPosition(int fatherPosition){
        return (2*fatherPosition +1);
    }
}
