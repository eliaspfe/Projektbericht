import java.util.ArrayList;


public class Sorter {

    public static ArrayList<AggregatedRow> mergeSort(ArrayList<AggregatedRow> rows) {
        int length = rows.size();
        if (length < 2) {
            return rows;
        }
        int middleIndex = length / 2;
        ArrayList<AggregatedRow> leftSide = new ArrayList<>(rows.subList(0, middleIndex));
        ArrayList<AggregatedRow> rightSide = new ArrayList<>(rows.subList(middleIndex, length));
        leftSide = mergeSort(leftSide);
        rightSide = mergeSort(rightSide);
        return merge(leftSide, rightSide);
    }

    public static ArrayList<AggregatedRow> merge(ArrayList<AggregatedRow> leftSide, ArrayList<AggregatedRow> rightSide) {
        ArrayList<AggregatedRow> mergedArrayList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftSide.size() && rightIndex < rightSide.size()) {
            if (leftSide.get(leftIndex).gesamtPreis >= rightSide.get(rightIndex).gesamtPreis) {
                mergedArrayList.add(leftSide.get(leftIndex));
                leftIndex++;
            } else {
                mergedArrayList.add(rightSide.get(rightIndex));
                rightIndex++;
            }
        }
        while (leftIndex < leftSide.size()) {
            mergedArrayList.add(leftSide.get(leftIndex));
            leftIndex++;
        }
        while (rightIndex < rightSide.size()) {
            mergedArrayList.add(rightSide.get(rightIndex));
            rightIndex++;
        }
        return mergedArrayList;
    }

    public static ArrayList<AggregatedRow> sort(ArrayList<AggregatedRow> rows) {
        return mergeSort(rows);
    }
}


