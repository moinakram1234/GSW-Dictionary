package view;

import java.sql.SQLException;
import java.util.HashMap;
import javafx.scene.Parent;

public class ViewProvider {
	
	private HashMap<String,Parent> views;

	public static final String HOMESCREEN="Homescreen";
	public static final String Login="Login";
	public static final String viewFeedback="Feedback";
	public static final String mainSearchScreen="SearchScreen";
	public static final String giveFeedback="giveFeedback";
	public static final String giveFavrites="giveFavrites";
	public static final String helpView="HelpView";
	public static final String updatemeaning="UpdateMeaning";
	public static final String history="hisory";
	public  ViewProvider()
	{
		this.views=new HashMap<>();
		this.views.put(ViewProvider.mainSearchScreen, new MainSearchScreen());
		this.views.put(ViewProvider.HOMESCREEN, new MainScreen());
		this.views.put(ViewProvider.Login, new LoginScreen());
		this.views.put(ViewProvider.giveFeedback, new GiveFeedback());
		this.views.put(ViewProvider.viewFeedback, new viewFeedback());
		this.views.put(ViewProvider.giveFavrites, new ViewFavourites());
		this.views.put(ViewProvider.helpView, new helpView());
		this.views.put(ViewProvider.updatemeaning, new UpdateMeaning());
			try {
				this.views.put(ViewProvider.history, new HistoryScreen());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	
	public Parent getView(String viewName)
	{
		return this.views.getOrDefault(viewName, null);
	}
}
