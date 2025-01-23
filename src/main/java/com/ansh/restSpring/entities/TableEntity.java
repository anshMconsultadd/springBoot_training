package com.ansh.restSpring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "table_bookings")
public class TableEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int tableId;
    private int capacity;
    private String bookedBy;
    private int tableNumber;

    public TableEntity() {
    }

    public TableEntity(int capacity, String bookedBy, int tableNumber) {
        this.capacity = capacity;
        this.bookedBy = bookedBy;
        this.tableNumber = tableNumber;
    }

    public int getTableId() {
        return tableId;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
