package test;
import java.io.*;

public class Bean implements Serializable 
{
	private String uname,pword,fname,lname,email;
	private long phoneno;
	public Bean()
	{

	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	public void setPword(String pword)
	{
		this.pword = pword;
	}
	public void setFname(String fname)
	{
		this.fname = fname;
	}
	public void setLname(String lname)
	{
		this.lname = lname;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setPhoneno(long phoneno)
	{
		this.phoneno = phoneno;
	}
	public String getUname()
	{
		return uname;
	}
	public String getPword()
	{
		return pword;
	}
	public String getFname()
	{
		return fname;
	}
	public String getLname()
	{
		return lname;
	}
	public String getEmail()
	{
		return email;
	}
	public long getPhoneno()
	{
		return phoneno;
	}
}