package bootcamp.springrest.dateRange.domain;

import javax.validation.constraints.NotNull;

public class DateRange {
    @NotNull
    private String fromDate;

    @NotNull
    private String toDate;

    public String getFromDate(){
        return fromDate;
    }

    public String getToDate(){
        return toDate;
    }
}
