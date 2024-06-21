package org.example;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.value.ValueMap;
import org.springframework.security.authentication.AuthenticationManager;


public class LoginPage extends WebPage {
    @SpringBean
    private AuthenticationManager authenticationManager;
    public LoginPage() {
        add(new FeedbackPanel("feedback"));
        add(new LoginForm("loginForm"));


    }
    public class LoginForm extends Form<Void> {
        private static final String USERNAME = "username";
        private static final String PASSWORD = "password";
        private final ValueMap properties = new ValueMap();

        private String username;

        private String password;
        public LoginForm(String id) {
            super(id);
            add(new TextField<String>(USERNAME, new PropertyModel<String>(properties, USERNAME)));
            add(new PasswordTextField(PASSWORD, new PropertyModel<String>(properties, PASSWORD)));

        }


        @Override
        protected void onSubmit() {
            String username = properties.getString(USERNAME);
            String password = properties.getString(PASSWORD);
            if (MyAuthenticatedWebSession.get().authenticate(username, password)) {
                continueToOriginalDestination();
                setResponsePage(getApplication().getHomePage());
            } else {
                error("Login failed");
            }
        }

    }
}