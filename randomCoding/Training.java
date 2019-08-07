package randomCoding;

import javax.swing.text.html.HTMLDocument;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class Training {
    //ArrayList that holds the digits of the number
    public static ArrayList<Long> separateNumbers = new ArrayList<>();

    //Method that separates the digits of a number.
    public static void getSeparateNums(long num){


        if (num < 10){
           separateNumbers.add(num);

        }
        if (num >= 10){
            separateNumbers.add(num % 10);

            getSeparateNums((num / 10));
        }

    }

    //Powering up the digits and summing them up.
    public static long powerUpAndSum(ArrayList<Long> list){
        long result = 0;
        for (Long number: separateNumbers) {
            result += Math.pow(number, list.size());
        }

        return result;
    }

    //Main helper method.
    public static ArrayList<Long> getNumbers(long N){


        ArrayList<Long> resultList = new ArrayList<Long>();
        for(long i = 1; i < N; i++){
            getSeparateNums(i);
            long sum = powerUpAndSum(separateNumbers);
            //debug System.out.println(separateNumbers.toString());
            if (sum == i){
                resultList.add(i);
                //debug System.out.println("correct! number is " + i + ", it's composition is " + separateNumbers.toString());
            }
            separateNumbers.clear();

        }

        return resultList;
    }


    public static void main(String[] args){
        System.out.println("Hello World!");

        System.out.println(getNumbers(5349523405986348L).toString());
    }

}
