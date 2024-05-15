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


    public static void main(String[] args) {
        Aggregator aggregator = new Aggregator();
        //Sorter sorter = new Sorter();
        ArrayList<Row> rows = new ArrayList<>();
        ArrayList<AggregatedRow> aggregatedRows = new ArrayList<>();

        rows.add(new Row("RTX 4090", 1950));
        rows.add(new Row("RTX 4080", 1530));
        rows.add(new Row("RTX 4070", 950));
        rows.add(new Row("RTX 4060", 600));
        rows.add(new Row("RX 7900", 1530));
        rows.add(new Row("RX 7800", 800));
        rows.add(new Row("RX 7700", 650));
        rows.add(new Row("RTX 4090", 2130));
        aggregatedRows = aggregator.aggregate(rows);

        //for(AggregatedRow row : aggregatedRows){
          //  System.out.println(row.grafikkarte + " " + row.gesamtPreis);
        //}
        ArrayList<AggregatedRow> sortedRows = Sorter.sort(aggregatedRows);
        for (AggregatedRow row : sortedRows) {
            System.out.println(row.grafikkarte + ": " + row.gesamtPreis + " €");
        }


    }
}
