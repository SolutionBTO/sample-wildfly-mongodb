package br.com.sample.solutionbto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentAggregate implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<BirthdaySummary> birthdaySummary;
    private List<CitiesSummary> citiesSummary;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BirthdaySummary implements Serializable{
        private static final long serialVersionUID = 1L;

        private String monthYear;
        private BigInteger totalAmount;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CitiesSummary implements Serializable{
        private static final long serialVersionUID = 1L;

        private String city;
        private BigInteger totalAmount;
    }
}
