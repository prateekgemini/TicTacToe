package com.game.TicTacToe;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

/**
 * The dialog allows selection of numbers 1 - 9 and Unset value.
 *
 * @author Pavel Novák
 */

public class NumberSelectDialog extends Dialog{
	
	TicTacToeActivity t = new TicTacToeActivity();

	public NumberSelectDialog(Context context) {
        super(context);
    TextView tv = new TextView(this.getContext());
   //   tv = (TextView) findViewById(R.id.textView1);
       // TextView tv = new TextView(this.getContext());
          if(t.win==1)
        	  tv.setText("PLAYER 1 HAS WON");
         else
        	  tv.setText("PLAYER 2 HAS WON");
         setContentView(tv);
	}
	
    
}
