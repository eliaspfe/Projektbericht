package Code;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Aggregator aggregator = new Aggregator();
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
