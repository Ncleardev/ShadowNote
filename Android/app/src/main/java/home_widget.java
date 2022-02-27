package com.xyz.notes;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RemoteViews;


public class home_widget extends AppWidgetProvider {
	
	float radius = 20f;


	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
						 int[] appWidgetIds) {
		for (int i = 0; i < appWidgetIds.length; i++) {
			int currentWidgetId = appWidgetIds[i];
			Intent intent = new Intent(Intent.ACTION_VIEW);
			PendingIntent pending = PendingIntent.getActivity(context, 0,
															  intent, 0);
			RemoteViews views = new RemoteViews(context.getPackageName(),
												R.layout.widget);
			appWidgetManager.updateAppWidget(currentWidgetId, views);
            
            
		}
	}
}

