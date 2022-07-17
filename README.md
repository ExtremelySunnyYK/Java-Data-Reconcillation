# Java-Data-Reconcillation


### Use Case Digram
![image](https://user-images.githubusercontent.com/46377366/178427847-2ec76bc7-6cd4-4e5c-b5eb-96edbc2009d6.png)

### Equivalence Class & Boundary Testing
Equivalence Testing

| Class  | Invalid | Valid |
| --- | --- | --- |
| # CSV Files | > 2 or <2 | 2 |
| File input type | non .csv | .csv |
| CSV Contents | Random strings or variable types for each row.  | Proper variable type for each row |
| CSV Structure | Column headers do not follow predefined. Columns allowed.  | Based on defined rows and columns |
| Negative Number | negative number present | No negative number |
| file 1 and file 2 have duplicates within their own file | -  | Should still handle duplicates normally |
| Different row order for file 1 & 2  | - | Handled normally |
| # of rows  | - | - |
| rows having different or same ids | should still process if the rows are different | - |
|  |  |  |

Boundary value testing

| Class  | Min Test | Medium Test | Max |
| --- | --- | --- | --- |
| # CSV Files | 0 | 2 | 3 |
| CSV Contents | 1 row that have wrong variable type | Proper variable type for half of rows | All rows have wrong variable type |
| CSV Structure | All headers follow predefined | half of the headers are declared wrongly | all headers are declared wrongly |
| Negative Number | 1 negative number present | Some negative number present | all numbers are negative |
| file 1 and file 2 have duplicates within their own file | 1 | Some | All |
| Different row order for file 1 & 2  | 1 row | Some  | All |
| # of rows  | 1 row | 50 rows | 500 rows |
| rows having different or same ids | 1 row not in file 1 but in file 2 | - | every row has different id |
|  |  |  |  |

### Setup 
Version : Java 11

For starters, run CsvComparer.main() 
