package kr.or.kosa.dto;

public class Member {
	private String username="kosa";
	private String password="1004";
	private String address="서울시 강남구";
	private String adimin="1";
	
	public Member() {
		
	}

	public Member(String username, String password, String address, String adimin) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.adimin = adimin;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdimin() {
		return adimin;
	}

	public void setAdimin(String adimin) {
		this.adimin = adimin;
	}

	@Override
	public String toString() {
		return "Member [username=" + username + ", password=" + password + ", address=" + address + ", adimin=" + adimin
				+ "]";
	}
	
	
}
