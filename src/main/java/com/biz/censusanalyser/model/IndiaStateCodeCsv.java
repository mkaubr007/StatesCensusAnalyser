package com.biz.censusanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class IndiaStateCodeCsv {


    @CsvBindByName(column = "SrNo")
    public String srNo;

    @CsvBindByName(column = "State Name")
    public String stateName;


    @CsvBindByName(column = "TIN")
    public String tin;

    @CsvBindByName(column = "StateCode")
    public String stateCode;


}