package com.ansh.restSpring.dto;

public class TableDTO {

    private int tableId;
    private int capacity;
    private String BookedBy;
    private int tableNumber;

    public TableDTO(int tableId, int capacity, String bookedBy, int tableNumber) {
        this.tableId = tableId;
        this.capacity = capacity;
        this.BookedBy = bookedBy;
        this.tableNumber = tableNumber;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getBookedBy() {
        return BookedBy;
    }

    public void setBookedBy(String bookedBy) {
        BookedBy = bookedBy;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}


