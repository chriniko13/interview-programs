package interview.programs.first;

import java.util.concurrent.*;

public class ThreadProblem {

    public static void main(String[] args) {

        // using threads (one, two, main) do the following calculation: 1*2/(1+2)

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Double> multiplyFuture = executorService.submit(new Multiply());

        Future<Double> additionFuture = executorService.submit(new Addition());


        try {
            Double multiplyResult = multiplyFuture.get();
            Double additionResult = additionFuture.get();

            Double result = multiplyResult / additionResult;

            System.out.println("result = " + result);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();

    }
}


class Multiply implements Callable<Double> {

    @Override
    public Double call() throws Exception {
        return 1.0D * 2.0D;
    }
}


class Addition implements Callable<Double> {

    @Override
    public Double call() throws Exception {
        return 1.0D + 2.0D;
    }
}
