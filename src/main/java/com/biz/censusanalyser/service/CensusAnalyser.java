package com.biz.censusanalyser.service;

import com.biz.censusanalyser.exception.CensusAnalyserException;
import com.biz.censusanalyser.model.IndiaCensusCSV;
import com.biz.censusanalyser.model.IndiaStateCodeCsv;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser {
    public enum Country {INDIA}
    private Country country;

    public CensusAnalyser(Country country) {
        this.country = country;
    }
    private <E> Iterator<E> getCSVIterator(Reader reader, Class csvClass) {
            CsvToBean<E> csvToBean = new CsvToBeanBuilder<E>(reader)
                    .withType(csvClass)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<E> iterator = csvToBean.iterator();
            return iterator;
    }

    private <E> int getCount(Iterator<E> iterator) {
        Iterable<E> csvIterable = () -> iterator;
        int count = (int) StreamSupport.stream(csvIterable.spliterator(), true).count();
        return count;
    }

    public int loadIndiaCensusData(Country india, String csvFilePath) throws CensusAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            Iterator<IndiaCensusCSV> iterator = getCSVIterator(reader, IndiaCensusCSV.class);
            return getCount(iterator);
        } catch (IOException e) {
            System.out.println(e);
        }
        return 0;
    }
    public int loadIndiaStateCodeData(Country india,String csvFilePath) throws CensusAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            Iterator<IndiaStateCodeCsv> iterator = getCSVIterator(reader, IndiaStateCodeCsv.class);
            return getCount(iterator);
        } catch (IOException e) {
            System.out.println(e);
        }
        return 0;
    }
}
