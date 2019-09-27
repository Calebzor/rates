package hu.tvarga.rates.common.app.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import dagger.Module;
import dagger.Provides;
import hu.tvarga.rates.common.app.di.annotations.scope.ApplicationScoped;

@Module
public class ApiModule {

	@Provides
	@ApplicationScoped
	Gson provideGson() {
		GsonBuilder builder = new GsonBuilder();
		Gson310TypeAdapters.register(builder, ZonedDateTime.class, DateTimeFormatter.ISO_DATE);

		return builder.create();
	}
}