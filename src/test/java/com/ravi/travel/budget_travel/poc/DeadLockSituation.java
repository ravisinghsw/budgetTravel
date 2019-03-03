package com.ravi.travel.budget_travel.poc;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DeadLockSituation {

    private static ExecutorService executorService = Executors.newFixedThreadPool(500);
    private static ExecutorService executorService1 = Executors.newFixedThreadPool(500);
    private static PrintStackTrace printStackTrace = new PrintStackTrace();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future> futurelist = new ArrayList<>();
        ConnectionVerbosePrint cp = new ConnectionVerbosePrint();

        for(int i=1 ; i<=120000 ; i++){
            futurelist.add (executorService1.submit(()->cp.print(printStackTrace)));
            futurelist.add(executorService.submit(()->doPrintStackTrace(printStackTrace)));
        }
        int count =0 ;
        for(Future f :  futurelist){
            System.out.println(count+" Result :: "+f.get());
            f.get();
            count++;
        }
        executorService.shutdownNow();
        System.exit(1);
    }


    private static void doPrintStackTrace(PrintStackTrace printStackTrace){
        try {
            System.out.println("Current Thread is :: "+Thread.currentThread());
            throw  new ArithmeticException("Custom Exception by me :D ");
        }catch (Exception ex){
            printStackTrace.writePrintStackTrace(ex);
            //System.out.println(ex.getMessage());
        }
    }

    private static class PrintStackTrace {
        private synchronized void writePrintStackTrace(Exception ex){
                ex.printStackTrace();
        }
    }


    private static  class  ConnectionVerbosePrint{
        public synchronized void print(PrintStackTrace printStackTrace){
            try {
                System.out.println(this + "--------Current Thread is :: "+Thread.currentThread());
                throw  new Exception("Custom Exception in ConnectionVerbosePrint ");
            }catch (Exception ex){
                printStackTrace.writePrintStackTrace(ex);
                System.out.println(ex.getMessage());
            }
        }
    }
}
