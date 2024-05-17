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
        rows.add(new Row("RTX 4080", 1300));
        rows.add(new Row("RTX 4070", 1000));
        rows.add(new Row("RTX 4060", 780));
        rows.add(new Row("RX 7900", 1300));
        rows.add(new Row("RX 7800", 850));
        rows.add(new Row("RX 7700", 830));
        rows.add(new Row("RTX 4090", 1900));
        rows.add(new Row("RTX 4080", 1350));
        rows.add(new Row("RTX 4070", 1180));
        rows.add(new Row("RTX 4060", 550));
        rows.add(new Row("RX 7900", 1350));

        aggregatedRows = aggregator.aggregate(rows);


        // Hier können die Aggregated Rows Ausgegeben werden
        //for(AggregatedRow row : aggregatedRows){
          //  System.out.println("Modell: " + row.grafikkarte + ", Gesamtpreis: " + row.gesamtPreis + " €");
        //}
        ArrayList<AggregatedRow> sortedRows = Sorter.sort(aggregatedRows);

        //Hier kann die Sortierte Liste ausgegeben werden
        for (AggregatedRow row : sortedRows) {
            System.out.println("Modell: " + row.grafikkarte + ", Gesamtpreis: " + row.gesamtPreis + " €");
        }


    }
}
