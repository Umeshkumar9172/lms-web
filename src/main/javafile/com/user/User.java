package com.user;

public class User {
	
	
	private int id;
    private String username;
    private String password;
    private String email;
   

    public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}

	public void setRole(String string) {
		// TODO Auto-generated method stub
		
	}

	public String getRole() {
		// TODO Auto-generated method stub
		return null;
	}

    }



