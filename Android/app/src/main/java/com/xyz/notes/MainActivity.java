package com.xyz.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.ClipData;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.speech.SpeechRecognizer;
import android.speech.RecognizerIntent;
import android.speech.RecognitionListener;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import com.google.gson.Gson;
import android.content.ClipboardManager;
import com.google.gson.reflect.TypeToken;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class MainActivity extends AppCompatActivity {
	
	public final int REQ_CD_PICK = 101;
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	private String a = "";
	private String b = "";
	private String c = "";
	private boolean voiceinput = false;
	private boolean texthide = false;
	private String message = "";
	private String message2 = "";
	private double font = 0;
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private EditText edittext1;
	private LinearLayout list;
	private ImageView imageview3;
	private TextView textview4;
	private TextView textview3;
	private ListView listview1;
	private LinearLayout _drawer_linear31;
	private ScrollView _drawer_vscroll1;
	private TextView _drawer_textview16;
	private AnalogClock _drawer_analogclock1;
	private TextView _drawer_textview1;
	private ImageView _drawer_imageview368;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear15;
	private LinearLayout _drawer_linear13;
	private LinearLayout _drawer_linear14;
	private LinearLayout _drawer_linear17;
	private LinearLayout _drawer_linear21;
	private LinearLayout _drawer_linear27;
	private LinearLayout _drawer_linear30;
	private ImageView _drawer_imageview17;
	private LinearLayout _drawer_linear2;
	private ImageView _drawer_imageview1;
	private ImageView _drawer_imageview366;
	private ImageView _drawer_imageview4;
	private ImageView _drawer_imageview367;
	private ImageView _drawer_imageview12;
	private LinearLayout _drawer_linear5;
	private LinearLayout _drawer_linear6;
	private ImageView _drawer_imageview5;
	private TextView _drawer_textview5;
	private ImageView _drawer_imageview6;
	private TextView _drawer_textview6;
	private LinearLayout _drawer_linear7;
	private LinearLayout _drawer_linear9;
	private ImageView _drawer_imageview7;
	private TextView _drawer_textview7;
	private ImageView _drawer_imageview9;
	private TextView _drawer_textview11;
	private LinearLayout _drawer_linear19;
	private LinearLayout _drawer_linear20;
	private ImageView _drawer_imageview10;
	private TextView _drawer_textview12;
	private ImageView _drawer_imageview11;
	private TextView _drawer_textview13;
	private LinearLayout _drawer_linear23;
	private LinearLayout _drawer_linear26;
	private ImageView _drawer_imageview13;
	private TextView _drawer_textview15;
	private ImageView _drawer_imageview14;
	private TextView _drawer_textview17;
	private LinearLayout _drawer_linear28;
	private LinearLayout _drawer_linear29;
	private ImageView _drawer_imageview15;
	private TextView _drawer_textview18;
	private ImageView _drawer_imageview16;
	private TextView _drawer_textview19;
	private SeekBar _drawer_seekbar1;
	private TextView _drawer_textview20;
	
	private AlertDialog.Builder d;
	private Intent i = new Intent();
	private TextToSpeech speak;
	private SharedPreferences save;
	private Intent pick = new Intent(Intent.ACTION_GET_CONTENT);
	private Calendar calendar = Calendar.getInstance();
	private AlertDialog.Builder dia;
	private SpeechRecognizer v;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(MainActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		edittext1 = findViewById(R.id.edittext1);
		list = findViewById(R.id.list);
		imageview3 = findViewById(R.id.imageview3);
		textview4 = findViewById(R.id.textview4);
		textview3 = findViewById(R.id.textview3);
		listview1 = findViewById(R.id.listview1);
		_drawer_linear31 = _nav_view.findViewById(R.id.linear31);
		_drawer_vscroll1 = _nav_view.findViewById(R.id.vscroll1);
		_drawer_textview16 = _nav_view.findViewById(R.id.textview16);
		_drawer_analogclock1 = _nav_view.findViewById(R.id.analogclock1);
		_drawer_textview1 = _nav_view.findViewById(R.id.textview1);
		_drawer_imageview368 = _nav_view.findViewById(R.id.imageview368);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_linear15 = _nav_view.findViewById(R.id.linear15);
		_drawer_linear13 = _nav_view.findViewById(R.id.linear13);
		_drawer_linear14 = _nav_view.findViewById(R.id.linear14);
		_drawer_linear17 = _nav_view.findViewById(R.id.linear17);
		_drawer_linear21 = _nav_view.findViewById(R.id.linear21);
		_drawer_linear27 = _nav_view.findViewById(R.id.linear27);
		_drawer_linear30 = _nav_view.findViewById(R.id.linear30);
		_drawer_imageview17 = _nav_view.findViewById(R.id.imageview17);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_imageview366 = _nav_view.findViewById(R.id.imageview366);
		_drawer_imageview4 = _nav_view.findViewById(R.id.imageview4);
		_drawer_imageview367 = _nav_view.findViewById(R.id.imageview367);
		_drawer_imageview12 = _nav_view.findViewById(R.id.imageview12);
		_drawer_linear5 = _nav_view.findViewById(R.id.linear5);
		_drawer_linear6 = _nav_view.findViewById(R.id.linear6);
		_drawer_imageview5 = _nav_view.findViewById(R.id.imageview5);
		_drawer_textview5 = _nav_view.findViewById(R.id.textview5);
		_drawer_imageview6 = _nav_view.findViewById(R.id.imageview6);
		_drawer_textview6 = _nav_view.findViewById(R.id.textview6);
		_drawer_linear7 = _nav_view.findViewById(R.id.linear7);
		_drawer_linear9 = _nav_view.findViewById(R.id.linear9);
		_drawer_imageview7 = _nav_view.findViewById(R.id.imageview7);
		_drawer_textview7 = _nav_view.findViewById(R.id.textview7);
		_drawer_imageview9 = _nav_view.findViewById(R.id.imageview9);
		_drawer_textview11 = _nav_view.findViewById(R.id.textview11);
		_drawer_linear19 = _nav_view.findViewById(R.id.linear19);
		_drawer_linear20 = _nav_view.findViewById(R.id.linear20);
		_drawer_imageview10 = _nav_view.findViewById(R.id.imageview10);
		_drawer_textview12 = _nav_view.findViewById(R.id.textview12);
		_drawer_imageview11 = _nav_view.findViewById(R.id.imageview11);
		_drawer_textview13 = _nav_view.findViewById(R.id.textview13);
		_drawer_linear23 = _nav_view.findViewById(R.id.linear23);
		_drawer_linear26 = _nav_view.findViewById(R.id.linear26);
		_drawer_imageview13 = _nav_view.findViewById(R.id.imageview13);
		_drawer_textview15 = _nav_view.findViewById(R.id.textview15);
		_drawer_imageview14 = _nav_view.findViewById(R.id.imageview14);
		_drawer_textview17 = _nav_view.findViewById(R.id.textview17);
		_drawer_linear28 = _nav_view.findViewById(R.id.linear28);
		_drawer_linear29 = _nav_view.findViewById(R.id.linear29);
		_drawer_imageview15 = _nav_view.findViewById(R.id.imageview15);
		_drawer_textview18 = _nav_view.findViewById(R.id.textview18);
		_drawer_imageview16 = _nav_view.findViewById(R.id.imageview16);
		_drawer_textview19 = _nav_view.findViewById(R.id.textview19);
		_drawer_seekbar1 = _nav_view.findViewById(R.id.seekbar1);
		_drawer_textview20 = _nav_view.findViewById(R.id.textview20);
		d = new AlertDialog.Builder(this);
		speak = new TextToSpeech(getApplicationContext(), null);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);
		pick.setType("*/*");
		pick.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		dia = new AlertDialog.Builder(this);
		v = SpeechRecognizer.createSpeechRecognizer(this);
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				c = b;
				b = _charSeq;
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				edittext1.setText(listmap.get((int)_position).get("save").toString());
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				((EditText)edittext1).setSelection((int)edittext1.getText().toString().length(), (int)edittext1.getText().toString().length());
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				edittext1.setText(save.getString("autosave", ""));
				d.setTitle("ShadowNote");
				d.setMessage("Delete save?");
				d.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						listmap.remove((int)(_position));
						save.edit().putString("list", new Gson().toJson(listmap)).commit();
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
				});
				d.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.setNegativeButton(" ", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
				return true;
			}
		});
		
		v.setRecognitionListener(new RecognitionListener() {
			@Override
			public void onReadyForSpeech(Bundle _param1) {
			}
			
			@Override
			public void onBeginningOfSpeech() {
			}
			
			@Override
			public void onRmsChanged(float _param1) {
			}
			
			@Override
			public void onBufferReceived(byte[] _param1) {
			}
			
			@Override
			public void onEndOfSpeech() {
			}
			
			@Override
			public void onPartialResults(Bundle _param1) {
			}
			
			@Override
			public void onEvent(int _param1, Bundle _param2) {
			}
			
			@Override
			public void onResults(Bundle _param1) {
				final ArrayList<String> _results = _param1.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
				final String _result = _results.get(0);
				edittext1.setText(edittext1.getText().toString().concat(" ".concat(_result)));
				voiceinput = false;
				((EditText)edittext1).setSelection((int)edittext1.getText().toString().length(), (int)edittext1.getText().toString().length());
			}
			
			@Override
			public void onError(int _param1) {
				final String _errorMessage;
				switch (_param1) {
					case SpeechRecognizer.ERROR_AUDIO:
					_errorMessage = "audio error";
					break;
					
					case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
					_errorMessage = "speech timeout";
					break;
					
					case SpeechRecognizer.ERROR_NO_MATCH:
					_errorMessage = "speech no match";
					break;
					
					case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
					_errorMessage = "recognizer busy";
					break;
					
					case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
					_errorMessage = "recognizer insufficient permissions";
					break;
					
					default:
					_errorMessage = "recognizer other error";
					break;
				}
				if (_errorMessage.contains("busy")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Voice input already running.");
				}
				else {
					voiceinput = false;
					if (_errorMessage.contains("other error")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Check your internet connection.");
					}
					else {
						if (_errorMessage.contains("no match")) {
							SketchwareUtil.showMessage(getApplicationContext(), "Please repeat.");
						}
						else {
							if (_errorMessage.contains("permission")) {
								SketchwareUtil.showMessage(getApplicationContext(), "No permission to access the microphone.");
							}
							else {
								SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
							}
						}
					}
				}
			}
		});
		
		_drawer_textview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://sites.google.com/view/nclear/home/privacy-policy"));
				startActivity(i);
			}
		});
		
		_drawer_textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d.setTitle("ShadowNote");
				d.setMessage("by Nclear PROJECT\nVersion 2.7");
				d.setPositiveButton("More apps", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						i.setAction(Intent.ACTION_VIEW);
						i.setData(Uri.parse("https://play.google.com/store/apps/dev?id=8464771456666865778"));
						startActivity(i);
					}
				});
				d.setNeutralButton("Close", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.setNegativeButton("Rate", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						i.setAction(Intent.ACTION_VIEW);
						i.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.xyz.notes"));
						startActivity(i);
					}
				});
				d.create().show();
			}
		});
		
		_drawer_imageview368.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_imageview17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				SketchwareUtil.showMessage(getApplicationContext(), "Characters: ".concat(String.valueOf((long)(edittext1.getText().toString().length())).concat("\nCharacters without spaces: ".concat(String.valueOf((long)(edittext1.getText().toString().length())).replace(" ", "").concat("\nSpaces (words): ".concat(String.valueOf((long)(edittext1.getText().toString().length() - Double.parseDouble(String.valueOf((long)(edittext1.getText().toString().length())).replace(" ", ""))))))))));
			}
		});
		
		_drawer_imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				_drawer.closeDrawer(GravityCompat.START);
				if (edittext1.getSelectionStart() == edittext1.getSelectionEnd()) {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", edittext1.getText().toString()));
				}
				else {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", edittext1.getText().toString().substring((int)(edittext1.getSelectionStart()), (int)(edittext1.getSelectionEnd()))));
				}
			}
		});
		
		_drawer_imageview366.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				_drawer.closeDrawer(GravityCompat.START);
				if (edittext1.getSelectionStart() == edittext1.getSelectionEnd()) {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", edittext1.getText().toString()));
					edittext1.setText("");
				}
				else {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", edittext1.getText().toString().substring((int)(edittext1.getSelectionStart()), (int)(edittext1.getSelectionEnd()))));
					edittext1.setText(edittext1.getText().toString().replace(edittext1.getText().toString().substring((int)(edittext1.getSelectionStart()), (int)(edittext1.getSelectionEnd())), ""));
				}
			}
		});
		
		_drawer_imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				ClipboardManager paste = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
				textview4.setText(paste.getText());
				if (edittext1.getSelectionStart() == edittext1.getSelectionEnd()) {
					edittext1.setText(edittext1.getText().toString().concat(textview4.getText().toString()));
				}
				else {
					edittext1.setText(edittext1.getText().toString().replace(edittext1.getText().toString().substring((int)(edittext1.getSelectionStart()), (int)(edittext1.getSelectionEnd())), textview4.getText().toString()));
				}
				textview4.setText("");
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_imageview367.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				((EditText)edittext1).selectAll();
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_imageview12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				edittext1.setText(c);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (texthide) {
					edittext1.setVisibility(View.VISIBLE);
					texthide = false;
				}
				else {
					edittext1.setVisibility(View.GONE);
					texthide = true;
				}
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				if (edittext1.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Empty note!");
				}
				else {
					{
						HashMap<String, Object> _item = new HashMap<>();
						_item.put("save", edittext1.getText().toString());
						listmap.add(_item);
					}
					
					save.edit().putString("list", new Gson().toJson(listmap)).commit();
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					SketchwareUtil.showMessage(getApplicationContext(), "Saved!");
				}
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				_drawer.closeDrawer(GravityCompat.START);
				if (edittext1.getSelectionStart() == edittext1.getSelectionEnd()) {
					edittext1.setText("");
				}
				else {
					edittext1.setText(edittext1.getText().toString().replace(edittext1.getText().toString().substring((int)(edittext1.getSelectionStart()), (int)(edittext1.getSelectionEnd())), ""));
				}
				((EditText)edittext1).setSelection((int)edittext1.getText().toString().length(), (int)edittext1.getText().toString().length());
			}
		});
		
		_drawer_linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				_drawer.closeDrawer(GravityCompat.START);
				if (edittext1.getSelectionStart() == edittext1.getSelectionEnd()) {
					a = edittext1.getText().toString();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Sharing selected text.");
					a = edittext1.getText().toString().substring((int)(edittext1.getSelectionStart()), (int)(edittext1.getSelectionEnd()));
				}
				 Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain");  i.putExtra(android.content.Intent.EXTRA_TEXT, a); startActivity(Intent.createChooser(i,"Share"));
			}
		});
		
		_drawer_linear19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				if (speak.isSpeaking()) {
					speak.stop();
				}
				else {
					if (!edittext1.getText().toString().equals("")) {
						speak.speak(edittext1.getText().toString(), TextToSpeech.QUEUE_ADD, null);
						SketchwareUtil.showMessage(getApplicationContext(), "Loading...");
					}
				}
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_linear20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				Intent _intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				_intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());
				_intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
				_intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
				v.startListening(_intent);
				SketchwareUtil.showMessage(getApplicationContext(), "Listening...");
				voiceinput = true;
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_linear23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				_drawer.closeDrawer(GravityCompat.START);
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://translate.google.com/?text=".concat(edittext1.getText().toString())));
				startActivity(i);
			}
		});
		
		_drawer_linear26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				_drawer.closeDrawer(GravityCompat.START);
				dia.setTitle("ShadowNote");
				dia.setMessage("To be replaced:");
				final EditText edittext57 = new 
				EditText(MainActivity.this); 
				LinearLayout.LayoutParams
				Ipar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT); edittext57.setLayoutParams(Ipar);
				dia.setView(edittext57);
				dia.setPositiveButton("Next", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						message = edittext57.getText().toString();
						dia.setMessage("Replace with:");
						final EditText edittext57 = new 
						EditText(MainActivity.this); 
						LinearLayout.LayoutParams
						Ipar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT); edittext57.setLayoutParams(Ipar);
						dia.setView(edittext57);
						dia.setPositiveButton("Done", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								message2 = edittext57.getText().toString();
								edittext1.setText(edittext1.getText().toString().replace(message, message2));
								((EditText)edittext1).setSelection((int)edittext1.getText().toString().length(), (int)edittext1.getText().toString().length());
							}
						});
						dia.create().show();
					}
				});
				dia.create().show();
			}
		});
		
		_drawer_linear28.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				_drawer.closeDrawer(GravityCompat.START);
				FileUtil.writeFile("/storage/emulated/0/Notes/temp.txt", "test");
				if (FileUtil.readFile("/storage/emulated/0/Notes/temp.txt").equals("test")) {
					startActivityForResult(pick, REQ_CD_PICK);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "No permission to access the storage.");
				}
				FileUtil.deleteFile("/storage/emulated/0/Notes/temp.txt");
			}
		});
		
		_drawer_linear29.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				FileUtil.writeFile("/storage/emulated/0/Notes/temp.txt", "test");
				if (FileUtil.readFile("/storage/emulated/0/Notes/temp.txt").equals("test")) {
					calendar = Calendar.getInstance();
					FileUtil.writeFile("/storage/emulated/0/Notes/".concat(new SimpleDateFormat("dd_MM_yyyy HH-mm-ss").format(calendar.getTime()).concat(".txt")), edittext1.getText().toString());
					SketchwareUtil.showMessage(getApplicationContext(), "File saved to Phone/Notes/".concat(new SimpleDateFormat("dd_MM_yyyy HH-mm-ss").format(calendar.getTime()).concat(".txt")));
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "No permission to access the storage.");
				}
				FileUtil.deleteFile("/storage/emulated/0/Notes/temp.txt");
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				edittext1.setVisibility(View.VISIBLE);
				texthide = false;
				save.edit().putString("font", String.valueOf((long)(_progressValue))).commit();
				edittext1.setTextSize((int)(_progressValue + 5) * 2);
				_drawer_textview20.setText("Font size: ".concat(String.valueOf((long)((Double.parseDouble(save.getString("font", "")) + 5) * 2))));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
	}
	
	private void initializeLogic() {
		edittext1.setText(save.getString("autosave", ""));
		if (save.getString("font", "").equals("")) {
			save.edit().putString("font", "10").commit();
		}
		_drawer_seekbar1.setProgress((int)Double.parseDouble(save.getString("font", "")));
		edittext1.setTextSize((int)(Double.parseDouble(save.getString("font", "")) + 5) * 2);
		_drawer_textview20.setText("Font size: ".concat(String.valueOf((long)((Double.parseDouble(save.getString("font", "")) + 5) * 2))));
		if (!save.getString("list", "").equals("")) {
			listmap = new Gson().fromJson(save.getString("list", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		listview1.setAdapter(new Listview1Adapter(listmap));
		((EditText)edittext1).setSelection((int)edittext1.getText().toString().length(), (int)edittext1.getText().toString().length());
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_PICK:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				edittext1.setText(FileUtil.readFile(_filePath.get((int)(0))));
				((EditText)edittext1).setSelection((int)edittext1.getText().toString().length(), (int)edittext1.getText().toString().length());
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		if (texthide) {
			edittext1.setVisibility(View.VISIBLE);
			texthide = false;
		}
		else {
			if (speak.isSpeaking()) {
				speak.stop();
			}
			else {
				if (voiceinput) {
					v.stopListening();
				}
				else {
					finish();
				}
			}
		}
	}
	
	@Override
	public void onStop() {
		super.onStop();
		save.edit().putString("autosave", edittext1.getText().toString()).commit();
		SketchwareUtil.showMessage(getApplicationContext(), "Autosaved");
		if (speak.isSpeaking()) {
			v.stopListening();
		}
		if (voiceinput) {
			speak.stop();
		}
	}
	
	    public void onLowMemory() {
		        super.onLowMemory();
		        SketchwareUtil.showMessage(getApplicationContext(), "RAM memory is almost full. Try to remove some text.");
		        }
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.custom, null);
			}
			
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			textview1.setText(listmap.get((int)_position).get("save").toString());
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}