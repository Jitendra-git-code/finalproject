package vldms.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Consignment_usage_table 
{
	@Id
	
	private int consignment_no;
	private int total_quantity;
	private int consumed;
	private int damaged;
	private int remaining;
	private Timestamp date;
	
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="consignment_no", nullable=false,insertable = false, updatable = false)
    private Vaccination_office_distribution vod;
	
	
	public Vaccination_office_distribution getVod() {
		return vod;
	}
	public void setVod(Vaccination_office_distribution vod) {
		this.vod = vod;
	}
	public int getConsignment_no() 
	{
		return consignment_no;
	}
	public void setConsignment_no(int consignment_no) 
	{
		
		this.consignment_no = consignment_no;
	}
	public int getTotal_quantity() 
	{
		return total_quantity;
	}
	public void setTotal_quantity(int total_quantity) 
	{
		this.total_quantity = total_quantity;
	}
	public int getConsumed() 
	{
		return consumed;
	}
	public void setConsumed(int consumed) 
	{
		this.consumed = consumed;
	}
	public int getDamaged() 
	{
		return damaged;
	}
	public void setDamaged(int damaged) 
	{
		this.damaged = damaged;
	}
	public int getRemaining() 
	{
		return remaining;
	}
	public void setRemaining(int remaining)
	{
		this.remaining = remaining;
	}
	public Timestamp getDate() 
	{
		return date;
	}
	public void setDate(Timestamp date) 
	{
		this.date = date;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Consignment_usage_table [consignment_no=");
		builder.append(consignment_no);
		builder.append(", total_quantity=");
		builder.append(total_quantity);
		builder.append(", consumed=");
		builder.append(consumed);
		builder.append(", damaged=");
		builder.append(damaged);
		builder.append(", remaining=");
		builder.append(remaining);
		builder.append(", date=");
		builder.append(date);
		builder.append(", vod=");
		builder.append(vod);
		builder.append(", getVod()=");
		builder.append(getVod());
		builder.append(", getConsignment_no()=");
		builder.append(getConsignment_no());
		builder.append(", getTotal_quantity()=");
		builder.append(getTotal_quantity());
		builder.append(", getConsumed()=");
		builder.append(getConsumed());
		builder.append(", getDamaged()=");
		builder.append(getDamaged());
		builder.append(", getRemaining()=");
		builder.append(getRemaining());
		builder.append(", getDate()=");
		builder.append(getDate());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	/**
	 * @param consignment_no
	 * @param total_quantity
	 * @param consumed
	 * @param damaged
	 * @param remaining
	 * @param date
	 * @param vod
	 */
	public Consignment_usage_table(int consignment_no, int total_quantity, int consumed, int damaged, int remaining,
			Timestamp date, Vaccination_office_distribution vod) {
		super();
		this.consignment_no = consignment_no;
		this.total_quantity = total_quantity;
		this.consumed = consumed;
		this.damaged = damaged;
		this.remaining = remaining;
		this.date = date;
		this.vod = vod;
	}
	/**
	 * 
	 */
	public Consignment_usage_table() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
