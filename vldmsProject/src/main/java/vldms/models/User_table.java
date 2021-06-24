package vldms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class User_table 
{
	@Id
	 private String user_id ; 
	 private String password ;
	 private String name;
	 
	 
//	 @Enumerated(EnumType.STRING)
//	 @Column(name = "type_of_user" , columnDefinition="ENUM('M','S')" ,nullable = false )
//	 private Sex sex;
	 
	 @Column(name = "type_of_user")
	 @Enumerated(EnumType.STRING)
	 private UserTypeEnum type_of_user;
	 
	 
	 
	 private  String email_id; 
	 private int mobile_no ;
	 
	 
	 public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public UserTypeEnum getType_of_user() {
		return type_of_user;
	}
	public void setType_of_user(UserTypeEnum type_of_user) {
		this.type_of_user = type_of_user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email_id == null) ? 0 : email_id.hashCode());
		result = prime * result + mobile_no;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((type_of_user == null) ? 0 : type_of_user.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User_table other = (User_table) obj;
		if (email_id == null) {
			if (other.email_id != null)
				return false;
		} else if (!email_id.equals(other.email_id))
			return false;
		if (mobile_no != other.mobile_no)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (type_of_user != other.type_of_user)
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(int mobile_no) {
		this.mobile_no = mobile_no;
	}
	public User_table(String user_id, String password, String name, UserTypeEnum type_of_user, String email_id,
			int mobile_no) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.name = name;
		this.type_of_user = type_of_user;
		this.email_id = email_id;
		this.mobile_no = mobile_no;
	}
	public User_table() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User_table [user_id=");
		builder.append(user_id);
		builder.append(", password=");
		builder.append(password);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type_of_user=");
		builder.append(type_of_user);
		builder.append(", email_id=");
		builder.append(email_id);
		builder.append(", mobile_no=");
		builder.append(mobile_no);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	 
}
