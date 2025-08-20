package com.excelapi.entity;



import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@JsonPropertyOrder({
    "name",
    "previous_Month",
    "current_Month",
    "total_Unit",
    "rate_Per",
    "previous_Due",
    "total_Amount",
    "billing_Cycle",
    "paid"
})

@Entity
public class ExcelDetail {

    @Id
    
    private String Name;
    private Integer previous_Month;
    private Integer current_Month;
    private Integer total_Unit;
    private Integer rate_Per;
    private Integer previous_Due;
    private Integer total_Amount;
    private String billing_Cycle;
    private Boolean Paid;
    
    public ExcelDetail() {
    	
    }
    
	public ExcelDetail(String Name, Integer previous_Month, Integer current_Month, Integer total_Unit, Integer rate_Per,
			Integer previous_Due, Integer total_Amount, String billing_Cycle, Boolean Paid) 
	{
		
		this.Name = Name;
		this.previous_Month = previous_Month;
		this.current_Month = current_Month;
		this.total_Unit = total_Unit;
		this.rate_Per = rate_Per;
		this.previous_Due = previous_Due;
		this.total_Amount = total_Amount;
		this.billing_Cycle = billing_Cycle;
		this.Paid = Paid;
	}
	
	//getter and setter

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getPrevious_Month() {
		return previous_Month;
	}

	public void setPrevious_Month(Integer previous_Month) {
		this.previous_Month = previous_Month;
	}

	public Integer getCurrent_Month() {
		return current_Month;
	}

	public void setCurrent_Month(Integer current_Month) {
		this.current_Month = current_Month;
	}

	public Integer getTotal_Unit() {
		return total_Unit;
	}

	public void setTotal_Unit(Integer total_Unit) {
		this.total_Unit = total_Unit;
	}

	public Integer getRate_Per() {
		return rate_Per;
	}

	public void setRate_Per(Integer rate_Per) {
		this.rate_Per = rate_Per;
	}

	public Integer getPrevious_Due() {
		return previous_Due;
	}

	public void setPrevious_Due(Integer previous_Due) {
		this.previous_Due = previous_Due;
	}

	public Integer getTotal_Amount() {
		return total_Amount;
	}

	public void setTotal_Amount(Integer total_Amount) {
		this.total_Amount = total_Amount;
	}

	public String getBilling_Cycle() {
		return billing_Cycle;
	}

	public void setBilling_Cycle(String billing_Cycle) {
		this.billing_Cycle = billing_Cycle;
	}

	public Boolean getPaid() {
		return Paid;
	}

	public void setPaid(Boolean paid) {
		Paid = paid;
	}
	
}
