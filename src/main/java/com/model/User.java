package com.model;

import java.io.Serializable;
import java.sql.Date;

//import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class User implements Serializable {

	private static final long serialVersionUID = -7173785023153780950L;
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue
    @Column(name = "id")
    private Long userId;
    //=========================================
	@Column(name = "username", unique = true, nullable = false)
    private String username;
    //=========================================
	@Column(name="password", nullable = false)
    private String password;
	//=========================================
	@Transient
    private String password2;
    //=========================================
	@Column(name = "sex", nullable = false, length = 1)
	private String sex;
	//=========================================
	@NotEmpty(message="Email is required")
	@Column(nullable = false)
	private String email;
	//=========================================
	//@Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
	//========================================
	//@Temporal(TemporalType.DATE)
	@Column(name = "joining_date", nullable = false)
	private Date ddate; // for date picker need sql date
    //=========================================
	@Column(nullable = false)
	private Double subcription;
	//=========================================
	@Column(nullable = false)
	private String addressLine;
	//=========================================
	@Column(name = "postcode", nullable = false)
    private String postcode;
    //=========================================
    @Transient
    private Integer dobDay;
    //=========================================
//    @Transient
//    private Integer dobMonth; // if map use
    @Transient
    private String dobMonth;
    //=========================================
    @Transient
    private Integer dobYear;
    //=========================================

    public User() 
    {
    	
    }
    //=========================================
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

	public Date getDdate() {
		return ddate;
	}
	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}
	
	public Double getSubcription() {
		return subcription;
	}

	public void setSubcription(Double subcription) {
		this.subcription = subcription;
	}
	
	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Integer getDobDay() {
        return dobDay;
    }

    public void setDobDay(Integer dobDay) {
        this.dobDay = dobDay;
    }

//    public Integer getDobMonth() {
//        return dobMonth;
//    }
//
//    public void setDobMonth(Integer dobMonth) {
//        this.dobMonth = dobMonth;
//    }
    
    public String getDobMonth() {
		return dobMonth;
	}
	public void setDobMonth(String dobMonth) {
		this.dobMonth = dobMonth;
	}
	
    public Integer getDobYear() {
        return dobYear;
    }

    public void setDobYear(Integer dobYear) {
        this.dobYear = dobYear;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
