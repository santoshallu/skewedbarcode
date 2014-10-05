package image.skew.barcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;


import imageprocessing.bitmap.BitMap;
import imageprocessing.extensions.BitMapExtensions;


public class SkewBarCodeActivity extends Activity implements
TextToSpeech.OnInitListener {
	
	 final static BitmapFactory.Options BITMAP_OPTIONS = new BitmapFactory.Options();
	 final static Bitmap.Config PREFERRED_CONFIG = Bitmap.Config.ARGB_8888;
	 protected ImageView imageview= null;
	 private TextToSpeech tts;
     String output = "";
     String finaloutput = "";
     int linebreak=0;
     int whitepixelcounter=0;
     int widthcounter0=0;
     int widthcounter1=0;
     int widthpixel=0;
     int counter1=1;
     int counter2=1;
     int decoderfinal=0;
     int firstpatterncounter=0;
     List<Integer> myList=new ArrayList<Integer>();
     List<String> widthbar=new ArrayList<String>();
     List<Integer> myList2=new ArrayList<Integer>();
     List<String> myList3=new ArrayList<String>();
     List<String> finalbarcode=new ArrayList<String>();
     List<Integer> firstpatternfix=new ArrayList<Integer>();
     int finalerrocounter=0;
    int midnotfoundstart =0;
    int midnotfoundend =0;
     int groupcount=0;
     int barwidth = 0;
     int num2=1;
     String stringpattern ="";
     int z=0;
     
	 static {
		 BITMAP_OPTIONS.inPreferredConfig = PREFERRED_CONFIG;
		 BITMAP_OPTIONS.inJustDecodeBounds= true;
		 BITMAP_OPTIONS.inTempStorage = new byte[16*1024];

	 }
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detected_barcode);
		Bitmap bm = null;
		BitMap bp = null;
		// 1. Get the intent
		imageview=(ImageView)this.findViewById(R.id.img_view_01);
		Intent i = this.getIntent();
		tts = new TextToSpeech(this, this);
		
		// 2. Check to see if it contains an integer keyed on R.string.img_id_key.
		// default to 0 if it does not.
		int img_num = i.getIntExtra(getResources().getString(R.string.img_id_key), 0);
		num2= i.getIntExtra(getResources().getString(R.string.img_id_key), 0);
		if(img_num > 0) {
			switch(img_num) {
			case 1:
			Bitmap img1 = BitmapFactory.decodeResource(getResources(),R.drawable.img_01);
			  
			Localfunc(img1);
			img1.recycle(); 
			    break;
			case 2:
			Bitmap img2 = BitmapFactory.decodeResource(getResources(),R.drawable.img_02);
			
			Localfunc(img2);
			img2.recycle(); 
			    break;
			case 3:
			Bitmap img3 = BitmapFactory.decodeResource(getResources(),R.drawable.img_03);
			
			Localfunc(img3);
			img3.recycle();
			    break;
		
			case 4:
			Bitmap img4 = BitmapFactory.decodeResource(getResources(),R.drawable.img_04);
			
			Localfunc(img4);
			img4.recycle();
			    break;
            case 5:
    			Bitmap img5 = BitmapFactory.decodeResource(getResources(),R.drawable.img_05);
    			
    			Localfunc(img5);
    			img5.recycle();
    			    break;
    		    case 6:
    			Bitmap img6 = BitmapFactory.decodeResource(getResources(),R.drawable.img_06);
    			
    			Localfunc(img6);
    			img6.recycle();
    			    break;
    				case 7:
    			Bitmap img7 = BitmapFactory.decodeResource(getResources(),R.drawable.img_07);
    			
    			Localfunc(img7);
    			img7.recycle();
    			    break;
    				case 8:
    			Bitmap img8 = BitmapFactory.decodeResource(getResources(),R.drawable.img_08);
    			
    			Localfunc(img8);
    			img8.recycle();
    			    break;
    				case 9:
    			Bitmap img9 = BitmapFactory.decodeResource(getResources(),R.drawable.img_09);
    			
    			Localfunc(img9);
    			img9.recycle();
    			    break;
    				case 10:
    			Bitmap img10 = BitmapFactory.decodeResource(getResources(),R.drawable.img_10);
    			
    			Localfunc(img10);
    			img10.recycle();
    			    break;
    				case 11:
    			Bitmap img11 = BitmapFactory.decodeResource(getResources(),R.drawable.img_11);
    			
    			Localfunc(img11);
    			img11.recycle();
    			    break;
    				case 12:
    			Bitmap img12 = BitmapFactory.decodeResource(getResources(),R.drawable.img_12);
    			
    			Localfunc(img12);
    			img12.recycle();
    			    break;
    				case 13:
    			Bitmap img13 = BitmapFactory.decodeResource(getResources(),R.drawable.img_13);
    			
    			Localfunc(img13);
    			img13.recycle();
    			    break;
    				case 14:
    			Bitmap img14 = BitmapFactory.decodeResource(getResources(),R.drawable.img_14);
    			
    			Localfunc(img14);
    			img14.recycle();
    			    break;
    				case 15:
    			Bitmap img15 = BitmapFactory.decodeResource(getResources(),R.drawable.img_15);
    			
    			Localfunc(img15);
    			img15.recycle();
    			    break;
    				case 16:
    			Bitmap img16 = BitmapFactory.decodeResource(getResources(),R.drawable.img_16);
    			
    			Localfunc(img16);
    			img16.recycle();
    			    break;
    				case 17:
    			Bitmap img17 = BitmapFactory.decodeResource(getResources(),R.drawable.img_17);
    			
    			Localfunc(img17);
    			img17.recycle();
    			    break;
    				case 18:
    			Bitmap img18 = BitmapFactory.decodeResource(getResources(),R.drawable.img_18);
    			
    			Localfunc(img18);
    			img18.recycle();
    			    break;
    				case 19:
    			Bitmap img19 = BitmapFactory.decodeResource(getResources(),R.drawable.img_19);
    			
    			Localfunc(img19);
    			img19.recycle();
    			    break;
    				case 20:
    			Bitmap img20 = BitmapFactory.decodeResource(getResources(),R.drawable.img_20);
    			
    			Localfunc(img20);
    			img20.recycle();
    			    break;
    				case 21:
    			Bitmap img21 = BitmapFactory.decodeResource(getResources(),R.drawable.img_21);
    			
    			Localfunc(img21);
    			img21.recycle();
    			    break;
    				case 22:
    			Bitmap img22 = BitmapFactory.decodeResource(getResources(),R.drawable.img_22);
    			
    			Localfunc(img22);
    			img22.recycle();
    			    break;
    				case 23:
    			Bitmap img23 = BitmapFactory.decodeResource(getResources(),R.drawable.img_23);
    			
    			Localfunc(img23);
    			img23.recycle();
    			    break;
    				case 24:
    			Bitmap img24 = BitmapFactory.decodeResource(getResources(),R.drawable.img_24);
    			
    			Localfunc(img24);
    			img24.recycle();
    			    break;
    				case 25:
    			Bitmap img25 = BitmapFactory.decodeResource(getResources(),R.drawable.img_25);
    			
    			Localfunc(img25);
    			img25.recycle();
    			    break;
    				case 26:
    			Bitmap img26 = BitmapFactory.decodeResource(getResources(),R.drawable.img_26);
    			
    			Localfunc(img26);
    			img26.recycle();
    			    break;
    				case 27:
    			Bitmap img27 = BitmapFactory.decodeResource(getResources(),R.drawable.img_27);
    			
    			Localfunc(img27);
    			img27.recycle();
    			    break;
    				case 28:
    			Bitmap img28 = BitmapFactory.decodeResource(getResources(),R.drawable.img_28);
    			
    			Localfunc(img28);
    			img28.recycle();
    			    break;
    				case 29:
    			Bitmap img29= BitmapFactory.decodeResource(getResources(),R.drawable.img_29);
    			
    			Localfunc(img29);
    			img29.recycle();
    			    break;
    				case 30:
    			Bitmap img30 = BitmapFactory.decodeResource(getResources(),R.drawable.img_30);
    			
    			Localfunc(img30);
    			img30.recycle();
    			    break;
    				case 31:
    					Bitmap img31 = BitmapFactory.decodeResource(getResources(),R.drawable.img_31);
    					
    					Localfunc(img31);
    					img31.recycle();
    					    break;
    						case 32:
    					Bitmap img32 = BitmapFactory.decodeResource(getResources(),R.drawable.img_32);
    					
    					Localfunc(img32);
    					img32.recycle();
    					    break;
    						case 33:
    					Bitmap img33 = BitmapFactory.decodeResource(getResources(),R.drawable.img_33);
    					
    					Localfunc(img33);
    					img33.recycle();
    					    break;
    						case 34:
    					Bitmap img34 = BitmapFactory.decodeResource(getResources(),R.drawable.img_34);
    					
    					Localfunc(img34);
    					img34.recycle();
    					    break;
    						case 35:
    					Bitmap img35 = BitmapFactory.decodeResource(getResources(),R.drawable.img_35);
    					
    					Localfunc(img35);
    					img35.recycle();
    					    break;
    						case 36:
    					Bitmap img36 = BitmapFactory.decodeResource(getResources(),R.drawable.img_36);
    					
    					Localfunc(img36);
    					img36.recycle();
    					    break;
    						case 37:
    					Bitmap img37 = BitmapFactory.decodeResource(getResources(),R.drawable.img_37);
    					
    					Localfunc(img37);
    					img37.recycle();
    					    break;
    						case 38:
    	    					Bitmap img38 = BitmapFactory.decodeResource(getResources(),R.drawable.img_38);
    	    					
    	    					Localfunc(img38);
    	    					img38.recycle();
    	    					    break;

    						case 39:
    					Bitmap img39 = BitmapFactory.decodeResource(getResources(),R.drawable.img_39);
    					
    					Localfunc(img39);
    					img39.recycle();
    					    break;
    						case 40:
    					Bitmap img40 = BitmapFactory.decodeResource(getResources(),R.drawable.img_40);
    					
    					Localfunc(img40);
    					img40.recycle();
    					    break;
    						case 41:
    					Bitmap img41 = BitmapFactory.decodeResource(getResources(),R.drawable.img_41);
    					
    					Localfunc(img41);
    					img41.recycle();
    					    break;
    						case 42:
    					Bitmap img42 = BitmapFactory.decodeResource(getResources(),R.drawable.img_42);
    					
    					Localfunc(img42);
    					img42.recycle();
    					    break;
    						case 43:
    					Bitmap img43 = BitmapFactory.decodeResource(getResources(),R.drawable.img_43);
    					
    					Localfunc(img43);
    					img43.recycle();
    					    break;
    						case 44:
    					Bitmap img44 = BitmapFactory.decodeResource(getResources(),R.drawable.img_44);
    					
    					Localfunc(img44);
    					img44.recycle();
    					    break;
    						case 45:
    					Bitmap img45 = BitmapFactory.decodeResource(getResources(),R.drawable.img_45);
    					
    					Localfunc(img45);
    					img45.recycle();
    					    break;
    						case 46:
    					Bitmap img46 = BitmapFactory.decodeResource(getResources(),R.drawable.img_46);
    					
    					Localfunc(img46);
    					img46.recycle();
    					    break;
    						case 47:
    					Bitmap img47 = BitmapFactory.decodeResource(getResources(),R.drawable.img_47);
    					
    					Localfunc(img47);
    					img47.recycle();
    					    break;
    						case 48:
    					Bitmap img48 = BitmapFactory.decodeResource(getResources(),R.drawable.img_48);
    					
    					Localfunc(img48);
    					img48.recycle();
    					    break;
    						case 49:
    					Bitmap img49 = BitmapFactory.decodeResource(getResources(),R.drawable.img_49);
    					
    					Localfunc(img49);
    					img49.recycle();
    					    break;
    						case 50:
    					Bitmap img50 = BitmapFactory.decodeResource(getResources(),R.drawable.img_50);
    					
    					Localfunc(img50);
    					img50.recycle();
    					    break;
    						case 51:
    					Bitmap img51 = BitmapFactory.decodeResource(getResources(),R.drawable.img_51);
    					
    					Localfunc(img51);
    					img51.recycle();
    					    break;
    						case 52:
    					Bitmap img52 = BitmapFactory.decodeResource(getResources(),R.drawable.img_52);
    					
    					Localfunc(img52);
    					img52.recycle();
    					    break;
    						case 53:
    					Bitmap img53 = BitmapFactory.decodeResource(getResources(),R.drawable.img_53);
    					
    					Localfunc(img53);
    					img53.recycle();
    					    break;
    						case 54:
    					Bitmap img54 = BitmapFactory.decodeResource(getResources(),R.drawable.img_54);
    					
    					Localfunc(img54);
    					img54.recycle();
    					    break;
    						case 55:
    					Bitmap img55 = BitmapFactory.decodeResource(getResources(),R.drawable.img_55);
    					
    					Localfunc(img55);
    					img55.recycle();
    					    break;
    						case 56:
    					Bitmap img56 = BitmapFactory.decodeResource(getResources(),R.drawable.img_56);
    					
    					Localfunc(img56);
    					img56.recycle();
    					    break;
    						case 57:
    					Bitmap img57 = BitmapFactory.decodeResource(getResources(),R.drawable.img_57);
    					
    					Localfunc(img57);
    					img57.recycle();
    					    break;
    						case 58:
    					Bitmap img58 = BitmapFactory.decodeResource(getResources(),R.drawable.img_58);
    					
    					Localfunc(img58);
    					img58.recycle();
    					    break;
    						case 59:
    					Bitmap img59 = BitmapFactory.decodeResource(getResources(),R.drawable.img_59);
    					
    					Localfunc(img59);
    					img59.recycle();
    					    break;
    						case 60:
    					Bitmap img60 = BitmapFactory.decodeResource(getResources(),R.drawable.img_60);
    					
    					Localfunc(img60);
    					img60.recycle();
    					    break;
    						case 61:
    					Bitmap img61 = BitmapFactory.decodeResource(getResources(),R.drawable.img_61);
    					
    					Localfunc(img61);
    					img61.recycle();
    					    break;
    						case 62:
    					Bitmap img62 = BitmapFactory.decodeResource(getResources(),R.drawable.img_62);
    					
    					Localfunc(img62);
    					img62.recycle();
    					    break;
    						case 63:
    					Bitmap img63 = BitmapFactory.decodeResource(getResources(),R.drawable.img_63);
    					
    					Localfunc(img63);
    					img63.recycle();
    					    break;
    						case 64:
    					Bitmap img64 = BitmapFactory.decodeResource(getResources(),R.drawable.img_64);
    					
    					Localfunc(img64);
    					img64.recycle();
    					    break;
    						case 65:
    					Bitmap img65 = BitmapFactory.decodeResource(getResources(),R.drawable.img_65);
    					
    					Localfunc(img65);
    					img65.recycle();
    					    break;
    						case 66:
    					Bitmap img66 = BitmapFactory.decodeResource(getResources(),R.drawable.img_66);
    					
    					Localfunc(img66);
    					img66.recycle();
    					    break;
    						case 67:
    					Bitmap img67 = BitmapFactory.decodeResource(getResources(),R.drawable.img_67);
    					
    					Localfunc(img67);
    					img67.recycle();
    					    break;
    						case 68:
    					Bitmap img68 = BitmapFactory.decodeResource(getResources(),R.drawable.img_68);
    					
    					Localfunc(img68);
    					img68.recycle();
    					    break;  
    						case 69:
    	    					Bitmap img69 = BitmapFactory.decodeResource(getResources(),R.drawable.img_69);
    	    					
    	    					Localfunc(img69);
    	    					img69.recycle();
    	    					    break; 
    									case 70:
    	    					Bitmap img70 = BitmapFactory.decodeResource(getResources(),R.drawable.img_70);
    	    					
    	    					Localfunc(img70);
    	    					img70.recycle();
    	    					    break; 
    									case 71:
    	    					Bitmap img71 = BitmapFactory.decodeResource(getResources(),R.drawable.img_71);
    	    					
    	    					Localfunc(img71);
    	    					img71.recycle();
    	    					    break; 
    									case 72:
    	    					Bitmap img72 = BitmapFactory.decodeResource(getResources(),R.drawable.img_72);
    	    					
    	    					Localfunc(img72);
    	    					img72.recycle();
    	    					    break; 
    									case 73:
    				    					Bitmap img73 = BitmapFactory.decodeResource(getResources(),R.drawable.img_73);
    				    					
    				    					Localfunc(img73);
    				    					img73.recycle();
    				    					    break; 
    												case 74:
    				    					Bitmap img74 = BitmapFactory.decodeResource(getResources(),R.drawable.img_74);
    				    					
    				    					Localfunc(img74);
    				    					img74.recycle();
    				    					    break; 
    												case 75:
    				    					Bitmap img75 = BitmapFactory.decodeResource(getResources(),R.drawable.img_75);
    				    					
    				    					Localfunc(img75);
    				    					img75.recycle();
    				    					    break; 
    												case 76:
    				    					Bitmap img76 = BitmapFactory.decodeResource(getResources(),R.drawable.img_76);
    				    					
    				    					Localfunc(img76);
    				    					img76.recycle();
    				    					    break; 
    											case 77:
    				    					Bitmap img77 = BitmapFactory.decodeResource(getResources(),R.drawable.img_77);
    				    					
    				    					Localfunc(img77);
    				    					img77.recycle();
    				    					    break; 
    												case 78:
    				    					Bitmap img78 = BitmapFactory.decodeResource(getResources(),R.drawable.img_78);
    				    					
    				    					Localfunc(img78);
    				    					img78.recycle();
    				    					    break; 
    												case 79:
    				    					Bitmap img79 = BitmapFactory.decodeResource(getResources(),R.drawable.img_79);
    				    					
    				    					Localfunc(img79);
    				    					img79.recycle();
    				    					    break; 
    												case 80:
    				    					Bitmap img80 = BitmapFactory.decodeResource(getResources(),R.drawable.img_80);
    				    					
    				    					Localfunc(img80);
    				    					img80.recycle();
    				    					    break; 
    													case 81:
    				    					Bitmap img81 = BitmapFactory.decodeResource(getResources(),R.drawable.img_81);
    				    					
    				    					Localfunc(img81);
    				    					img81.recycle();
    				    					    break; 
    											case 82:
    				    					Bitmap img82 = BitmapFactory.decodeResource(getResources(),R.drawable.img_82);
    				    					
    				    					Localfunc(img82);
    				    					img82.recycle();
    				    					    break; 
    												case 83:
    				    					Bitmap img83 = BitmapFactory.decodeResource(getResources(),R.drawable.img_83);
    				    					
    				    					Localfunc(img83);
    				    					img83.recycle();
    				    					    break; 
    												case 84:
    				    					Bitmap img84 = BitmapFactory.decodeResource(getResources(),R.drawable.img_84);
    				    					
    				    					Localfunc(img84);
    				    					img84.recycle();
    				    					    break; 
    												case 85:
    							    					Bitmap img85 = BitmapFactory.decodeResource(getResources(),R.drawable.img_85);
    							    					
    							    					Localfunc(img85);
    							    					img85.recycle();
    							    					    break; 
    																case 86:
    							    					Bitmap img86 = BitmapFactory.decodeResource(getResources(),R.drawable.img_86);
    							    					
    							    					Localfunc(img86);
    							    					img86.recycle();
    							    					    break; 
    														case 87:
    							    					Bitmap img87 = BitmapFactory.decodeResource(getResources(),R.drawable.img_87);
    							    					
    							    					Localfunc(img87);
    							    					img87.recycle();
    							    					    break; 
    															case 88:
    							    					Bitmap img88 = BitmapFactory.decodeResource(getResources(),R.drawable.img_88);
    							    					
    							    					Localfunc(img88);
    							    					img88.recycle();
    							    					    break;  
    															case 89:
    							    					    Bitmap img89 = BitmapFactory.decodeResource(getResources(),R.drawable.img_89);
    							    				          
    							    			            Localfunc(img89);
    							    			            img89.recycle();
    							    			                break;
    							    			   case 90:
    							    			            Bitmap img90 = BitmapFactory.decodeResource(getResources(),R.drawable.img_90);
    							    			          
    							    			            Localfunc(img90);
    							    			            img90.recycle();
    							    			                break;
    							    			                case 91:
    							    			            Bitmap img91 = BitmapFactory.decodeResource(getResources(),R.drawable.img_91);
    							    			          
    							    			            Localfunc(img91);
    							    			            img91.recycle();
    							    			                break;
    							    			                case 92:
    							    			            Bitmap img92 = BitmapFactory.decodeResource(getResources(),R.drawable.img_92);
    							    			          
    							    			            Localfunc(img92);
    							    			            img92.recycle();
    							    			                break;
    							    			                case 93:
    							    			            Bitmap img93 = BitmapFactory.decodeResource(getResources(),R.drawable.img_93);
    							    			          
    							    			            Localfunc(img93);
    							    			            img93.recycle();
    							    			                break;
    							    			                case 94:
    							    			            Bitmap img94 = BitmapFactory.decodeResource(getResources(),R.drawable.img_94);
    							    			          
    							    			            Localfunc(img94);
    							    			            img94.recycle();
    							    			                break;
    							    			  
    							    			   case 95:
    							    			            Bitmap img95 = BitmapFactory.decodeResource(getResources(),R.drawable.img_95);
    							    			          
    							    			            Localfunc(img95);
    							    			            img95.recycle();
    							    			                break;
    							    			                case 96:
    							    			            Bitmap img96 = BitmapFactory.decodeResource(getResources(),R.drawable.img_96);
    							    			          
    							    			            Localfunc(img96);
    							    			            img96.recycle();
    							    			                break;
    							    			                case 97:
    							    			            Bitmap img97 = BitmapFactory.decodeResource(getResources(),R.drawable.img_97);
    							    			          
    							    			            Localfunc(img97);
    							    			            img97.recycle();
    							    			                break;
    							    			                case 98:
    							    			            Bitmap img98 = BitmapFactory.decodeResource(getResources(),R.drawable.img_98);
    							    			          
    							    			            Localfunc(img98);
    							    			            img98.recycle();
    							    			                break;
    							    			                case 99:
    							    			            Bitmap img99 = BitmapFactory.decodeResource(getResources(),R.drawable.img_99);
    							    			          
    							    			            Localfunc(img99);
    							    			            img99.recycle();
    							    			                break;
    							    			   case 100:
    							    			            Bitmap img100 = BitmapFactory.decodeResource(getResources(),R.drawable.img_100);
    							    			          
    							    			            Localfunc(img100);
    							    			            img100.recycle();
    							    			                break;
    							    			                case 101:
    							    			            Bitmap img101 = BitmapFactory.decodeResource(getResources(),R.drawable.img_101);
    							    			          
    							    			            Localfunc(img101);
    							    			            img101.recycle();
    							    			                break;
    							    			                case 102:
    							    			            Bitmap img102 = BitmapFactory.decodeResource(getResources(),R.drawable.img_102);
    							    			          
    							    			            Localfunc(img102);
    							    			            img102.recycle();
    							    			                break;
    							    			                case 103:
    							    			            Bitmap img103 = BitmapFactory.decodeResource(getResources(),R.drawable.img_103);
    							    			          
    							    			            Localfunc(img103);
    							    			            img103.recycle();
    							    			                break;
    							    			                case 104:
    							    			            Bitmap img104 = BitmapFactory.decodeResource(getResources(),R.drawable.img_104);
    							    			          
    							    			            Localfunc(img104);
    							    			            img104.recycle();
    							    			                break;
    												    
    							    			                case 105:
    							    			                    Bitmap img105 = BitmapFactory.decodeResource(getResources(),R.drawable.img_105);
    							    			                  
    							    			                    Localfunc(img105);
    							    			                    img105.recycle();
    							    			                        break;
    							    			                        case 106:
    							    			                    Bitmap img106 = BitmapFactory.decodeResource(getResources(),R.drawable.img_106);
    							    			                  
    							    			                    Localfunc(img106);
    							    			                    img106.recycle();
    							    			                        break;
    							    			                        case 107:
    							    			                    Bitmap img107 = BitmapFactory.decodeResource(getResources(),R.drawable.img_107);
    							    			                  
    							    			                    Localfunc(img107);
    							    			                    img107.recycle();
    							    			                        break;
    					    
			}
			}
  
	}
	public void Localfunc(Bitmap image) {
		
		 String[] decodervalues = new String[10];
	     decodervalues[0]="3211";
	     decodervalues[1]="2221";
	     decodervalues[2]="2122";
	     decodervalues[3]="1411";
	     decodervalues[4]="1132";
	     decodervalues[5]="1231";
	     decodervalues[6]="1114";
	     decodervalues[7]="1312";
	     decodervalues[8]="1213";
	     decodervalues[9]="3112";
		
		Bitmap bm = image;
		  		
	    BitMap bp = null;	

		
		 
		    bp = new BitMap("image",bm);
		    int width = bp.getWidth();
			int height = bp.getHeight();
			short[][] imageArray = bp.getPixels();
			   try{   
				   if(num2>0 && num2 < 29)
				   {
				   for (int k = 1; k < height; k++){
			            for (int l = 1; l < width; l++){
			            		if(k==height-l)
			            		{
			            			
			            			if(imageArray[k][l]>125)
			            			{
			            				if(widthcounter0>0)
			            				{
			            				 myList.add(widthcounter0);
			            				}
			            			//	bp.setPixel(k, l, (short)255);
			                  //      System.out.println("white"+imageArray[k][l]);
			                            widthcounter0=0;
			                            widthcounter1++;
			                           
			                            
			            			}
			            		else
			            			{
			            				if(widthcounter1>0)
			            				{
			            				  myList.add(widthcounter1);
			            				}

			            			//	bp.setPixel(k, l, (short)0);
			            		//		System.out.println("black"+imageArray[k][l]);
			            				widthcounter1=0;
			            				widthcounter0++;
			            			} 
			            		
			            	
			            	                    
			                    
			            		}
			            		}
			            } 
				   Collections.reverse(myList);
				   }
				   else if(num2>38 && num2<69)
				   {
				   for (int k = 1; k < height; k++){
				            for (int l = 1; l < width; l++){
				            		if(k==l)
				            		{
				            			
				            			if(imageArray[k][l]>125)
				            			{
				            				if(widthcounter0>0)
				            				{
				            				 myList.add(widthcounter0);
				            				}
				            		//		bp.setPixel(k, l, (short)255);
				                  //      System.out.println("white"+imageArray[k][l]);
				                            widthcounter0=0;
				                            widthcounter1++;
				                           
				                            
				            			}
				            		else
				            			{
				            				if(widthcounter1>0)
				            				{
				            				  myList.add(widthcounter1);
				            				}

				            		//		bp.setPixel(k, l, (short)0);
				            		//		System.out.println("black"+imageArray[k][l]);
				            				widthcounter1=0;
				            				widthcounter0++;
				            			} 
				            		
				            	
				            	                    
				                    
				            		}
				            		}
				            } 
				 Collections.reverse(myList);
				   }
				   else if(num2>68 && num2<73)
				   {
				  
				            for (int l = 1; l < width; l++){
				            		
				            			
				            			if(imageArray[height/2][l]>125)
				            			{
				            				if(widthcounter0>0)
				            				{
				            				 myList.add(widthcounter0);
				            				}
				            	//			bp.setPixel(height/2, l, (short)255);
				                  //      System.out.println("white"+imageArray[k][l]);
				                            widthcounter0=0;
				                            widthcounter1++;
				                           
				                            
				            			}
				            		else
				            			{
				            				if(widthcounter1>0)
				            				{
				            				  myList.add(widthcounter1);
				            				}

				            		//		bp.setPixel(height/2, l, (short)0);
				            		//		System.out.println("black"+imageArray[k][l]);
				            				widthcounter1=0;
				            				widthcounter0++;
				            			} 
				            		
				            	
				            	                    
				                    
				            		}
				            Collections.reverse(myList);
				   }
				   else if(num2>28 && num2<39)
				   {
				  
				            for (int k = 1; k < height; k++){
				            		
				            			
				            			if(imageArray[k][width/2-10]>125)
				            			{
				            				if(widthcounter0>0)
				            				{
				            				 myList.add(widthcounter0);
				            				}
				            		//		bp.setPixel(k, width/2-10, (short)255);
				                  //      System.out.println("white"+imageArray[k][l]);
				                            widthcounter0=0;
				                            widthcounter1++;
				                           
				                            
				            			}
				            		else
				            			{
				            				if(widthcounter1>0)
				            				{
				            				  myList.add(widthcounter1);
				            				}

				            		//		bp.setPixel(k, width/2-10, (short)0);
				            		//		System.out.println("black"+imageArray[k][l]);
				            				widthcounter1=0;
				            				widthcounter0++;
				            			} 
				            		
				            	
				            	                    
				                    
				            		}
				            
				  Collections.reverse(myList);
				   }
				   else if(num2>72 && num2 < 85)
				   {
				   for (int k = 1; k < height; k++){
			            for (int l = 1; l < width; l++){
			            		if(k==height-l)
			            		{
			            			
			            			if(imageArray[k][l]>125)
			            			{
			            				if(widthcounter0>0)
			            				{
			            				 myList.add(widthcounter0);
			            				}
			            		//		bp.setPixel(k, l, (short)255);
			                  //      System.out.println("white"+imageArray[k][l]);
			                            widthcounter0=0;
			                            widthcounter1++;
			                           
			                            
			            			}
			            		else
			            			{
			            				if(widthcounter1>0)
			            				{
			            				  myList.add(widthcounter1);
			            				}

			            		//		bp.setPixel(k, l, (short)0);
			            		//		System.out.println("black"+imageArray[k][l]);
			            				widthcounter1=0;
			            				widthcounter0++;
			            			} 
			            		
			            	
			            	                    
			                    
			            		}
			            		}
			            } 
				   }
				   else if(num2>84 && num2<89)
				   {
				  
				            for (int k = 1; k < height; k++){
				            		
				            			
				            			if(imageArray[k][width/2+10]>125)
				            			{
				            				if(widthcounter0>0)
				            				{
				            				 myList.add(widthcounter0);
				            				}
				            		//		bp.setPixel(k, width/2+10, (short)255);
				                  //      System.out.println("white"+imageArray[k][l]);
				                            widthcounter0=0;
				                            widthcounter1++;
				                           
				                            
				            			}
				            		else
				            			{
				            				if(widthcounter1>0)
				            				{
				            				  myList.add(widthcounter1);
				            				}

				            		//		bp.setPixel(k, width/2+10, (short)0);
				            		//		System.out.println("black"+imageArray[k][l]);
				            				widthcounter1=0;
				            				widthcounter0++;
				            			} 
				            		
				            	
				            	                    
				                    
				            		}
				  
				   }
				   else if(num2>88 && num2<105)
				   {
				   for (int k = 1; k < height; k++){
				            for (int l = 1; l < width; l++){
				            		if(k==l)
				            		{
				            			
				            			if(imageArray[k][l]>125)
				            			{
				            				if(widthcounter0>0)
				            				{
				            				 myList.add(widthcounter0);
				            				}
				            		//		bp.setPixel(k, l, (short)255);
				                  //      System.out.println("white"+imageArray[k][l]);
				                            widthcounter0=0;
				                            widthcounter1++;
				                           
				                            
				            			}
				            		else
				            			{
				            				if(widthcounter1>0)
				            				{
				            				  myList.add(widthcounter1);
				            				}

				            		//		bp.setPixel(k, l, (short)0);
				            		//		System.out.println("black"+imageArray[k][l]);
				            				widthcounter1=0;
				            				widthcounter0++;
				            			} 
				            		
				            	
				            	                    
				                    
				            		}
				            		}
				            } 
				   }
				   else if(num2>104 && num2<108)
				   {
				  
				            for (int l = 1; l < width; l++){
				            		
				            			
				            			if(imageArray[height/2][l]>125)
				            			{
				            				if(widthcounter0>0)
				            				{
				            				 myList.add(widthcounter0);
				            				}
				            		//		bp.setPixel(height/2, l, (short)255);
				                  //      System.out.println("white"+imageArray[k][l]);
				                            widthcounter0=0;
				                            widthcounter1++;
				                           
				                            
				            			}
				            		else
				            			{
				            				if(widthcounter1>0)
				            				{
				            				  myList.add(widthcounter1);
				            				}

				            		//		bp.setPixel(height/2, l, (short)0);
				            		//		System.out.println("black"+imageArray[k][l]);
				            				widthcounter1=0;
				            				widthcounter0++;
				            			} 
				            		
				            	
				            	                    
				                    
				            		}
				   }
				    Iterator<Integer> myListIterator = myList.iterator(); 
				    int divide2=0;
	                int dividecount=0;
				    int divide3 =0;
				    int divide4=0;
				    int dividenumbermax=0;
				       while (myListIterator.hasNext()) {
				    	   
				           int list = myListIterator.next();     
				          
				           if(list/2==1)
				           {
				        	   divide2++;
				           }
				           if(list/3==1)
				           {
				        	   divide3++;
				           }
				           if(list/4==1)
				           {
				        	   divide4++;
				           }  
				       }
				       dividenumbermax=divide2;
				       dividecount=2;
				       if(divide3>dividenumbermax)
				       {
				    	
				    	   dividecount=3;
				       }
				       if(divide4>dividenumbermax)
				       {
				    	 
				    	   dividecount=4;
				       }
				       
				       System.out.println("divide2 " + divide2 +"divide3 "+ divide3 + "divide4" + divide4);
				       int zerocounter=0;
				       Iterator<Integer> myListIterator3 = myList.iterator(); 
				       while (myListIterator3.hasNext()) {
				          if(myListIterator3.next()/dividecount==0)
				          {
				        	zerocounter++;  
				          }
				    	   
				           
				       }
				       Iterator<Integer> myListIterator4 = myList.iterator(); 
				       if(zerocounter<10)
				       {
				    	   while (myListIterator4.hasNext()) {
				    		   
					           String arraywidths = ""+myListIterator4.next()/dividecount;
				    	       widthbar.add(arraywidths);
				       }
				       }
				    	   else
				    	   {
				    		   while (myListIterator4.hasNext()) {
					    		   
						           String arraywidths = ""+myListIterator4.next()/(dividecount-1);
					    	       widthbar.add(arraywidths);
				    	   }
				    	   }
				    String[] strarray = widthbar.toArray(new String[0]);
				        System.out.println("string array"+Arrays.toString(strarray));
				        int firstpatternbuffer=0;
				      
				      for(int k=0;k<strarray.length;k++)
				       {
				    	 //  System.out.println(strarray[k] );
				    	 /*  if(strarray[k].equalsIgnoreCase("1"))
				    	   {
				    		   groupcount++;
				    		  
				    		   if(groupcount==3 &&( k < (strarray.length/2)))
				        	   {
				        		   myList2.add(k);
				        		 break;
				        		   
				        	   }
				    		   
				    		  
				    		   
				    	   } */
				    	 
				    	    if(strarray[k].equalsIgnoreCase("4") && strarray[k+1].equalsIgnoreCase("2") && strarray[k+2].equalsIgnoreCase("1") && strarray[k+3].equalsIgnoreCase("1"))
				    		    {
				    		    	firstpatternbuffer=k;
				    		    	break;
				    		    }
				    	   else if(strarray[k].equalsIgnoreCase("3") && strarray[k+1].equalsIgnoreCase("2") && strarray[k+2].equalsIgnoreCase("1") && strarray[k+3].equalsIgnoreCase("1"))
				    		    {
				    		    	firstpatternbuffer=k;
				    		    	break;
				    		    }
				
				    	   else if(strarray[k].equalsIgnoreCase("4") && strarray[k+1].equalsIgnoreCase("3") && strarray[k+2].equalsIgnoreCase("1") && strarray[k+3].equalsIgnoreCase("1"))
		    		    {
		    		    	firstpatternbuffer=k;
		    		    	break;
		    		    }
				    	   else if(strarray[k].equalsIgnoreCase("3") && strarray[k+1].equalsIgnoreCase("2") && strarray[k+2].equalsIgnoreCase("0") && strarray[k+3].equalsIgnoreCase("1"))
		    		    {
		    		    	firstpatternbuffer=k;
		    		    	break;
		    		    }
				    	   else if(strarray[k].equalsIgnoreCase("3") && strarray[k+1].equalsIgnoreCase("2") && strarray[k+2].equalsIgnoreCase("2") && strarray[k+3].equalsIgnoreCase("1"))
		    		    {
		    		    	firstpatternbuffer=k;
		    		    	break;
		    		    }
				    	   else if(strarray[k].equalsIgnoreCase("3") && strarray[k+1].equalsIgnoreCase("2") && strarray[k+2].equalsIgnoreCase("1") && strarray[k+3].equalsIgnoreCase("2"))
		    		    {
		    		    	firstpatternbuffer=k;
		    		    	break;
		    		    }
				    	   else if(strarray[k].equalsIgnoreCase("3") && strarray[k+1].equalsIgnoreCase("1") && strarray[k+2].equalsIgnoreCase("1") && strarray[k+3].equalsIgnoreCase("1"))
		    		    {
		    		    	firstpatternbuffer=k;
		    		    	break;
		    		    }
		    		   if(strarray[k].equalsIgnoreCase("3") && strarray[k+1].equalsIgnoreCase("2") && strarray[k+2].equalsIgnoreCase("1") && strarray[k+3].equalsIgnoreCase("0"))
		    		    {
		    		    	firstpatternbuffer=k;
		    		    	break;
		    		    }
		    		   if(strarray[k].equalsIgnoreCase("3") && strarray[k+1].equalsIgnoreCase("3") && strarray[k+2].equalsIgnoreCase("1") && strarray[k+3].equalsIgnoreCase("1"))
		    		    {
		    		    	firstpatternbuffer=k;
		    		    	break;
		    		    }
		    		   if(strarray[k].equalsIgnoreCase("2") && strarray[k+1].equalsIgnoreCase("2") && strarray[k+2].equalsIgnoreCase("1") && strarray[k+3].equalsIgnoreCase("1"))
		    		    {
		    		    	firstpatternbuffer=k;
		    		    	break;
		    		    }
		    		/*   if(strarray[k].equalsIgnoreCase("1") && strarray[k+1].equalsIgnoreCase("1") && strarray[k+2].equalsIgnoreCase("0") ) //very dangerous condition
		    		    {
		    		    	firstpatternbuffer=k+3;
		    		    	break;
		    		    }
		    		   if(strarray[k].equalsIgnoreCase("0") && strarray[k+1].equalsIgnoreCase("1") && strarray[k+2].equalsIgnoreCase("1") ) //very dangerous condition
		    		    {
		    		    	firstpatternbuffer=k+3;
		    		    	break;
		    		    }*/
				       }
				       
				    
				       System.out.println("midpattern"+barwidth); 
				       int firstpattern=0;
				       if(firstpatternbuffer>0)
				       {
				    	   firstpattern=firstpatternbuffer;
				       }
				       else {
				           firstpattern = myList2.get(0)+1;
				       }
				 //      int lastpattern =myList2.get(myList2.size()-1);
				       
				     
				       System.out.println("first pattern "+ firstpattern + "middlepattern " + barwidth);
				       for(int i=firstpattern;i<=firstpattern+24;i++)
				       {
				    	   stringpattern=stringpattern+strarray[i];
				    	   counter1++;
				    	   if(counter1==5)
				    	   {
				    		   myList3.add(stringpattern);
				    		   counter1=1;
				    		   stringpattern="";
				    	   }
				    	  
				       }
				       stringpattern = "";
				       for(int j=firstpattern+29;j<strarray.length;j++)
				       {
				    	 
				    	   stringpattern=stringpattern+strarray[j];
				    	   counter2++;
				    	   if(counter2==5)
				    	   {
				    		   myList3.add(stringpattern);
				    		   counter2=1;
				    		   stringpattern="";
				    	   }
				    	   
				       }
				       Iterator<String> myListIterator2 = myList3.iterator(); 
				       while (myListIterator2.hasNext()) {
				           String indipattern = myListIterator2.next();     
				           System.out.println("indivual patterns"+indipattern);
				          
				       }
				       String[] array = myList3.toArray(new String[myList3.size()]);
				      
				       List<String> myList4=new ArrayList<String>();
				       for(int k =0 ;k<array.length;k++)
				       {
				    	   System.out.println(array[k]);
				       }
				       while(decoderfinal<array.length)
				       {
				    	   for(int r=0; r < decodervalues.length;r++)
				    	   {
				    		  // if(array[decoderfinal]!=null && array[decoderfinal].length()==4)
				    		   if(array[decoderfinal].equalsIgnoreCase(decodervalues[r]))
				    				   {
				    			   System.out.println("barcode decoded" + r);
				    			   finalbarcode.add(""+r);
				    			   z=1;
				    			  
				    		}
				    		   
				    		  
				    		   
				    		   
				    		   
				    		   
				    	   }
				    	   
				    	  

					       if((array[decoderfinal].equalsIgnoreCase("4211") || array[decoderfinal].equalsIgnoreCase("3111")) || array[decoderfinal].equalsIgnoreCase("3210") || 
					    		   array[decoderfinal].equalsIgnoreCase("3110") || array[decoderfinal].equalsIgnoreCase("4110") ||  array[decoderfinal].equalsIgnoreCase("3201")
					    		   ||  array[decoderfinal].equalsIgnoreCase("3101") || 
					    		   array[decoderfinal].equalsIgnoreCase("4210") ||
					    		   array[decoderfinal].equalsIgnoreCase("2210") ||
					    		   array[decoderfinal].equalsIgnoreCase("4220") || array[decoderfinal].equalsIgnoreCase("3311")
					    		   || array[decoderfinal].equalsIgnoreCase("4311") ||  array[decoderfinal].equalsIgnoreCase("2211"))
			    		   {
			    			  
			    			   System.out.println("barcode decoded" + 0);
			    			   finalbarcode.add(""+0);
			    			  
			    		   }
			    		   else if((array[decoderfinal].equalsIgnoreCase("2120") || array[decoderfinal].equalsIgnoreCase("2121")) || (array[decoderfinal].equalsIgnoreCase("3231") || array[decoderfinal].equalsIgnoreCase("2112") || array[decoderfinal].equalsIgnoreCase("3230")
			    				   || array[decoderfinal].equalsIgnoreCase("2231") || array[decoderfinal].equalsIgnoreCase("2130") || array[decoderfinal].equalsIgnoreCase("3221") 
			    				   || array[decoderfinal].equalsIgnoreCase("2321") || array[decoderfinal].equalsIgnoreCase("2220") ||  array[decoderfinal].equalsIgnoreCase("1221")))
			    		   {
			    			
			    			   System.out.println("barcode decoded" + 1);
			    			   finalbarcode.add(""+1);
			    			      		   }
			    		   else if((array[decoderfinal].equalsIgnoreCase("2123") || array[decoderfinal].equalsIgnoreCase("3122")
			    				   ||array[decoderfinal].equalsIgnoreCase("2132") || 
			    				   array[decoderfinal].equalsIgnoreCase("3132")) || array[decoderfinal].equalsIgnoreCase("1112") || array[decoderfinal].equalsIgnoreCase("2022") || array[decoderfinal].equalsIgnoreCase("3231"))
			    		   {
			    			
			    			   System.out.println("barcode decoded" + 2);
			    			   finalbarcode.add(""+2);
			    			  
			    		   }
			    		   else if((array[decoderfinal].equalsIgnoreCase("1311") || array[decoderfinal].equalsIgnoreCase("1410") || array[decoderfinal].equalsIgnoreCase("0411")|| array[decoderfinal].equalsIgnoreCase("1401") || array[decoderfinal].equalsIgnoreCase("2112")) || array[decoderfinal].equalsIgnoreCase("1511"))
			    		   {
			    			 
			    			   System.out.println("barcode decoded" + 3);
			    			   finalbarcode.add(""+3);
			    			  
			    		   }
			    		   else if((array[decoderfinal].equalsIgnoreCase("1142")|| array[decoderfinal].equalsIgnoreCase("1122") || array[decoderfinal].equalsIgnoreCase("0132") || array[decoderfinal].equalsIgnoreCase("0122") || array[decoderfinal].equalsIgnoreCase("1133") || array[decoderfinal].equalsIgnoreCase("2032") || array[decoderfinal].equalsIgnoreCase("2112")) || array[decoderfinal].equalsIgnoreCase("2022"))
			    		   {
			    			  
			    			   System.out.println("barcode decoded" + 4);
			    			   finalbarcode.add(""+4);
			    			  
			    		   }
			    		   else if((array[decoderfinal].equalsIgnoreCase("1341") || array[decoderfinal].equalsIgnoreCase("1230") || array[decoderfinal].equalsIgnoreCase("1123") || array[decoderfinal].equalsIgnoreCase("2112")) || array[decoderfinal].equalsIgnoreCase("1241"))
			    		   {
			    			
			    			   System.out.println("barcode decoded" + 5);
			    			   finalbarcode.add(""+5);

			    		   }
			    		   
			    		   else if((array[decoderfinal].equalsIgnoreCase("1125") || array[decoderfinal].equalsIgnoreCase("1105") || array[decoderfinal].equalsIgnoreCase("1106")) || 
			    				   (array[decoderfinal].equalsIgnoreCase("1113") ||  array[decoderfinal].equalsIgnoreCase("1013")
			    						   || array[decoderfinal].equalsIgnoreCase("1115") ))
			    		   {
			    			
			    			   System.out.println("barcode decoded" + 6);
			    			   finalbarcode.add(""+6);
			    		   }
			    		   else if((array[decoderfinal].equalsIgnoreCase("1403") || array[decoderfinal].equalsIgnoreCase("1413") || array[decoderfinal].equalsIgnoreCase("2112")) || array[decoderfinal].equalsIgnoreCase("2022") || array[decoderfinal].equalsIgnoreCase("1412") ||
			    				   array[decoderfinal].equalsIgnoreCase("0403") || array[decoderfinal].equalsIgnoreCase("0312") || array[decoderfinal].equalsIgnoreCase("0402") || array[decoderfinal].equalsIgnoreCase("0302"))
			    				  
			    		   {
			    			 
			    			   System.out.println("barcode decoded" + 7);
			    			   finalbarcode.add(""+7);

			    		   }
					       
			    		   else if((array[decoderfinal].equalsIgnoreCase("0314") || array[decoderfinal].equalsIgnoreCase("1313") || array[decoderfinal].equalsIgnoreCase("0313")) || 
			    				   array[decoderfinal].equalsIgnoreCase("1214") || array[decoderfinal].equalsIgnoreCase("1204") || array[decoderfinal].equalsIgnoreCase("0303") )
			    		   {
			    			
			    			   System.out.println("barcode decoded" + 8);
			    			   finalbarcode.add(""+8);
			    			   

			    		   }
			    		   else if(array[decoderfinal].equalsIgnoreCase("3102") || (array[decoderfinal].equalsIgnoreCase("3111") || (array[decoderfinal].equalsIgnoreCase("4112"))))
			    		   {
			    			
			    			   System.out.println("barcode decoded" + 9);
			    			   finalbarcode.add(""+9);

			    		   }
			    		 
						   	decoderfinal++;
				    	  
						   	
				       } 
				      
				      
			//	   System.out.println(Integer.parseInt(array[decoderfinal]));
				      
				       String[] finaldetectedbarcode = finalbarcode.toArray(new String[0]);
				       output=Arrays.toString(finaldetectedbarcode);
				       finaloutput=output.replaceAll("\\[", "").replaceAll("\\]","");
				        
				        speakOut();
				        Toast.makeText(this,finaloutput, Toast.LENGTH_LONG).show();
				} 
				   catch(Exception e)
				   {
					   System.out.println(e+ "exceptions");
				   } 
		    
		Bitmap bitmap = BitMapExtensions.exportToBitmap(imageArray, height, width);
		imageview.setImageBitmap(bitmap);
		bp = null;
		bm.recycle();
     	bm = null;
		 
          
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.skew_bar_code,
				menu);
		return true;
	}
	@Override
   

   
    public void onDestroy() {
		// Don't forget to shutdown!
		if (tts != null) {
			tts.stop();
			tts.shutdown();
		}
		super.onDestroy();
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub

		if (status == TextToSpeech.SUCCESS) {

			int result = tts.setLanguage(Locale.US);

			 tts.setPitch(50); //set pitch level

			 tts.setSpeechRate(1);// set speech speed rate

			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("TTS", "Language is not supported");
			} else {
			//	btnSpeak.setEnabled(true);
				speakOut();
			}

		} else {
			Log.e("TTS", "Initilization Failed");
		}
	
	}
	
	private void speakOut() {

		String text ="hi user reading barcode    " + finaloutput;

		tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
		
	}

}
