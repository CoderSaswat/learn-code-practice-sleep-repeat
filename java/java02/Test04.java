package java02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test04 {

    private Integer max = 100;
    private Integer min = 1;

    public static void main(String[] args) {

        Test04 te = new Test04();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(()-> {
            try {
                te.oddPrinter();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(()-> {
            try {
                te.evenPrinter();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

//        String str = "Saswat Panda";
//        StringBuilder res = new StringBuilder();
//
//        for (int i = 0; i < str.length(); i++) {
//            if(str.charAt(i) != 'a'){
//                res.append(str.charAt(i));
//            }
//        }
//        System.out.println(res);

    }

    public synchronized void oddPrinter() throws InterruptedException {
        while (min<max){
            if(min%2 != 0){
                System.out.println(min + " " + Thread.currentThread().getName());
                min++;
                notify();
            }else{
                wait();
            }
        }

    }

    public synchronized void evenPrinter() throws InterruptedException {
        while (min < max){
            if(min%2 == 0){
                System.out.println(min + " " + Thread.currentThread().getName());
                min++;
                notify();
            }else{
                wait();

            }
        }

    }

}
