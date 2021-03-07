
public class TrainTachograph {
    private Table<Integer, Integer, Integer> table;

    public TrainTachograph() {
        table = HashBasedTable.create();
    }

    public addValueToTable(int time, int position, int referenceSpeed) {
        table.put(time, position, referenceSpeed);
    }

    public Table<Integer, Integer, Integer> getTable() {
        return table;
    }

}


