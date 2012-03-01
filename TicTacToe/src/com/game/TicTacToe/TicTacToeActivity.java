package com.game.TicTacToe;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TicTacToeActivity extends Activity {
    /** Called when the activity is first created. */
    
	public int mov=1,win=1;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }
    
   public void move(View v)
    {
    	 final View z=v; 
    	 EditText e = ((EditText)z);
    	 TextView t = (TextView) findViewById(R.id.text1);
    	 if(e.getText().toString().equals("O")||e.getText().toString().equals("X"))
    		 return;
    	if(mov==1)
    	{	
    		
        		
    		e.setText("X");
    		t.setText("Player 2 ---> O");
    		mov=2;
    	}
    	else
    	{
    		
    		e.setText("O");
    		t.setText("Player 1 ---> X");
    		mov=1;
    	}
    	
    	if(check())
    		display();
    }
   
   public boolean check()
   {
	   
	   int rx=0,ro=0,c=0;
	    //ROWCHECK
	 
	      for(int i=0;i<3;i++)
	      {
	    	  rx=0;ro=0;
	    	  for(int j=0;j<3;j++)
	    	  {
	    		  EditText e = (EditText) findViewById(3*i+j+2131099650);
	    		  if(e.getText().toString().equals("X"))
	    		  { rx++; c++;}
	    		  if(e.getText().toString().equals("O"))
	    		  { ro++; c++;}  
	    	  }
	    	  if(rx==3||ro==3)
	    		  break;
	      }
	      if(rx==3)
	      {
	    	   win=1;
	    	   return true;
	      }
	      if(ro==3)
	      {
	    	  win=2;
	    	  return true;
	      }
	      int cx=0,co=0;
	      //COLUMN CHECK
	      for(int i=0;i<3;i++)
	      {
	    	  cx=0;co=0;
	    	  for(int j=0;j<3;j++)
	    	  {
	    		  EditText e = (EditText) findViewById(3*j+i+2131099650);
	    		  if(e.getText().toString().equals("X"))
	    			  cx++;
	    		  if(e.getText().toString().equals("O"))
	    			  co++;
	    		  
	    	  }
	    	  if(cx==3||co==3)
	    		  break;
	      }
	      if(cx==3)
	      {
	    	   win=1;
	    	   return true;
	      }
	      if(co==3)
	      {
	    	  win=2;
	    	  return true;
	      }
	      
	      // Diagonal 1 Checking
	          int d1x=0,d1o=0;
	            for(int i=0;i<3;i++)
	            {
	            	for(int j=0;j<3;j++)
	            	{
	            		if(i==j)
	            		{
	            			EditText e = (EditText) findViewById(3*i+j+2131099650);
	            			if(e.getText().toString().equals("X"))
	      	    			  d1x++;
	      	    		    if(e.getText().toString().equals("O"))
	      	    			  d1o++;
	            		}
	            				
	            	}
	            	if(d1x==3||d1o==3)
	  	    		  break;
	            }
	            if(d1x==3)
	  	      {
	  	    	   win=1;
	  	    	   return true;
	  	      }
	  	      if(d1o==3)
	  	      {
	  	    	  win=2;
	  	    	  return true;
	  	      }
	  	      
	  	 // Diagonal 2 Checking
	          int d2x=0,d2o=0;
	            for(int i=0;i<3;i++)
	            {
	            	for(int j=0;j<3;j++)
	            	{
	            		if(i+j==2)
	            		{
	            			EditText e = (EditText) findViewById(3*i+j+2131099650);
	            			if(e.getText().toString().equals("X"))
	      	    			  d2x++;
	      	    		    if(e.getText().toString().equals("O"))
	      	    			  d2o++;
	            		}
	            				
	            	}
	            	if(d2x==3||d2o==3)
	  	    		  break;
	            }
	            if(d2x==3)
	  	      {
	  	    	   win=1;
	  	    	   return true;
	  	      }
	  	      if(d2o==3)
	  	      {
	  	    	  win=2;
	  	    	  return true;
	  	      }
	  	      if(c==9)
	  	      {
	  	    	  win=0;
	  	    	  return true;
	  	      }
	      return false;
   }
	   
	 public void display()
	 {
		 
		 
		 AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
			  
		 
		 if(win==1)
			 builder.setMessage("Player 1 Has WON !!");
		 else if(win==2)
			 builder.setMessage("Player 2 Has WON !!");
		 else
			 builder.setMessage("Game Draw !!");
		
		 builder.setPositiveButton("Play again",new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int whichButton) {
            	 
            	 for(int i=0;i<9;i++)
            	 {
            		  EditText e = (EditText) findViewById(2131099650+i);
            		  e.setText(""); 
                      
            	 }
            	 mov=1;
                 setContentView(R.layout.main);
             }
         });
		 builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int whichButton) {
            	 
            	 	  finish();
                      System.exit(0);
            	 
            	
             }
         });
		 
		 AlertDialog dialog = builder.show();

		
		TextView messageView = (TextView)dialog.findViewById(android.R.id.message);
		 messageView.setGravity(Gravity.CENTER);
		 
	/*	 final NumberSelectDialog numberSelectDialog ;
		 numberSelectDialog = new NumberSelectDialog(this);
	        //setting OnDismissListener
	        numberSelectDialog.setOnDismissListener(new OnDismissListener() {

	            public void onDismiss(DialogInterface dialInterface) {
	            	
	            	
	            }	
	            });
	        numberSelectDialog.show();*/
	            	  
	 }
	   
	   
	 
	   
   
}