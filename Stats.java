//@author - Matthew Ernst
//@version  1.0

import java.util.*;

public class Stats
{
    public static double round(double roundThis)
    {
        /*
        I needed to round decimals for the sake of visuals, and since it was a common dependency for all of my methods,
        I made it into a method that is easy to use and wont complicate the math heavy code further.
        */
        return (double)Math.round(roundThis * 100) / 100;
    }
    public static double average(ArrayList<Double> collection)
    {
        double total = 0;
        int index;

        if(collection.size() > 1)
        {
            for (index = 0; index <collection.size(); index++)
                total = total + collection.get(index);


            total = total/collection.size();
            return round(total);
        }

        System.out.println("Array had no data set, returning 0, please try again.");
        return 0;
    }
    public static double median(ArrayList<Double> collection)
    {
        //Sorts the array so that we can return the actual median.
        Collections.sort(collection);

        //means that the array has a length that is an odd number, meaning it is possible to find the median (if collections size is 0, this will not equal 1.
        if(collection.size() % 2 == 1)
            return round((collection.get(collection.size() / 2)));

        System.out.println("Median can not be found... either the array is even elements long, or 0 elements long. Returning 0.");
        return 0;
    }
    public static double standardDev(ArrayList<Double> collection)
    {
        double averageCalc, returnSTD = 0;// (/❛o❛\)
        int index;

        if(collection.size() > 1)
        {
            averageCalc = average(collection);

            for(index = 0; index < collection.size(); index++)
                returnSTD = returnSTD + Math.pow((collection.get(index) - averageCalc), 2) ;

            returnSTD = returnSTD / collection.size();
            return round(Math.sqrt(returnSTD));
        }

        System.out.println("Data Set was not long enough. Returning 0, please try again.");
        return 0;

    }
}
