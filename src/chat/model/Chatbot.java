package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = movieList;
		this.shoppingList = shoppingList;
		this.cuteAnimalMemes = cuteAnimalMemes;
		this.questions = questions;
		this.username = username;
		this.content = content;
		this.intro = intro;
		this.currentTime = currentTime;
		this.topics = topics;
		this.verbs = verbs;
		this.followUps = followUps;
		
		buildVerbs();
		buildShoppingList();
	}

	private void buildMovieList()
	{
		
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("Snacks");
		shoppingList.add("Veggies");
		shoppingList.add("Protine");
		shoppingList.add("Candy");
		shoppingList.add("Fruit");
	}
	
	private void buildCuteAnimals()
	{
		
	}
	
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	private void buildQuestions()
	{
		
	}
	
	public String processConversation(String input)
	{
		boolean test = false;
		
		return (input);
	}
	
	public boolean lengthChecker(String input)
	{
		boolean test = true;
		
		if(input == null)
		{
			test = false;
		}
		else if(input.length() <= 2)
		{
			test = false;
		}
		
		return (test);
	}
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		boolean test = false;
		
		if(shoppingItem.contains("protine") && shoppingItem.contains("veggies") && shoppingItem.contains("snacks") && !shoppingItem.contains("slug bait"))
		{
			test = true;
		}
		return test;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
