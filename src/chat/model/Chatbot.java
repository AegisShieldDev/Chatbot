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
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.questions = new String[10];
		this.username = username;
		this.content = "";
		this.intro = "";
		this.currentTime = null;
		this.topics = new String[7];
		this.verbs = new String[4];
		this.followUps = new String[5];
		
		buildVerbs();
		buildShoppingList();
		buildQuestions();
		buildTopics();
		buildCuteAnimals();
	}
	//Builds the list of movies
	private void buildMovieList()
	{
		Movie Spiderman = new Movie("Spiderman");
		Movie HiddenFigures = new Movie("Hidden Figures");
		movieList.add(Spiderman);
		movieList.add(HiddenFigures);
	}
	//Builds list of topics for the bot to use
	private void buildTopics()
	{
		topics[0] = ("Animals");
		topics[1] = ("People");
		topics[2] = ("Time");
		topics[3] = ("Places");
		topics[4] = ("Weather");
		topics[5] = ("News");
		topics[6] = ("Fun things");
		
	}
	//Builds the shopping list
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("candy");
		shoppingList.add("fruit");
	}
	//Builds the animal memes
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("pupper");
	}
	//Builds verbs
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	//Builds questions for the bot
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "What is your birth date?";
		questions[2] = "Do you have any pets?";
		questions[3] = "What sports do you play?";
		questions[4] = "Do you ski?";
		questions[5] = "Do you play video games?";
		questions[6] = "Are you going to college?";
		questions[7] = "Do you like school?";
		questions[8] = "What kind of music do you like?";
		questions[9] = "What are you afraid of?";
	}
	//Processes input to the bot
	public String processConversation(String input)
	{
		String chatboxResponse = "";
		chatboxResponse += "You said:" + "\n"  + input + "\n";
		
		chatboxResponse += BuildChatbotResponse();
		
		return chatboxResponse;
	}
	//Creates the bot's response
	private String BuildChatbotResponse()
	{
		String response = "I ";
		int random = (int)(Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int)(Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int)(Math.random() * questions.length);
		response += " " + questions[random];
		
		return response;
	}
	//Tests the input's length
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
	//Checks the animal memes
	public boolean cuteAnimalMemeChecker(String input)
	{
		boolean test = false;
		
		for(int i = 0; i < cuteAnimalMemes.size(); i++)
		{
			if(input.contains(cuteAnimalMemes.get(i)))
			{
				test = true;
			}
		}
		return test;
	}
	//Checks the shopping list
	public boolean shoppingListChecker(String shoppingItem)
	{
		boolean test = false;
		
		for(int i = 0; i < shoppingList.size(); i++)
		{
			if(shoppingItem.contains(shoppingList.get(i)))
			{
				test = true;
			}
		}
		return test;
	}
	//Checks movies for their titles
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	//Checks movies for their Genres
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}
	//Tests if the user types quit
	public boolean quitChecker(String exitString)
	{
		if(exitString == null)
		{
			return false;
		}
		if(exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}
	//Prevents simple mashing of the keyboard
	public boolean keyboardMashChecker(String sample)
	{
		String [] mash = {"sdf","SDF","dfg","cvb",",./","kjh","DFG","CVB","KJH"};
		
		
		for(String letter : mash)
		{
			if(sample.contains(letter))
			{
				return true;
			}
		}
		return false;
	}
	//toString
	public String toString()
	{
		return "";
	}
	//Getters/////////////////////////
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
	//Setters///////////////////////////
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
	
	
}
