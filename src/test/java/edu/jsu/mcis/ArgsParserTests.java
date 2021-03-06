package edu.jsu.mcis;
import org.junit.*;
import static org.junit.Assert.*;
public class ArgsParserTests{
	private ArgsParser ap;

	@Before
	public void setup()
	{
		ap = new ArgsParser();		
	}
	
	@Test 
	public void checkArgumentCreation()
	{
		ap.addArgument("length","the length of the box");
		ap.addArgument("width","the width of the box");
		ap.addArgument("heigth","the heigth of the box");
		assertEquals("", ap.getStringValue("length"));
		assertEquals("", ap.getStringValue("width"));
		assertEquals("", ap.getStringValue("heigth"));		
	}
	@Test
	public void checkArgumentValues()
	{String[] args = new String[] {"7","5","2"};
	ap.addArgument("length","the length of the box");
		ap.addArgument("width","the width of the box");
		ap.addArgument("heigth","the heigth of the box");
		ap.parseValues(args);
		assertEquals("7", ap.getStringValue("length"));
		assertEquals("5", ap.getStringValue("width"));
		assertEquals("2", ap.getStringValue("heigth"));
		
	}
	
	@Test   
	public void checkArgumentDescription(){   
 		ap.addArgument("length","the length of the box");  
		ap.addArgument("width","the width of the box");  
		ap.addArgument("heigth","the heigth of the box");  
 		assertEquals("the length of the box", ap.getDescription("length"));  
 		assertEquals("the width of the box", ap.getDescription("width"));  
 		assertEquals("the heigth of the box", ap.getDescription("heigth"));  
 	  
	}  

	
	@Test
	public void checkIfDashHPrintsTheDescriptions()
	{
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addArgument("length","the length of the box");
		ap.addArgument("width","the width of the box");
		ap.addArgument("heigth","the heigth of the box");
		
		assertEquals("usage: java VolumeCalculator length width heigth \nCalculate the volume of a box\npositional arguments:\nlength the length of the box\n width the width of the box\n heigth the heigth of the box\n ",
					 ap.getHelpMessage());
		
		
		
	}
	
	@Test
	public void parseStringargsToDoubleArgs(){
		String[] args = new String[] {"7","5","2"};
		ap.addArgument("length","the length of the box");
		ap.addArgument("width","the width of the box");
		ap.addArgument("heigth","the heigth of the box");
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.parseValues(args);
		assertEquals(7,ap.getDoubleValue("length"),.1);
		assertEquals(5,ap.getDoubleValue("width"),.1);
		assertEquals(2,ap.getDoubleValue("heigth"),.1);
	}
	@Test 
	public void forceNumberFormatException()
	{   String[] args = new String[] {"7","something","2"};
		ap.addArgument("length","the length of the box");
		ap.addArgument("width","the width of the box");
		ap.addArgument("heigth","the heigth of the box");
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.parseValues(args);
		assertEquals("usage: java VolumeCalculator length width heigth \nVolumecalculator.java: error: argument width invalid double value: something",ap.errorMessage);
		
	}
	
}
