package com.semakula;

import java.time.LocalDate;

public class Deadline {
    private LocalDate date;

    public Deadline(){
        this.date = LocalDate.now();
    }

    public void setDays(long duration){
        this.date = date.plusDays(duration);
    }

    public void setMonths(long duration){
        this.date = date.plusMonths(duration);
    }

    public void setYears(long duration){
        this.date = date.plusYears(duration);
    }

    /* private void changeDateFormat(String date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        date = dateFormat.format(date);
    }*/

    public LocalDate returnDeadline(){
        return date;
    }
}
