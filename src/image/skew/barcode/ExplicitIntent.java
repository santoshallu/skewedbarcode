package image.skew.barcode;

/*
 * ********************************************
 * 
 * MainLauncherAct.java - main activity of
 * ExplicitIntentsApp02 app. Shows how to create an
 * explicit intent and add a key-value pair to it.
 * MainLauncherAct specifies to ImageDisplayerAct02 which
 * image to display.
 * 
 * Bugs to vladimir dot kulyukin at gmail dot com
 * ********************************************
 */

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class ExplicitIntent extends Activity {

	protected Button mBtnDisplay = null;
    protected Button mBtnDisplay2 = null;
    protected EditText mEdit = null;
	protected Activity mThisAct = null;
	protected Resources mRes = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skew_bar_code);
        mBtnDisplay = (Button) this.findViewById(R.id.btn_display);
        mThisAct = this;
        mRes = getResources();
        mEdit   = (EditText)findViewById(R.id.mEdtTxt);
       
        mBtnDisplay.setOnClickListener(
        		new OnClickListener() {

					@Override
					public void onClick(View v) {
						// 1. Create an explicit intent
						Intent i = new Intent(mThisAct, SkewBarCodeActivity.class);
						String input= mEdit.getText().toString();
						int id=Integer.parseInt(input);
						// 3. Put key-value pair into the intent.
						i.putExtra(mRes.getString(R.string.img_id_key), id );
						// 4. Toast which image is requested.
						// 5. Request Android to run it.
						startActivity(i);
					}	
        		}
        );
        
        
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.skew_bar_code, menu);
        return true;
    }
}
