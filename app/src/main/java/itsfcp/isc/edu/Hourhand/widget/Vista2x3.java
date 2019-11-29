package itsfcp.isc.edu.Hourhand.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.RemoteViews;

import itsfcp.isc.edu.Hourhand.Activity_Personalizacion;
import itsfcp.isc.edu.Hourhand.R;
import itsfcp.isc.edu.Hourhand.WidgetService;

/**
 * Implementation of App Widget functionality.
 */
public class Vista2x3 extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.vista2x3);
        views.setTextViewText(R.id.appwidget_text, widgetText);
        setRemoteAdapter(context, views);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);

            Intent intent = new Intent(context, Activity_Personalizacion.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,0);

            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.vista2x3);
            views.setOnClickPendingIntent(R.id.redirijir,pendingIntent);


            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
    private static void setRemoteAdapter(Context context, @NonNull final RemoteViews views) {
        views.setRemoteAdapter(R.id.lista,
                new Intent(context, WidgetService.class));
    }
}

