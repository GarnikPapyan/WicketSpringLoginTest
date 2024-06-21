package org.example;

import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.example.pages.HomePage;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WicketApplication extends AuthenticatedWebApplication {

    @Override
    public Class<? extends WebPage> getHomePage()
    {
        return HomePage.class;
    }

    @Override
    public void init()
    {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        mountPage("login", LoginPage.class);
        mountPage("home", HomePage.class);

    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return LoginPage.class;
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return MyAuthenticatedWebSession.class;
    }
}
