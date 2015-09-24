## Programming exercise
#### 1 Java Task
Please write an implementation for the following interface:

```Java
public interface ITable {
    /**
     * Sets the value of the column to specified value.
     *
     * @param cell  string in cell string format
     * @param value positive integer [1, 1_000_000_000]
     */
    void set(String cell, long value);

    /**
     * Gets the value from the specified cell. if the cell is empty – return 0.
     *
     * @param cell cell reference
     * @return cell value, or 0 if cell is empty
     */
    long get(String cell);

    /**
     * Gets the sum of values in the range [fromCell:toCell]
     *
     * @param fromCell “from” cell reference
     * @param fromCell “to” cell reference
     * @return sum of values in the range
     */
    long sum(String fromCell, String toCell);

   /**
     * Gets the product (multiplying) of values in the range [fromCell:toCell] modulo 1_000_000;
     *
     * @param fromCell “from” cell reference
     * @param fromCell “to” cell reference
     * @return product of values in the range
     */
    long mult(String fromCell, String toCell);
}
```
- Cell string format - "[A-Z]\d+". First letter is always an upper case English character and
indicates the column. The rest of string contains the row number (positive integer >= 1 and <= 1_000_000_000).

- Limits
Maximum row number is 1000000000 (note: your implementation should be optimized
to handle requests like SUM A1..Z1_000_000_000 in reasonable time).
Maximum number of non-empty cells is 10000.

##### 1 Example

```Java
table.set("A1", 2);
table.set("B1000000000", 3);
assertEquals(table.get("A1"), 2L);
assertEquals(table.get("B1"), 0L);
assertEquals(table.sum("C1", "C1"), 0L);
assertEquals(table.mult("C1", "C1"), 1L); //see https://en.wikipedia.org/wiki/Empty_product
assertEquals(table.sum("A1", "A1"), 2L);
assertEquals(table.sum("A1", "B3"), 2L);
assertEquals(table.sum("A1", "B1000000000"), 5L);
assertEquals(table.mult("B1000000000", "A1"), 6L);
assertEquals(table.mult ("B100000000", "B1000000000"), 3L);
table.set("B2", 5);
assertEquals(table.sum("A1", "B1000000000"), 10L);
```

#### 2 SQL Task

We have the following SQL table:

| Name | Department | Salary |
| ---- | ---------- | ------ |
| Wendy | Accounting and Finance | 100 |
| Francisca | Accounting and Finance | 120 |
| Michelle | Research and Development | 125 |
| John | Research and Development | 107 |
| Carl | Human Resource | |

Please write an SQL query that returns names of people with maximum salary in their
departments (if there are 2 people with the maximum salary in the same department –
return all of them).

For the table above the query should return the following data:

Name
Francisca
Michelle
Carl