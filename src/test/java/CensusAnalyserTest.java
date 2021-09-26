import com.biz.censusanalyser.exception.CensusAnalyserException;
import com.biz.censusanalyser.service.CensusAnalyser;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CensusAnalyserTest {
    private static final String WRONG_CSV_FILE_PATH = "./src/main/IndiaStateCensusData.csv";
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_FILE_TYPE = "./src/test/resources/IndiaStateCensusData.xlsx";
    private static final String WRONG_DELIMITER_CSV_FILE_PATH = "./src/test/resources/WrongDelimiterIndiaStateCensusData.csv";
    private static final String WRONG_HEADER_CSV_FILE_PATH = "./src/test/resources/WrongHeaderIndiaStateCensusData.csv";
    private static final String STATE_CODE_CSV_FILE_PATH = "./src/main/resources/IndiaStateCode.csv";
    private static final String WRONG_DELIMITER_STATE_CSV_FILE_PATH = "./src/test/resources/WrongDelimiterIndiaStateCode.csv";
    private static final String WRONG_HEADER_STATE_CSV_FILE_PATH = "./src/test/resources/WrongHeaderIndiaStateCode.csv";

    @Test
    public void givenIndianCensusCSVFile_ReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            int numOfRecords = censusAnalyser.loadIndiaCensusData(CensusAnalyser.Country.INDIA, INDIA_CENSUS_CSV_FILE_PATH);
            assertEquals(29, numOfRecords);
            System.out.println("Pass 1");
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(CensusAnalyser.Country.INDIA, WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            System.out.println("Pass 2");
            assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_PROBLEM, e.type);
        }
    }
    @Test
    public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(CensusAnalyser.Country.INDIA, WRONG_FILE_TYPE);
            System.out.println("Pass 3");
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_PROBLEM, e.type);
        }
    }
    @Test
    public void givenIndiaCensusData_WithIncorrectDelimiter_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(CensusAnalyser.Country.INDIA, WRONG_DELIMITER_CSV_FILE_PATH);
            System.out.println("Pass 4");
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.RUN_TIME_EXCEPTION, e.type);
        }
    }
    @Test
    public void givenIndianCensusData_WithWrongHeader_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(CensusAnalyser.Country.INDIA, WRONG_HEADER_CSV_FILE_PATH);
            System.out.println("Pass 5");
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.RUN_TIME_EXCEPTION, e.type);
        }
    }
    @Test
    public void givenIndianStateCodeFile_ShouldReturn_CorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            int numOfRecords = censusAnalyser.loadIndiaStateCodeData(CensusAnalyser.Country.INDIA,STATE_CODE_CSV_FILE_PATH );
            assertEquals(37, numOfRecords);
            System.out.println("Pass 6");
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndiaStateCode_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaStateCodeData(CensusAnalyser.Country.INDIA, WRONG_CSV_FILE_PATH);
            System.out.println("Pass 7");
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndiaStateCodeFile_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaStateCodeData(CensusAnalyser.Country.INDIA,WRONG_FILE_TYPE);
            System.out.println("Pass 8");
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenIndiaStateCodeCSVFile_WithIncorrectDelimiter_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaStateCodeData(CensusAnalyser.Country.INDIA,WRONG_DELIMITER_STATE_CSV_FILE_PATH);
            System.out.println("Pass 9");
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.RUN_TIME_EXCEPTION, e.type);
        }
    }
    @Test
    public void givenIndianStateCodeCSVFile_WithWrongHeader_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CensusAnalyser.Country.INDIA);
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaStateCodeData(CensusAnalyser.Country.INDIA,WRONG_HEADER_STATE_CSV_FILE_PATH);
            System.out.println("Pass 10");
        } catch (CensusAnalyserException e) {
            assertEquals("Error capturing CSV header!", e.getMessage());
        }
    }
}
