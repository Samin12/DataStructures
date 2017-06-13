/**
 * Created by Samin on 6/11/17.
 */
public class Position {
    private String name;
    private int row;
    private int col;

    Position(){
    }

    Position(String timeInfo){

    }

    //getters and setters

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public String getName() {
        return name;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
