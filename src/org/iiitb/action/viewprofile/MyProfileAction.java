package org.iiitb.action.viewprofile;
import java.sql.Connection;
import java.util.Map;
import java.util.List;

import org.apache.struts2.interceptor.SessionAware;
import org.iiitb.action.dao.LayoutDAO;
import org.iiitb.action.dao.MyProfileDAO;
import org.iiitb.action.dao.impl.LayoutDAOImpl;
import org.iiitb.model.User;
import org.iiitb.model.layout.AnnouncementsItem;
import org.iiitb.model.layout.NewsItem;
import org.iiitb.util.ConnectionPool;
import org.iiitb.util.Constants;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MyProfileAction extends ActionSupport implements SessionAware
{

	private Map<String, Object> session;
	private String name;
	private String password;
	private String rollno;
	private List<String> interests;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRollno()
	{
		return rollno;
	}

	public void setRollno(String rollno)
	{
		this.rollno = rollno;
	}

	public List<String> getInterests()
	{
		return interests;
	}

	public void setInterests(List<String> interests)
	{
		this.interests = interests;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}

	private List<NewsItem> allNews;
	private List<AnnouncementsItem> announcements;
	private LayoutDAO layoutDAO = new LayoutDAOImpl();
	private String lastLoggedOn = "";

	public String execute() throws Exception
	{
		User user = (User) session.get("user");
		MyProfileDAO prof = new MyProfileDAO(user.getUserId());
		if (user != null)
		{
			name = user.getName();
			password = user.getPassword();
			// name=prof.getPhoto();
			rollno = prof.getRollno();
			interests = prof.getInterests();
			
			Connection connection = ConnectionPool.getConnection();
			allNews = layoutDAO.getAllNews(connection);
			announcements = layoutDAO.getAnnouncements(connection,
					Integer.parseInt(user.getUserId()));
			setLastLoggedOn((String) this.session.get(Constants.LAST_LOGGED_ON));
			ConnectionPool.freeConnection(connection);
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session=session;

	}

	public String getLastLoggedOn()
	{
		return lastLoggedOn;
	}

	public void setLastLoggedOn(String lastLoggedOn)
	{
		this.lastLoggedOn = lastLoggedOn;
	}

}
