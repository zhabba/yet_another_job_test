package tests.xzha.implementation;

import tests.xzha.ifaces.ITable;

import java.util.Iterator;
import java.util.TreeMap;

public class ITableImpl implements ITable {

    private static TreeMap<String, Long> TABLE = new TreeMap<>();

    @Override
    public void set(String cell, long value) {
        TABLE.put(cell, value);
    }

    @Override
    public long get(String cell) {
        if (TABLE.containsKey(cell)) {
            return TABLE.get(cell);
        } else {
            return 0;
        }
    }

    @Override
    public long sum(String fromCell, String toCell) {
		if (fromCell.compareTo(toCell) > 0) {
			String acc = toCell;
			toCell = fromCell;
			fromCell = acc;
		}
        long sum = 0;
        Iterator<String> iter = TABLE.tailMap(fromCell).keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            long currentRow = Long.parseLong(key.substring(1));
			String currentColumn = key.substring(0, 1);
            long fromRow = Long.parseLong(fromCell.substring(1));
			long toRow = Long.parseLong(toCell.substring(1));
			String toColumn = toCell.substring(0, 1);
			if (currentColumn.compareTo(toColumn) <= 0 && (currentRow >= fromRow && currentRow <= toRow)) {
                sum += TABLE.get(key);
			}
        }
        return sum;
    }

    @Override
    public long mult(String fromCell, String toCell) {
		if (fromCell.compareTo(toCell) > 0) {
			String acc = toCell;
			toCell = fromCell;
			fromCell = acc;
		}
        long mult = 1;
        Iterator<String> iter = TABLE.tailMap(fromCell).keySet().iterator();
        while (iter.hasNext()) {
			String key = iter.next();
			long currentRow = Long.parseLong(key.substring(1));
			String currentColumn = key.substring(0, 1);
			long fromRow = Long.parseLong(fromCell.substring(1));
			long toRow = Long.parseLong(toCell.substring(1));
			String toColumn = toCell.substring(0, 1);
            if (currentColumn.compareTo(toColumn) <= 0 && (currentRow >= fromRow && currentRow <= toRow)) {
                long val = TABLE.get(key);
                if (val == 0) {
                    val =1;
                }
                mult = (mult * val) % 1_000_000;
            }
        }
        return mult;
    }
}
