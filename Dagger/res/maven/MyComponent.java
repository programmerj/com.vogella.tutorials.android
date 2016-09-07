package com.vogella.java.dagger2.component;

import javax.inject.Singleton;

import com.vogella.java.dagger2.BackendService;
import com.vogella.java.dagger2.modules.BackEndServiceModule;
import com.vogella.java.dagger2.modules.UserModule;

import dagger.Component;

@Singleton
@Component(modules = { UserModule.class, BackEndServiceModule.class })
public interface MyComponent {

    // provide the dependency for dependent components
    // (not needed for single-component setups)
	BackendService provideBackendService();
	
	// allow to inject into our Main class
	// method name not important
	void inject(Main main); #<1>
}
