package com.example.app1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    public void calculate(View view) {
    	
    	//Retrieve input and bases
    	EditText usersInput = (EditText) findViewById(R.id.editText1);
    	String input1 = usersInput.getText().toString();
    	int user1Int = Integer.parseInt(input1);
    	
    	Spinner firstBase = (Spinner) findViewById(R.id.spinner1);    	
    	String base1 = firstBase.getSelectedItem().toString();
    	int base1Int = Integer.parseInt(base1);
    	
    	Spinner secondBase = (Spinner) findViewById(R.id.spinner2);
    	String base2 = secondBase.getSelectedItem().toString();
    	int base2Int = Integer.parseInt(base2);
    	
    	
    	String binaryConversion = "";
    	
    	
    	//BaseConversions 10 to other
    	if(base1Int == 10) {
    		
    		if(base2Int == 2) {
    			binaryConversion = base10to2(user1Int);
    		}
    		if(base2Int == 8) {
    			binaryConversion = base10to8(user1Int);
    		}
    		if(base2Int == 16) {
    			binaryConversion = base10to16(user1Int);
    		}
	    	
    	}
    	
    	//Display output
    	TextView answer = (TextView) findViewById(R.id.textView1);
    	//answer.setText("Input: " + user1Int + " Base 1: " + base1 + " Base 2: " + base2);
    	answer.setText("Base " + base1 + " to " + base2 +  " Conversion: " + binaryConversion);
    	
    }
    
    public static int base2to10(int input) {
		String usrInput = String.valueOf(input);
		int counter = usrInput.length()-1;
		int increment = 0;
		int answer = 0;
		while(counter >= 0) {
			if(usrInput.charAt(increment) =='1'){
				answer+= Math.pow(2,counter);
			}
			counter--;
			increment++;
        }
		return answer;
	}
	
	public static String base2to8(int input) {
        String answer = "";
		answer = base10to8((base2to10(input)));
		return answer;
	}
	
	public static String base2to16(int input) {
		String answer = "";
		answer = base10to16((base2to10(input)));
		return answer;
	}	
	
	public static String base8to2(int input) {
		String answer = "";
		
		return answer;
	}
	
	public static int base8to10(int input) {
		String usrInput = String.valueOf(input);
		int counter = usrInput.length()-1;
		int increment = 0;
		int answer = 0;
		while(counter >= 0) {
			if(usrInput.charAt(increment) =='1'){
				answer+= Math.pow(8,counter);
			}
			counter--;
			increment++;
        }
		return answer;
	}
	
	public static String base8to16(int input) {
		String answer = "";
		return answer;
	}

	public static String base10to2(int input) {
		String binaryConversion = "";
		while(input != 0) {
            binaryConversion = (input % 2) + binaryConversion;
            input /= 2;
        }
		return binaryConversion;
	}
	
	public static String base10to8(int input) {
		String binaryConversion = "";
		while(input != 0) {
            binaryConversion = (input % 8) + binaryConversion;
            input /= 8;
        }
		return binaryConversion;
	}
	
	public static String base10to16(int input) {
		String binaryConversion = "";
		while(input != 0) {
			
			if((input % 16) <= 9)
				binaryConversion = (input % 16) + binaryConversion;
			else {
				switch(input % 16) {
					case 10:
						binaryConversion = "A" + binaryConversion;
						break;
					case 11:
						binaryConversion = "B" + binaryConversion;
						break;
					case 12:
						binaryConversion = "C" + binaryConversion;
						break;
					case 13:
						binaryConversion = "D" + binaryConversion;
						break;
					case 14:
						binaryConversion = "E" + binaryConversion;
						break;
					case 15:
						binaryConversion = "F" + binaryConversion;
						break;
					default:
						break;
				}
				
			}
	        input /= 16;
	    }
		return binaryConversion;
	}
	
	public static String base16to2(int input) {
		String answer = "";
		return answer;
	}
	public static String base16to8(int input) {
		String answer = "";
		return answer;
	}
	public static String base16to10(int input) {
		String answer = "";
		return answer;
	}
}
