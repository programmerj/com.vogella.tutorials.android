package com.vogella.android.dagger2simple.modules;

import android.app.Activity;

import com.vogella.android.dagger2simple.MainActivity;
import com.vogella.android.dagger2simple.NetworkApi;
import com.vogella.android.dagger2simple.components.IActivitySubcomponent;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {IActivitySubcomponent.class})
public abstract class ActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindYourActivityInjectorFactory(IActivitySubcomponent.Builder builder);
}
