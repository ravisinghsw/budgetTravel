package com.ravi.travel.budget_travel.poc;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.CompletableFuture.runAsync;

public class ParallelDataPreparation {

    //private static ExecutorService executorService = Executors.newCachedThreadPool();
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        List<CompletableFuture<List<Map<String,Object>>>> completableFutureList=new ArrayList<>();
        int breakListCount = 10;
        List<DataView> dataViewList = prepareData(555);
        int listSize = dataViewList.size();
        int startIndex = 0;
        int endIndex = breakListCount;
        while (startIndex < listSize){
            if(endIndex >listSize){
                endIndex = listSize;
            }
            List<DataView> subDataViewList = dataViewList.subList(startIndex,endIndex) ;
            CompletableFuture<List<Map<String,Object>>> completableFuture = CompletableFuture.supplyAsync(()-> processData(subDataViewList),executorService);
            completableFutureList.add(completableFuture);
            startIndex = endIndex;
            endIndex  +=breakListCount;
        }

        for(CompletableFuture<List<Map<String,Object>>> completableFuture : completableFutureList){
            List<Map<String,Object>> processedData =  completableFuture.get();
        }

        for(DataView dataView : dataViewList){
            System.out.println("---->"+dataView);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total Time Taken to Process all data :: "+(endTime-startTime));
    }

    private static List<Map<String,Object>> processData(List<DataView> dataViewList) {
        List<Map<String,Object>> obj = new ArrayList<>();
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
        return obj;
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
