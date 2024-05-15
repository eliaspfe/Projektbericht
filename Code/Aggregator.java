package Code;



import java.util.ArrayList;

public class Aggregator {
    
    public ArrayList<AggregatedRow> aggregate(ArrayList<Row> rows){
        ArrayList<AggregatedRow> aggregatedRows = new ArrayList<>();
        ArrayList<String> seenGraphicsCards = new ArrayList<>();

        for(Row row : rows){
            findGreatestPriceForEveryGPU(aggregatedRows, row);
            if(seenGraphicsCards.contains(row.grafikkarte) == false){
                aggregatedRows.add(new AggregatedRow(row.grafikkarte, row.gesamtPreis));
                seenGraphicsCards.add(row.grafikkarte);
            }
        }

        return aggregatedRows;
    }


    public void findGreatestPriceForEveryGPU(ArrayList<AggregatedRow> aggregatedRows, Row row){
        for(AggregatedRow aggregatedRow : aggregatedRows){
            if(aggregatedRow.grafikkarte.equals(row.grafikkarte)){
                if (row.gesamtPreis > aggregatedRow.gesamtPreis){
                    aggregatedRow.gesamtPreis = row.gesamtPreis;
                }
            }
        }
    }


    
}
