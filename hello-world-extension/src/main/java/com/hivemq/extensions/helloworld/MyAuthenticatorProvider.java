package com.hivemq.extensions.helloworld;

import com.hivemq.extension.sdk.api.auth.Authenticator;
import com.hivemq.extension.sdk.api.auth.parameter.AuthenticatorProviderInput;
import com.hivemq.extension.sdk.api.services.auth.provider.AuthenticatorProvider;

public class MyAuthenticatorProvider implements AuthenticatorProvider {

    @Override
    public Authenticator getAuthenticator(AuthenticatorProviderInput authenticatorProviderInput) {
        //return an instance of an Authenticator
        return new MyAuthenticator();
    }
}
