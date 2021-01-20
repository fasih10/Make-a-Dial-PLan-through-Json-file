package json;



import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File; 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSONFile {
public static void main(String[]args) throws IOException, ParseException
{
	JSONParser jsonparser=new JSONParser(); 
    FileReader reader=new FileReader("/home/mm/JsonFiles/Questions.json");
     Object obj=jsonparser.parse(reader);
     JSONObject quejsonobj=(JSONObject)obj;
    JSONArray array=(JSONArray)quejsonobj.get("questions");
    for(int i=0;i<array.size();i++)
    {
    	JSONObject question=(JSONObject)array.get(i);
    	String number=(String) question.get("number");
    	String audio_file_id=(String) question.get("audio_file_id");
    	String valid_option=(String) question.get("valid_options");
    	String question_id=(String) question.get("question_id");
    	
    	
    	System.out.println("Question number is"+number);
    	System.out.println("Question audio file id is"+audio_file_id);
    	System.out.println("Question valid option is"+valid_option);
    	System.out.println("Question id is"+question_id);
    	
    	
    	
    }
    
    JSONObject question=(JSONObject)array.get(0);
	String number1=(String) question.get("number");
	String audio_file_id1=(String) question.get("audio_file_id");
	String valid_option1=(String) question.get("valid_options");
	String question_id1=(String) question.get("question_id");
    
	
	question=(JSONObject)array.get(1);
	String number2=(String) question.get("number");
	String audio_file_id2=(String) question.get("audio_file_id");
	String valid_option2=(String) question.get("valid_options");
	String question_id2=(String) question.get("question_id");
	
	
	 question=(JSONObject)array.get(2);
	String number3=(String) question.get("number");
	String audio_file_id3=(String) question.get("audio_file_id");
	String valid_option3=(String) question.get("valid_options");
	String question_id3=(String) question.get("question_id");
	
int vopt1=Integer.parseInt(valid_option1);
int vopt2=Integer.parseInt(valid_option2);
int vopt3=Integer.parseInt(valid_option3);

String [] QuestionNumbers= {number1,number2,number3};
int [] Validopt= {vopt1,vopt2,vopt3};	
String [] aid= {audio_file_id1,audio_file_id2,audio_file_id3};	
String [] qid= {question_id1,question_id2,question_id3,"2021"};


    try {
    	File myObj = new File("/etc/asterisk/extensions_Task.conf");
        if (myObj.createNewFile()) {
          System.out.println("File created: " + myObj.getName());
        } else {
          System.out.println("File already exists.");
        }
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    
    try {
        FileWriter myWriter = new FileWriter("/etc/asterisk/extensions_Task.conf");
        myWriter.write("[default]\n"
        		+"\n"
        		+"exten => 2233,1,Goto(Questions_INIT,s,1)\n"
        		+"[Questions_INIT]\n"+"exten => s,1,Set(PROMPTS=/home/task)\n");
        for(int i=1;i<=QuestionNumbers.length;i++)
        {
      myWriter.write("same,n,Set(QUESTION_ID_"+i+"="+qid[i-1]+")\n"
        		+"same,n,Set(VLD_OPTS_"+i+"="+Validopt[i-1]+")\n"
        		+"same,n,Set(AUD_FILE_"+i+"="+aid[i-1]+")\n"
        );		
        
        }		
    }	
     catch (IOException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
     }
    
    try {
        FileWriter myWriter = new FileWriter("/etc/asterisk/extensions.conf");
        myWriter.write("include \"extensions_Task.conf\"");
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
}

	
}
