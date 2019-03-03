package com.ravi.travel.budget_travel.poc;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DataView {

    private Integer id;

    private String tradeId;

    private String tradeHolder;

    private LocalDateTime bookingDate;

    private LocalDateTime  maturityDate;

    private Long timeTake;

    @Override
    public String toString() {
        return "DataView{" +
                "id=" + id +
                ", tradeId=" + tradeId +
                ", tradeHolder='" + tradeHolder + '\'' +
                ", bookingDate=" + bookingDate +
                ", maturityDate=" + maturityDate +
                ", timeTake=" + timeTake +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getTradeHolder() {
        return tradeHolder;
    }

    public void setTradeHolder(String tradeHolder) {
        this.tradeHolder = tradeHolder;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDateTime maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Long getTimeTake() {
        return timeTake;
    }

    public void setTimeTake(Long timeTake) {
        this.timeTake = timeTake;
    }
}
