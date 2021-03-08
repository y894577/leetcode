package Other;

public class PCData {
    private int intData;

    public void setIntData(int intData) {
        this.intData = intData;
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString() {
        return "data：" + intData;
    }
}
