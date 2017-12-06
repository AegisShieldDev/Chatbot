package chat.model;

import java.util.List;
import java.time.LocalDate;
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
		this.content = "content";
		this.intro = "I am a chatbot to talk to! I can talk about TOONS of things.";
		this.currentTime = LocalTime.now();
		this.topics = new String[7];
		this.verbs = new String[4];
		this.followUps = new String[5];
		
		buildFollowUps();
		buildVerbs();
		buildShoppingList();
		buildQuestions();
		buildTopics();
		buildCuteAnimals();
		buildMovieList();
	}
	
	/**
	 * Builds the list of followUps
	 */
	private void buildFollowUps()
	{
		followUps[0] = "One";
		followUps[1] = "Two";
		followUps[2] = "Three";
		followUps[3] = "Four";
		followUps[4] = "Five";
	}
	
	/**
	 * Builds the list of movies
	 */
	private void buildMovieList()
	{
		Movie TwoTowers 		= new Movie("Two Towers", 		"Adventure", 	"Good", "This is a very popular movie", 	200, LocalDate.now(), 5.0);
		Movie Ironman 		= new Movie("Ironman",			"Action", 		"Good", "This is a very good movie", 	200, LocalDate.now(), 5.0);
		Movie Avengers 		= new Movie("Avengers", 			"Action", 		"Good", "This is a very popular movie", 	200, LocalDate.now(), 5.0);
		Movie Spiderman 		= new Movie("Spiderman",			"Action", 		"Good", "This is a very good movie", 	200, LocalDate.now(), 5.0);
		Movie Thor 			= new Movie("Thor", 				"Action", 		"Good", "This is a very funny movie", 	200, LocalDate.now(), 5.0);
		Movie Pokemon 		= new Movie("Pokemon", 			"Anime", 		"Good", "This is a very cute movie", 	200, LocalDate.now(), 5.0);
		Movie HiddenFigures 	= new Movie("Hidden Figures", 	"Historical",	"Good", "This is a very good movie,", 	200, LocalDate.now(), 5.0);
		movieList.add(TwoTowers);
		movieList.add(Ironman);
		movieList.add(Avengers);
		movieList.add(Pokemon);
		movieList.add(Thor);
		movieList.add(Spiderman);
		movieList.add(HiddenFigures);
	}
	
	/**
	 * Builds the list of topics
	 */
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
	
	/**
	 * Builds the shopping list
	 */
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("candy");
		shoppingList.add("fruit");
		shoppingList.add("oreos");
		shoppingList.add("cereal");
		shoppingList.add("chips");
		shoppingList.add("salsa");
		shoppingList.add("gum");
		shoppingList.add("pasta");
	}
	
	/**
	 * Builds the list of cute animals
	 */
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("pupper");
	}
	
	/*
	 * Builds the list of verbs
	 */
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	/**
	 * Builds the list of questions
	 */
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

	/**
	 * ProcessConversation is called by the controller when input is received to create a response to the users input
	 * @param The user inputed response
	 * @return the chatbot's response after processing the conversation
	 */
	public String processConversation(String input)
	{
		String chatboxResponse = "";
		chatboxResponse += "You said:" + "\n"  + input + "\n";
		
		chatboxResponse += BuildChatbotResponse();
		
		return chatboxResponse;
	}

	/**
	 * Builds the response of the chatbot for use in processConversation
	 * @return The chatbot's response statement
	 */
	private String BuildChatbotResponse()
	{
		String response = "I ";
		int random = (int)(Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int)(Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int)(Math.random() * questions.length);
		response += " " + questions[random];
		
		random = (int)(Math.random() * 2);
		
		if(random % 2 == 0)
		{
			random = (int)(Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + "is a great movie!" + "\n";
		}
		
		if(random % 2 == 0)
		{
			random = (int)(Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + "is a great movie!" + "\n";
		}
		
		int followup = (int)(Math.random() * 5);
				
		switch(followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 1:
			response += followUps[2] + "\n";
		default: 
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		
		return response;
	}
	
	/**
	 * Checks the length of the string input
	 * @param input
	 * @return true/false
	 */
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
	
	/**
	 * Checks for valid html tags in the input
	 * @param input
	 * @return true/false
	 */
	public boolean htmlTagChecker(String input)
	{
		String test = "TEST";
		String test2 = "TEST2";
		
		
		if(input.length() <= 2) 
		{
			return false;
		}
		if(input.toLowerCase().contains("href"))
		{
			if(input.toLowerCase().contains("="))
			{
				return true;
			}
			return false;
		}
		if(input.contains("<") && input.contains(">") && input.contains("/"))
		{
			test = input.substring(input.indexOf("<"), input.indexOf(">")+1);
			test2 = input.substring(input.indexOf("</"), input.indexOf(">", input.indexOf(">")+1));
			
			
			test = test.substring(1,test.length()-1);
			test2 = test2.substring(2, test2.length()-1);
			
			
			if(test.toLowerCase().contains(test2.toLowerCase()))
			{
				return true;
			}
		}
		if(input.toLowerCase().contains("<p>") || input.toLowerCase().contains("<br>"))
		{
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Checks for a valid username
	 * @param input
	 * @return boolean
	 */
	public boolean userNameChecker(String input)
	{
		if(input == null)
		{
			return false;
		}
		else if(input.length() < 2)
		{
			return false;
		}
		else if(input.charAt(0) == '@' && !input.substring(1, input.length()).contains("@"))
		{
			return true;
		}
		
		
		return false;
	}
	
	/**
	 * Checks the content, making sure its valid
	 * @param contentCheck
	 * @return boolean
	 */
	public boolean contentChecker(String contentCheck)
	{
		if(content.length() < 6)
		{
			return false;
		}
		if(contentCheck.toLowerCase().contains(content.toLowerCase()))
		{
			return true;
		}
		return false;
		
	}

	/**
	 * Checks the cute animal memes
	 * @param input
	 * @return boolean
	 */
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

	/**
	 * Checks the shopping list
	 * @param shoppingItem
	 * @return boolean
	 */
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

	/**
	 * Checks the title of movies
	 * @param title
	 * @return boolean
	 */
	public boolean movieTitleChecker(String title)
	{	
		if(title == null)
		{
			return false;
		}
		else if(title.equals(""))
		{
			return false;
		}
		else 
		{
			return true;
		}
	}

	/**
	 * Checks movie genres
	 * @param genre
	 * @return boolean
	 */
	public boolean movieGenreChecker(String genre)
	{
		if(genre == null)
		{
			return false;
		}
		else if(genre.equals(""))
		{
			return false;
		}
		else 
		{
			return true;
		}
	}

	/**
	 * Looks for the input of quit
	 * @param exitString
	 * @return boolean
	 */
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

	/**
	 * Prevents simple mashing of the keyboard
	 * @param sample
	 * @return boolean
	 */
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

	/**
	 * Overrides toString
	 */
	public String toString()
	{
		return "";
	}

	//Getters/////////////////////////

	/**
	 * Getter for movie list
	 * @return movie list
	 */
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	/**
	 * Getter for shopping list
	 * @return shoppingList
	 */
	public List<String> getShoppingList()
	{
		return shoppingList;
	}

	/**
	 * Getter for cute animal memes
	 * @return cuteAnimalMemes
	 */
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	/**
	 * Getter for Questions
	 * @return questions
	 */
	public String [] getQuestions()
	{
		return questions;
	}

	/**
	 * Getter for verbs
	 * @return verbs
	 */
	public String[] getVerbs()
	{
		return verbs;
	}

	/**
	 * Getter for Topics
	 * @return topics
	 */
	public String[] getTopics()
	{
		return topics;
	}

	/**
	 * Getter for Follow ups
	 * @return followUps
	 */
	public String[] getFollowUps()
	{
		return followUps;
	}

	/**
	 * Getter for username
	 * @return username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * Getter for content
	 * @return content
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * Getter for intro
	 * @return intro
	 */
	public String getIntro()
	{
		return intro;
	}

	/**
	 * Getter for the current time
	 * @return currentTime
	 */
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}

	//Setters///////////////////////////
	
	/**
	 * Setter for the username
	 * @param username
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	/**
	 * Setter for content
	 * @param content
	 */
	public void setContent(String content)
	{
		if(content != null)
		{
			this.content = content;
		}
		else
		{
			this.content = "";
		}
	}
	
	
}
