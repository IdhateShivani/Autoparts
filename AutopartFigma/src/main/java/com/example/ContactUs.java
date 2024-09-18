package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContactUs {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String fullname;
	    private String email;
	    private String phonenumber;
	    private String message;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFullname() {
			return fullname;
		}
		public void setFullname(String fullname) {
			this.fullname = fullname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}

	    

}
