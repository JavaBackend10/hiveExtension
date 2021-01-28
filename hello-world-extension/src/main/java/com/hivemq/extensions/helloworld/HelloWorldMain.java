
/*
 * Copyright 2018-present HiveMQ GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hivemq.extensions.helloworld;

import com.hivemq.extension.sdk.api.ExtensionMain;
import com.hivemq.extension.sdk.api.parameter.ExtensionStartInput;
import com.hivemq.extension.sdk.api.parameter.ExtensionStartOutput;
import com.hivemq.extension.sdk.api.parameter.ExtensionStopInput;
import com.hivemq.extension.sdk.api.parameter.ExtensionStopOutput;
import com.hivemq.extension.sdk.api.services.Services;

/**
 * This is the main class of the extension, which is instantiated either during
 * the HiveMQ start up process (if extension is enabled) or when HiveMQ is
 * already started by enabling the extension.
 *
 * @author Florian Limpöck
 * @since 4.0.0
 */
public class HelloWorldMain implements ExtensionMain {

	@Override
	public void extensionStart(ExtensionStartInput input, ExtensionStartOutput output) {
		// register the provider with the SecurityRegistry
		Services.securityRegistry().setAuthenticatorProvider(new MyAuthenticatorProvider());
	}

	@Override
	public void extensionStop(ExtensionStopInput input, ExtensionStopOutput output) {
		// Code to run when extension is stopped
	}
}
