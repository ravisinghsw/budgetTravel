package com.ravi.travel.budget_travel.poc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SingleThreadDataPreparation {

    public static void main(String[] args) {
        List<DataView> dataViewList = prepareData(555);
        processData(dataViewList);
        for(DataView dataView : dataViewList){
            System.out.println("---->"+dataView);
        }
    }

    private static void processData(List<DataView> dataViewList) {
        for(DataView dataView : dataViewList){

            try {
                System.out.println(dataView.getTradeHolder() +" is Waiting to get mature ...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dataView.setMaturityDate(LocalDateTime.now());
            LocalDateTime fromTemp = LocalDateTime.from(dataView.getBookingDate());
            dataView.setTimeTake(fromTemp.until(dataView.getMaturityDate(), ChronoUnit.SECONDS));
        }
    }

    private static List<DataView> prepareData(long count){
        List<DataView> dataViewList = new ArrayList<>();
        for(int i = 1 ; i <= count ; i++){
            DataView data = new DataView();
            data.setId(i);
            data.setBookingDate(LocalDateTime.now());
            data.setTradeHolder(Thread.currentThread()+"-"+i);
            data.setTradeId(UUID.randomUUID().toString());
            dataViewList.add(data);
        }
        return dataViewList;
    }

}
