package datamodel;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE ProjectTable (   
  name VARCHAR(30) NOT NULL       
 );
 */
@Entity
@Table(name = "ProjectTable")
public class Costumer {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") // specify the column name. Without it, it will use method name
	private Integer id;
	

@Column(name = "name")
   private String name;

   
   @Column(name = "phone")
   private String phone;
   
  
   @Column(name = "license")
   private String license;
   
   @Column(name = "car")
   private String car;
   
   @Column(name = "start")
   private String start;
   
   @Column(name = "finish")
   private String finish;

   public Costumer() {
   }

   public Costumer(Integer id, String name, String phone, String license, String car, String start, String finish) {
      this.id = id;
	   this.name = name;
      this.phone = phone;
      this.license = license;
      this.car = car;
      this.start = start;
      this.finish = finish;
    		  
   }
   
   public Costumer( String name, String phone, String license, String car, String start, String finish) {
		  this.name = name;
	      this.phone = phone;
	      this.license = license;
	      this.car = car;
	      this.start = start;
	      this.finish = finish;
	    		  
   }
   public Integer getId() {
 		return id;
 	}

 	public void setId(Integer id) {
 		this.id = id;
 	}
 	
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPhone() {
	   return phone;
   }

   public void setPhone(String phone) {
	   this.phone = phone;
   }

  


   public String getLicense() {
	return license;
}

public void setLicense(String license) {
	this.license = license;
}

public String getCar() {
	return car;
}

public void setCar(String car) {
	this.car = car;
}

public String getStart() {
	return start;
}

public void setStart(String start) {
	this.start = start;
}

public String getFinish() {
	return finish;
}

public void setFinish(String finish) {
	this.finish = finish;
}

@Override
   public String toString() {
      return "Costumer: " + this.name + ", " + this.phone + ", " + this.license + ", " + this.car + ", " + this.start + ", " + this.finish + ".";
   }
}