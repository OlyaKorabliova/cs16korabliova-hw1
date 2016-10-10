package ua.edu.ucu.tempseries;

import java.util.Arrays;

public class TemperatureSeriesAnalysis {

    private double[] array;
    private double sum = 0;
    private double elementSum = 0;
    private double sqSum = 0;
    private double averageSqDeviation = 0;

    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        array = temperatureSeries;
    }

    public double average() {
        if (array.length == 1) {
            return array[0];
        }
        else if (array.length > 1) {
            for(int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            return sum / array.length;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public double deviation() {
        for (int i = 0; i < array.length; i++) {
            elementSum += array[i];
        }
        if (array.length == 1) {
            return 0;
        }
        else if (array.length > 1) {
            for (int i = 0; i < array.length; i++) {
                double deviation = array[i] - (elementSum / array.length);
                sqSum += Math.pow(deviation, 2);
            }
            averageSqDeviation = Math.round(Math.pow((sqSum / array.length), 0.5) * 100.0) / 100.0;
            return averageSqDeviation;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public double min() {
        if (array.length == 1) {
            return array[0];
        }
        else if (array.length > 1){
            double minimum = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] < minimum) {
                    minimum = array[i];
                }
            }
            return minimum;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public double max() {
        if (array.length == 1) {
            return array[0];
        }
        else if (array.length > 1){
            double maximum = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] > maximum) {
                    maximum = array[i];
                }
            }
            return maximum;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public double findTempClosestToZero() {
        Double[] array1 = new Double[array.length];
        if (array.length == 1) {
            return array[0];
        }
        else if (array.length > 1){
            for (int i = 0; i < array.length; i++){
                array1[i] = Math.abs(array[i]);
            }
            Arrays.sort(array1);
            return array1[0];
        }
        else {
            throw new IllegalArgumentException();
        }

    }

    public double findTempClosestToValue(double tempValue) {
        Double[] array1 = new Double[array.length];
        if (array.length == 1) {
            return array[0];
        }
        else if (array.length > 1) {
            for (int i = 0; i < array.length; i++) {
                array1[i] = Math.abs(tempValue - array[i]);
            }
            double min = array1[0];
            int k = 0;
            for (int j = 0; j < array1.length; j++) {
                if (array1[j] < min) {
                    min = array1[j];
                    k = j;
                }
            }
            return array[k];
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public double[] findTempsLessThen(double tempValue) {
        if (array.length == 1) {
            return array;
        }
        else if (array.length > 1) {
            int nOfFewerTemps = 0;
            int j = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] < tempValue) {
                    nOfFewerTemps += 1;
                }
            }
            double[] lessThanTempVal = new double[nOfFewerTemps];
            for (int i = 0; i < array.length; i++) {
                if (array[i] < tempValue) {
                    lessThanTempVal[j] = array[i];
                        j++;
                }
            }
            return lessThanTempVal;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (array.length == 1) {
            return array;
        }
        else if (array.length > 1) {
            int nOfBiggerTemps = 0;
            int j = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] >= tempValue) {
                    nOfBiggerTemps += 1;
                }
            }
            double[] greaterThanTempVal = new double[nOfBiggerTemps];
            for (int i = 0; i < array.length; i++) {
                if (array[i] >= tempValue) {
                    greaterThanTempVal[j] = array[i];
                    j++;
                }
            }
            return greaterThanTempVal;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        return -1;
    }
}
