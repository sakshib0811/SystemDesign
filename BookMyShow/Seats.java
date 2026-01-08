package BookMyShow;

import BookMyShow.Enum.SeatCategory;

public class Seats {
    int seatId;
    int rowNo;
    int price;
    SeatCategory sc;

    public SeatCategory getSc() {
        return sc;
    }

    public void setSc(SeatCategory sc) {
        this.sc = sc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    @Override
    public String toString() {
        return "Seats [seatId=" + seatId + ", rowNo=" + rowNo + ", price=" + price + ", sc=" + sc + "]";
    }
}
