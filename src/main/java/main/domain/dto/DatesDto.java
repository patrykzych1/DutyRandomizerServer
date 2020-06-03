package main.domain.dto;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class DatesDto implements Serializable {
    private Date startDate;
    private Date endDate;
    private List<String> days;
    private int amountOfWorkers;



    public DatesDto(Date startDate, Date endDate, List<String> days, int amountOfWorkers){
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = days;
        this.amountOfWorkers = amountOfWorkers;
    }

    public List<String> getDays() {
        return days;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getAmountOfWorkers() {
        return amountOfWorkers;
    }
}
